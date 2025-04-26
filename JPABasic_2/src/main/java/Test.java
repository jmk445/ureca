import java.util.HashMap;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;
import entity.Product;
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
		
		Product p = new Product();
		p.setId(2L);
		p.setName("Book");
		
		em.persist(p); //persistence(영속)화 된다. ( 이 시점에 insert되는 게 아니다. )
		
		em.getTransaction().commit(); //( 이 시점에 insert 된다. )
		
		em.close();
	}

}
