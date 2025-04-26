import java.util.HashMap;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;
import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

// HashMap 옵션 (hibernate의 옵션 : sql 보이기와 테이블 생성 관련)
// remove
public class Test {

	public static void main(String[] args){
		// EntityManager <= EntityManagerFactory (패턴)
		// src/main/resources/META-INF/persistence.xml에 저장 -> 만들어 줘야함.
		
		
		//src/main/resources/META_INF/persistence.xml
		Map<String,String> props = new HashMap<>();
		props.put("hibernate.show_sql","true"); 
//		props.put("hibernate.hbm2ddl.auto","create"); // create : drop & create
		props.put("hibernate.hbm2ddl.auto","update"); //update : 있으면 안건드리고 없으면 만든다.
		
/*
create:
Hibernate: drop table if exists employee
Hibernate: create table employee (id integer not null, address varchar(255), name varchar(255), primary key (id)) engine=InnoDB
*/

/*
update:
테이블이 있으면 수행 x 
테이블이 없으면 
Hibernate: create table employee (id integer not null, address varchar(255), name varchar(255), primary key (id)) engine=InnoDB
*/
		EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
				new MyPersistenceUnitInfo(), props				
				);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//여기서 persistence 작업 수행
		// class - table
		// Product - product
		//#1 ~ #3 으로 뭐라고?
		//#1. persist 
		// 현재 테이블에 없는 객체를 생성한 후 객체의 내용을 테이블에 반영(insert)
//		{
//			Employee e = new Employee();		
//			e.setId(2);
//			e.setName("이길동");
//			e.setAddress("서울 어디");					
//
//			em.persist(e); //persistence(영속)화 된다. (이 시점에 insert되는 게 아니다.)
//		
//		}
				
		
		//#2. find -> setAddress
		// 현재 테이블에 있는 데이터를 객체로 전환(select)
//		{
//			Employee e = em.find(Employee.class, 2); /// id가 1인 녀석		
//			System.out.println(e);			
//		}
		
		//#3. merge 
		// 현재 테이블에 없는(키 기준) 객체를 생성한 후 insert, 이미 있는 객체이면 update 수행 
		// persist는 insert만 수행(dup 가능), merge는 한번 select를 해야해서 오버헤드
//		{
//			Employee e = new Employee();		
//			e.setId(2);
//			e.setName("이길동2");
//			e.setAddress("창원 어디");
//			
//			em.merge(e);
//		} //then auto increment는 어떻게 지정? persist를 이용해야하나
		
		//#4. 
//		{
//			Employee e = em.find(Employee.class, 2);
//			em.remove(e); //이시점에 삭제 x
//			
//			try {
//				Thread.sleep(5000);
//			}catch(Exception ee) {
//				ee.printStackTrace();
//			}
//		}
		
		
		//#1. persist & find
		// 현재 영속화 되어 있는 객체를 find()
		//find()는 대상이 이미 영속화 되어 있으면 table에서 조회 X, 그대로 쓴다.
		{
			Employee e = new Employee();		
			e.setId(3);
			e.setName("삼길동");
			e.setAddress("제주 어디");					

			em.persist(e); //persistence(영속)화 된다. (이 시점에 insert되는 게 아니다.)
			
			Employee e2 = em.find(Employee.class, 3);
			System.out.println(e2);
		}
		em.getTransaction().commit(); //(이 시점에 테이블에 반영한다.)
		
		em.close();
	}

}
