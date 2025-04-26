import entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test {

	public static void main(String[] args){
		// EntityManager <= EntityManagerFactory (패턴)
		// src/main/resources/META-INF/persistence.xml에 저장 -> 만들어 줘야함.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//여기서 persistence 작업 수행
		// class - table
		// Product - product
		
		Product p = new Product();
		p.setId(1L);
		p.setName("Phone");
		
		em.persist(p); //persistence(영속)화 된다. ( 이 시점에 insert되는 게 아니다. )
		
		em.getTransaction().commit(); //( 이 시점에 insert 된다. )
		
		em.close();
	}

}
