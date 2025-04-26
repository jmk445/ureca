
import java.util.HashMap;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;
import entity.Passport;
import entity.Person;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;

//양방향 find 
public class Test2 {
	public static void main(String[] args) {
		Map<String,String> props = new HashMap<>();
		props.put("hibernate.show_sql","true"); 
//		props.put("hibernate.hbm2ddl.auto","create");
				
		EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
				new MyPersistenceUnitInfo(), props				
				);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//#1. find person 
//		Person person = em.find(Person.class, 1);
		//Hibernate: select p1_0.id,p1_0.name,p2_0.id,p2_0.number from Person p1_0 left join Passport p2_0 on p2_0.id=p1_0.passport where p1_0.id=?
		//OneToOne의 기본 fetch option이 EAGER ( 즉시 로딩 ) 이므로 연관 관계에 있는 Passport도 join으로 함께 가지고 오고
		//person 객체의 출력 코드(35 line)에서 passport 객체를 사용하지만, 다시 select 수행 X ( 이미 가지고 있으니까 )
		//left join하는 것을 볼 수 있다. 
//		System.out.println(person);
		
		//#2. find Passport 
//		Passport passport = em.find(Passport.class, 1);
		//양방향이 되면서 passport만 가져올 때도 join 수행

		//#2-1. @OneToOne(mappedBy="passport", fetch=FetchType.LAZY)
		Passport passport = em.find(Passport.class, 1);
		//person을 lazy로 가져오게 했는데도, 처음 부터 join하는 것을 알 수 있다. (ownership을 갖지 않는 entity는 의미 없다)
		
		//passport가 person에 종속적이다(업무에서 항상 사람먼저 조회하게 된다면).하면 단방향이면 된다.
		//passport로 부터 person도 찾아야된다면 양방향
		
		
		
		
		em.getTransaction().commit(); //(이 시점에 테이블에 반영한다.)
		
		em.close();
	}
}

