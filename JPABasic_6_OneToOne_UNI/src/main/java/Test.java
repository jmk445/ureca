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
		
		//#1. 각각 독립적으로 persist하면,오류 없이 insert 된다. 
//		em.persist(person);
//		Hibernate: insert into Person (name,passport) values (?,?)
//		passport는 null
		em.persist(passport);
//		Hibernate: insert into Passport (number) values (?)
		
		//#2. 객체 연결 (passport연결 후에)
//		person.setPassport(passport);
//		em.persist(person);
////		:persistent instance references an unsaved transient instance of 'entity.Passport' (save the transient instance before flushing)
////		passport영속화 되지 않은 상태 => 오류발생
//		em.persist(passport);
////		Hibernate: insert into Passport (number) values (?)
////		passport만 영속화 하는 것은 정상적으로 insert 
		
		
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
//		em.persist(person); //passport를 persist안하고 person만 
//		
//		em.getTransaction().commit(); //(이 시점에 테이블에 반영한다.)
		
		em.close();
	}
}
