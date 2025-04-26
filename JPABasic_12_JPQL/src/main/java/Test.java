import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;
import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

// JPQL
//select 수행, insert는 못함, update,delete O (주로 select 용으로 jpql사용)
// transaction begin, commit 사용 필요 X (읽기 라서)
public class Test {

	public static void main(String[] args){
		
		Map<String,String> props = new HashMap<>();
		props.put("hibernate.show_sql","true"); 
		props.put("hibernate.hbm2ddl.auto","update"); //update : 있으면 안건드리고 없으면 만든다.
		
		EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
				new MyPersistenceUnitInfo(), props				
				);
		EntityManager em = emf.createEntityManager();
		
//		em.getTransaction().begin();
		
		// #1 normal query
//		{
//			//SQL : "select * from employee"
//			String jpql = "select e from Employee e"; //Entity를 이용한 query 형식
//			Query query = em.createQuery(jpql);
//			List<Employee> list = query.getResultList();
//			
//			for (Employee employee : list) {
//				System.out.println(employee);
//			}
//		}
		
		// #2. typed query
		{
			//SQL : "select * from employee"
			String jpql = "select e from Employee e"; //Entity를 이용한 query 형식
			TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
			List<Employee> list = query.getResultList();
			
			for (Employee employee : list) {
				System.out.println(employee);
			}
		}
		
		// #3. parameter 
//		{
//			//SQL : "select * from employee where id = '3';"
//			String jpql = "select e from Employee e where id >= :id"; //Entity를 이용한 query 형식
//			TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
//			query.setParameter("id",3);			
//			List<Employee> list = query.getResultList();
//			
//			for (Employee employee : list) {
//				System.out.println(employee);
//			}
//		}
		
		//#4. positional parameter
//		{
//			//SQL : "select * from employee where id = '3';"
//			String jpql = "select e from Employee e where id >= ?1"; //Entity를 이용한 query 형식
//			TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
//			query.setParameter(1,3);	//1은 ?1 이라서 들어온거
//			List<Employee> list = query.getResultList();
//			
//			for (Employee employee : list) {
//				System.out.println(employee);
//			}
//		}
		
		//#5. single result
		{
			//SQL : "select * from employee where id = '3';"
			String jpql = "select e from Employee e where id = ?1"; //Entity를 이용한 query 형식
			TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
			query.setParameter(1,3);	//1은 ?1 이라서 들어온거
			Employee e= query.getSingleResult();
			
			System.out.println(e);
		}
		
		//#6. like 
		{
			//SQL : "select * from employee where name like %길동%;"
			//e.name이라고 써야하는 것 주의 ( alias를 썼기 때문 )
			String jpql = "select e from Employee e where e.name like :searchWord"; //Entity를 이용한 query 형식
			String searchWord = "%길동%";
//			String searchWord = "홍%";
			
			TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
			query.setParameter("searchWord",searchWord);	//1은 ?1 이라서 들어온거
			List<Employee> list = query.getResultList();
			
			for (Employee employee : list) {
				System.out.println(employee);
			}
		}
		

//		em.getTransaction().commit(); //(이 시점에 테이블에 반영한다.)
		
		em.close();
	}

}
