import java.util.HashMap;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;
import entity.Employee;
import entity.Student;
import entity.key.StudentKey;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

// HashMap 옵션 (hibernate의 옵션 : sql 보이기와 테이블 생성 관련)
// remove
public class Test3 {

	public static void main(String[] args){
	
		Map<String,String> props = new HashMap<>();
		props.put("hibernate.show_sql","true"); 
		props.put("hibernate.hbm2ddl.auto","create"); // create : drop & create
		

		EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
				new MyPersistenceUnitInfo(), props				
				);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		// 1. 기존 엔티티를 조회하여 영속 상태로 만듦
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();

		emp1.setId(1);
		emp1.setName("새 이름");

//		emp2.setId(1);
//		emp2.setName("새 이름");

		// 2. 영속성 컨텍스트에서 detach 처리
		em.persist(emp1);
//		em.detach(emp1); // emp1은 이제 준영속 상태 (Detached)

		// 방법 1: 새 엔티티를 직접 persist 하면 예외 발생
//		em.persist(emp2);  // ❌ 오류 발생! 같은 PK가 이미 존재함
		// 방법 2: merge 사용
//		Employee managedEmp = em.merge(emp2);  // ✅ 가능!
		
		em.getTransaction().commit(); //(이 시점에 테이블에 반영한다.)
		
		em.close();
	}

}
