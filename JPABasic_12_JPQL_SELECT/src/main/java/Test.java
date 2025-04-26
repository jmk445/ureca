import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;
import entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;


//jpql select
//DB SQL 객체 중심으로 표현 또는 대체 하려는 노력 
//( 결과적으로 완전히 대체 불가능 => DB 표준 SQL을 일부 사용할 수 밖에 없다 ) @NativeQuery
public class Test {
	public static void main(String[] args) {
		Map<String,String> props = new HashMap<>();
		props.put("hibernate.show_sql","true"); 
		props.put("hibernate.hbm2ddl.auto","update");
				
		EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
				new MyPersistenceUnitInfo(), props				
				);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
//------------------------------------------------------------------------
		
		//1.
		//테이블 데이터 -> 객체화 
		//JPQL 사용 안하고 em의 메소드를 사용 <= 단건만 select
//		Product p = em.find(Product.class, 1);		
//		System.out.println(p);		
		//하나말고 여러건 how? => JPQL
		//jpql은 select only

		
		//2. query
//		String jpql = "select p from Product p"; //Product type의 p 라는 것을 표시, 전부다 -> select 'p'라고 해야함
//		Query q = em.createQuery(jpql);
//		List<?> productList = q.getResultList(); //wild card로 받아야한다.
//		
//		for (Object object : productList) {
//			Product p = (Product) object;
//			System.out.println(p);
//		}
		//형변환 귀찮 -> typed query
		
		
		//3. typedQuery(Type O)
//		String jpql = "select p from Product p"; //Product type의 p 라는 것을 표시, 전부다 -> select 'p'라고 해야함
//		TypedQuery<Product> q = em.createQuery(jpql,Product.class);
//		List<Product> productList = q.getResultList(); //wild card로 받아야한다.			
//		productList.forEach(product->System.out.println(product));
		//위 3개 statement를 아래와 같이 줄일 수 있다. 
//		em.createQuery(jpql, Product.class)
//		  .getResultList()
//		  .forEach(product->System.out.println(product));
	
		//4. 개별 필드사용 (id, name, price) <= Product로 받을 수 없다. 항목하나하나를 Object로 보고 Object[]로 받아야한다.
//		String jpql = "select p.id,p.name,p.price from Product p";//dbms가 아니라 field 기준으로
//		em.createQuery(jpql, Object[].class)
//		  .getResultList()
//		  .forEach(objArray->System.out.println(objArray[0] + "," + objArray[1] + ","+objArray[2] + ","));
		//불편...-> spring jpa 등장
		
		//5.
//		String jpql = "select p from Product p where p.price > 2000";//dbms가 아니라 field 기준으로
//		em.createQuery(jpql, Product.class)
//		  .getResultList()
//		  .forEach(product->System.out.println(product));

		
		//6. 변수화, select + where + and + param( PreparedStatement 의 ? 대응)
//		String jpql = "select p from Product p where p.price > :price and p.quantity > :quantity";
//		em.createQuery(jpql, Product.class)
//		  .setParameter("price",2000)
//		  .setParameter("quantity", 20)
//		  .getResultList()
//		  .forEach(product->System.out.println(product));

		//7. select + where + and + param using index
//		String jpql = "select p from Product p where p.price > ?1 and p.quantity > ?2";
//		em.createQuery(jpql, Product.class)
//		  .setParameter(1,2000)
//		  .setParameter(2, 20)
//		  .getResultList()
//		  .forEach(product->System.out.println(product));
		
		//8. select + where + and + param + like
//		String jpql = "select p from Product p where p.price > :price and p.country like :country";
//		em.createQuery(jpql, Product.class)
//		.setParameter("price",2000)
//		.setParameter("country", "%ko%")
//		.getResultList()
//		.forEach(product->System.out.println(product));
		
		//9. select + aggregation function count() (정수형)
//		String jpql = "select count(p) from Product p";
//		Long cnt = em.createQuery(jpql, Long.class).getSingleResult(); //Long return
//		System.out.println(cnt);
		
		//10. select + aggregation function avg() (실수형)
//		String jpql = "select avg(p.price) from Product p";
//		Double cnt = em.createQuery(jpql, Double.class).getSingleResult(); //Long return
//		System.out.println(cnt);
		
		
		//11. select + aggregation function sum(), min(), max() 한번에
//		String jpql = "select sum(p.quantity), min(p.quantity), max(p.quantity) from Product p";		
//		Object[] objArray = em.createQuery(jpql, Object[].class).getSingleResult(); //Long return
//		System.out.println(objArray[0] + "," + objArray[1] + "," + objArray[2]);
		
//		for (Object object : objArray) {
//			System.out.println((Long)object);
//		} -> 이거 왜 안됨?
		
		//12. select + aggregation function sum(), min(), max() + group by country
		// aggregation function 은 1개의 row 리턴 getResultList(복수) 대신 getSingleResult(단수) 사용
		String jpql = "select p.country,sum(p.quantity), min(p.quantity), max(p.quantity) from Product p group by p.country";		
		List<Object[]> objArrayList = em.createQuery(jpql, Object[].class).getResultList(); //Long return
		objArrayList.forEach(objArray->{
			System.out.println(objArray[0] + "," + objArray[1] + "," + objArray[2]);
		});
		
		
		
//------------------------------------------------------------------------
		em.getTransaction().commit(); 
		
		em.close();
	}
}
