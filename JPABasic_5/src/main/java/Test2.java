import java.util.HashMap;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;
import entity.Student;
import entity.key.StudentKey;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

// HashMap 옵션 (hibernate의 옵션 : sql 보이기와 테이블 생성 관련)
// remove
public class Test2 {

	public static void main(String[] args){
	
		Map<String,String> props = new HashMap<>();
		props.put("hibernate.show_sql","true"); 
		props.put("hibernate.hbm2ddl.auto","update"); // create : drop & create
		

		EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
				new MyPersistenceUnitInfo(), props				
				);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//@IdClass()
		{
//			Product p = new Product();
//			p.setCode("uplus");
//			p.setNumber(1);
//			
//			p.setColor("blue");
//			em.persist(p);
			
//			ProductKey key =new ProductKey(); // key를 표현
//			key.setCode("uplus");
//			key.setNumber(1);
//			
//			Product p = em.find(Product.class, key);
//			
//			System.out.println(p);
		}
		
		//Embedded
		//항상 Embedded Key로 부터 접근 해야함
		{
//			StudentKey key = new StudentKey();
//			key.setCode("uplus");
//			key.setNumber(1);
//			
//			Student s = new Student();
//			s.setId(key);
//			s.setName("홍길동");
//			
//			em.persist(s);
			
			StudentKey key = new StudentKey();
			key.setCode("uplus");
			key.setNumber(1);
			
			Student s = em.find(Student.class, key);
			
			System.out.println(s);
		}
		
		em.getTransaction().commit(); //(이 시점에 테이블에 반영한다.)
		
		em.close();
	}

}
