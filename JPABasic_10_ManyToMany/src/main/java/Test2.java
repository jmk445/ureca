
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;
import entity.Team;
import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;



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
		// Test.java #8,#9
		// Test2는 여러분 마음대로 테스트 코드 작성
		
		

//		### Test2
//
//		#1. FetchType 설정 없이 Team 객체만 find
//		Team team = em.find(Team.class, 1);
		
//		#2. FetchType 설정 없이 User 객체만 find
//		User user = em.find(User.class, 1);
		
//		#3. FetchType 설정 없이 Team 객체 find + Team 객체의 users 사용
//		Team team = em.find(Team.class, 1);
//		System.out.println(team.getUsers());
		
//		#4. FetchType=Eager 설정, Team 객체 find + Team 객체의 users 사용
//		Team team = em.find(Team.class, 1);
//		System.out.println(team.getUsers());
		
//		#5. Team 1개 find, User 1개 생성, 연결 후 User persist
//		Team team = em.find(Team.class, 1);
//		
//		User user = new User();
//		user.setName("홍길동");
//		//user.setTeams(List.of(team)); //->이거는 안된다. 앞에서 말했듯이 (user가 owning이 아님)		
//		team.getUsers().add(user);
//		em.persist(user);

		
		
//------------------------------------------------------------------------

		em.getTransaction().commit(); //(이 시점에 테이블에 반영한다.)
		
		em.close();
	}
}
