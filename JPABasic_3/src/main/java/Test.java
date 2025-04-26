import java.util.HashMap;

import org.hibernate.jpa.HibernatePersistenceProvider;

import Config.MyPersistenceUnitInfo;
import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

//2번 프로젝트 변경 사항 -> readme확인
public class Test {

	public static void main(String[] args){
		// EntityManager <= EntityManagerFactory (패턴)
		// src/main/resources/META-INF/persistence.xml에 저장 -> 만들어 줘야함.
		
		
		////////////////!!!xml을 이용하는게 아니라서 다른 클래스 사용!!!
		EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
				new MyPersistenceUnitInfo(), new HashMap<>()				
				);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//여기서 persistence 작업 수행
		// class - table
		// Product - product
		
		//#1. persist 
		// 현재 테이블에 없는 객체를 생성한 후 객체의 내용을 테이블에 반영(insert)
		{
			Employee e = new Employee();		
			e.setId(2);
			e.setName("이길동");
			e.setAddress("서울 어디");
			
			//hibernate가 관리하는 entity로 들어오는 것 : .persist()

			em.persist(e); //persistence(영속)화 된다. (이 시점에 insert되는 게 아니다.)
			e.setAddress("경기 어디");
		}
		
		//#2. find -> setAddress
		// 현재 테이블에 있는 데이터를 객체로 전환(select)
//		{
//			Employee e = em.find(Employee.class, 1); /// id가 1인 녀석		
//			System.out.println(e);
//			//find를 통해서 영속화를 이미 시켜놨기 때문에 값이 바뀌는 것을 볼 수 있다. 
//			e.setAddress("대전 어디"); // 하지만 이 시점에 update 되는 것은 아니다. 영속화된 객체의 field값을 변경하면 DB에 반영이 된다.
//			System.out.println(e);
//			//....
//			e.setAddress("부산 어디");
//			System.out.println(e);
//		}
		
		//#3. merge 
		// 현재 테이블에 없는(키 기준) 객체를 생성한 후 insert, 이미 있는 객체이면 update 수행 
		// persist는 insert만 수행(dup 가능), merge는 한번 select를 해야해서 오버헤드
//		{
//			Employee e = new Employee();		
//			e.setId(4);
//			e.setName("삼사길동");
//			e.setAddress("춘천 어디");
//			
//			em.merge(e);
//		} //then auto increment는 어떻게 지정? persist를 이용해야하나
				
		em.getTransaction().commit(); //(이 시점에 테이블에 반영한다.)
		
		em.close();
	}

}
