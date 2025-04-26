import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;
import entity.Orders;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

// NamedQuery : 별도의 이름을 가지는 query를 자바 코드 안이 아닌 관련 Entity 상단에 annotation으로 표현
//				자바 코드에서 이름으로 query를 사용
// NativeQuery : jpql이 아닌 표준 sql을 사용
// 위 두 방법을 Spring Data JPA 를 이용하는 경우, Query 에 name 또는 native=true 사용
public class Test {

	public static void main(String[] args) {

		Map<String, String> props = new HashMap<>();
		props.put("hibernate.show_sql", "true");
//		props.put("hibernate.hbm2ddl.auto", "create"); // create : drop & create,  update : 있으면 안 건드리고 없으면 만든다.
		

		EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
				new MyPersistenceUnitInfo(), props
		); 
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
	

		
		// #1. NamedQuery : Orders.findByOrderDate
		
//		em.createNamedQuery("Orders.findByOrderDate", Orders.class)
//		  .setParameter("startDate",LocalDate.of(2024, 3, 11))		  
//		  .getResultList()
//		  .forEach(
//				System.out::println
//		  );
		
		
		// #2. NamedQuery : Orders.findByOrderDateRange
//		em.createNamedQuery("Orders.findByOrderDateRange", Orders.class)
//		  .setParameter("startDate",LocalDate.of(2024, 3, 11))		  
//		  .setParameter("endDate",LocalDate.of(2030, 3, 11))		  
//		  .getResultList()
//		  .forEach(
//				System.out::println
//		  );
		
		// #3. NamedQuery : Orders.findByPrice
//		em.createNamedQuery("Orders.findByProductPrice", Object[].class)
//		.setParameter("startPrice",1000)		  
//		.setParameter("endPrice",3000)		  
//		.getResultList()
//		.forEach( objArray->{
//			System.out.println(objArray[0] + "," + objArray[1]);
//		});
		
		// #4. Nativequery
		//고객 이름으로  주문 데이터를 select 
		String sql =
				"""
					select o.* 
					  from orders o, 
					       customer c
					 where customer_id = c.id
					   and c.name = :customerName
				""";
		
		List<?> ordersList = em.createNativeQuery(sql, Orders.class)
		.setParameter("customerName","고객2")
		.getResultList();
		
		
		ordersList.forEach(orders -> System.out.println((Orders)orders));
		
			
				
		
		
		em.getTransaction().commit();  // 이 시점에 테이블에 반영한다.
		
		em.close();
	}

}