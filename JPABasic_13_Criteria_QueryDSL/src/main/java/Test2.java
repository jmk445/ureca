
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import com.querydsl.jpa.impl.JPAQuery;

import config.MyPersistenceUnitInfo;
import entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;



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
//------------------------------------------------------------------------

		
//		for (int i = 1; i <= 10; i++) {
//            Product p = new Product();
//            p.setName("Product" + i);
//            p.setPrice(1000 + i * 100);
//            p.setQuantity(50 + i * 10);
//            p.setCountry(i % 2 == 0 ? "Korea" : "USA");
//
//            em.persist(p);
//        }

		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		
		Root<Product> products = cq.from(Product.class);
		
		Predicate usernameEqual = cb.equal(products.get("name"), "Product1");
		
		cq.select(products).where(usernameEqual);
		
		List<Product> result = em.createQuery(cq).getResultList();

		result.forEach(product -> {
			System.out.println(product);
		});
		
		
		QProduct p = QProduct.product;

        JPAQuery<Product> query = new JPAQuery<>(em);
        Product result = query
                .select(p)
                .from(p)
                .where(p.name.eq(name))
                .fetchOne();
        
//------------------------------------------------------------------------

		em.getTransaction().commit(); 
		
		em.close();
	}
}
