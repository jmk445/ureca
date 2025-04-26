import java.util.HashMap;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;
import entity.Employee;
import entity.Student;
import entity.key.StudentKey;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Test5 {

	public static void main(String[] args){
	
		Map<String,String> props = new HashMap<>();
		props.put("hibernate.show_sql","true"); 
		props.put("hibernate.hbm2ddl.auto","create"); // create : drop & create
		

		EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
				new MyPersistenceUnitInfo(), props				
				);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Employee emp = new Employee();
		emp.setName("John");
		
		em.persist(emp);       // 영속 상태
		em.detach(emp);        // Detached 상태

		em.persist(emp);       // 1. 예외 발생, Detached 상태는 persist 불가
//		em.merge(emp);         // 2. OK, 병합 후 영속 상태로 전환됨

		
		em.getTransaction().commit(); //(이 시점에 테이블에 반영한다.)
		
		em.close();
	}

}
