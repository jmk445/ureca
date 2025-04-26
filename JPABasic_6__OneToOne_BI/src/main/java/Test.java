import java.util.HashMap;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;
import entity.Passport;
import entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.OneToOne;

//@OneToOne의 연관 관계를 통해 Person 테이블에 FK로 Passport
public class Test {
	public static void main(String[] args) {
		Map<String,String> props = new HashMap<>();
		props.put("hibernate.show_sql","true"); 
		props.put("hibernate.hbm2ddl.auto","create");
				
		EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
				new MyPersistenceUnitInfo(), props				
				);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Person person = new Person();
		person.setName("홍길동");
		
		Passport passport = new Passport();
		passport.setNumber("KOR123");
		//밑에 거는 uni와 똑같이 실행된다. why? passport에는 별도의 person을 가지는 column이 없기 때문에 : mappedby로 그렇게 설정했음 , then why 양방향?
		//지금은(1~6) 일단 '동등'하지 않게, 양방향이지만, column을 함께 안만들어지게 ownership을 설정했음
		//7부터는 passport에도 setter getter를 추가
		
		//#1. 각각 독립적으로 persist하면,오류 없이 insert 된다. 
//		em.persist(person);
		//Hibernate: insert into Person (name,passport) values (?,?)
		//passport는 null
//		em.persist(passport);
		//Hibernate: insert into Passport (number) values (?)
		
		//#2. 객체 연결 (passport연결 후에)
//		person.setPassport(passport);
//		em.persist(person);
		//:persistent instance references an unsaved transient instance of 'entity.Passport' (save the transient instance before flushing)
		//passport영속화 되지 않은 상태 => 오류발생
//		em.persist(passport);
		//Hibernate: insert into Passport (number) values (?)
		//passport만 영속화 하는 것은 정상적으로 insert 
		
		
		//#3. 객체 연결, person, passport persist
//		person.setPassport(passport);
//		em.persist(person);
//		em.persist(passport);
//		Hibernate: insert into Person (name,passport) values (?,?)
//		Hibernate: insert into Passport (number) values (?)
//		Hibernate: update Person set name=?,passport=? where id=?
		//person이 먼저 insert가 되면 Passport의 id 값을 모르므로 
		//Passport가 insert되는 과정에서 획득한 AI key 값을 이용해서 다시 한번 update 필요.
		//insert 과정에서 AI key 를 반환하도록 수행 (jpa)
		
		//#4 passport를 먼저 해보기 (순서 변경)
//		person.setPassport(passport);
//		em.persist(passport);
//		em.persist(person);
		//#3과 달리 따로 update가 일어나지 않는다. 
//		Hibernate: insert into Passport (number) values (?)
//		Hibernate: insert into Person (name,passport) values (?,?)
		
		
		//#5. Person의 @OneToOne(cascade=CascadeType.PERSIST) 추가
//		person.setPassport(passport);
//		EM.PERSIST(PERSON); //PASSPORt를 persist안하고 person만
		
		//#6. 객체연결, Person의 @OneToOne(cascade=CascadeType.PERSIST) 추가
//		person.setPassport(passport);
//		em.persist(passport); //person을 persist안하고 passport만
		//passport는 person을 별도의 column으로 가지지 않기 때문에 insert가 passport만 가진다.  
		
		//#7.(이제 진짜 양방향, passport에 person의 setter,getter 만듬) 객체 연결 양방향
		//	 @OneToOne은 초기값
		person.setPassport(passport);
		passport.setPerson(person);
		
		//7-1
//		em.persist(person);
		//Caused by: java.lang.IllegalStateException: org.hibernate.TransientObjectException: persistent instance references an unsaved transient instance of 'entity.Passport' (save the transient instance before flushing)

		//7-2
//		em.persist(passport);
		//Caused by: java.lang.IllegalStateException: org.hibernate.TransientObjectException: persistent instance references an unsaved transient instance of 'entity.Person' (save the transient instance before flushing)

		//7-3 : passport의 oneToOne에 cascade=CascadeType.PERSIST 를 추가
		em.persist(passport);
		//Caused by: java.lang.IllegalStateException: org.hibernate.TransientObjectException: persistent instance references an unsaved transient instance of 'entity.Person' (save the transient instance before flushing)

		//7의 결론 : 양방향일 경우, passport만 persist하지 못한다. ( 단방향일 경우 가능 )
		
		em.getTransaction().commit(); //(이 시점에 테이블에 반영한다.)
		
		em.close();
	}
}
