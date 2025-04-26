import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;
import entity.Team;
import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

//ManyToMany 양방향
//teams,users,teams_users 3개의 테이블 생성확인
//persist
public class Test {
	public static void main(String[] args) {
		Map<String,String> props = new HashMap<>();
		props.put("hibernate.show_sql","true"); 
		props.put("hibernate.hbm2ddl.auto","create");
				
		EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
				new MyPersistenceUnitInfo(), props				
				);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
//------------------------------------------------------------------------
		
		//1. 
		//테이블 3개 확인
		
		//2. user 객체 2개 persist, 연결 x, 추가로 내가 몇개 테스트해봄 
//		User u1 = new User();
//		u1.setName("홍길동");
//		User u2 = new User();
//		u2.setName("이길동");		
//		Team t1 = new Team();
//		t1.setName("팀1");
//		
//		u1.setTeams(List.of(t1));
//		
//		em.persist(t1);
//		em.persist(u1);
//		em.persist(u2);
	//->아 user에다가 team을 추가해서 안되는 이유는 owning이 아니라서 인듯
		
		
		//3. team2개 연결 x
//		Team t1 = new Team();
//		t1.setName("팀1");
//		Team t2 = new Team();
//		t2.setName("팀2");
//		em.persist(t1);
//		em.persist(t2);
		
		//4.team2개 user2개 연결x
//		User u1 = new User();
//		u1.setName("홍길동");
//		User u2 = new User();
//		u2.setName("이길동");
//		Team t1 = new Team();
//		t1.setName("팀1");
//		Team t2 = new Team();
//		t2.setName("팀2");
//		em.persist(u1);
//		em.persist(u2);
//		em.persist(t1);
//		em.persist(t2);
		
		//5.team2개 user2개 연결O
		User u1 = new User();
		u1.setName("홍길동");		
		User u2 = new User();
		u2.setName("이길동");
		Team t1 = new Team();
		t1.setName("팀1");
		Team t2 = new Team();
		t2.setName("팀2");
		
		t1.setUsers(List.of(u1,u2));
		t2.setUsers(List.of(u1,u2));
		
		em.persist(u1);
		em.persist(u2);
		em.persist(t1);
		em.persist(t2);
		
		//6.team2개 user2개, persist는 team만, 연결O
//		User u1 = new User();
//		u1.setName("홍길동");		
//		User u2 = new User();
//		u2.setName("이길동");
//		Team t1 = new Team();
//		t1.setName("팀1");
//		Team t2 = new Team();
//		t2.setName("팀2");
//		
//		t1.setUsers(List.of(u1,u2));
//		t2.setUsers(List.of(u1,u2));
		//결과 : teams_users에서 넣으려고 하는데 user가 persist안돼있으니 에러...
		//		이것도 마찬가지로 해결책은 cascade persist로 설정
		
		//7.team2개 user2개, persist는 team만, 연결O, team에 cascade persist로 설정
			
//		User u1 = new User();
//		u1.setName("홍길동");		
//		User u2 = new User();
//		u2.setName("이길동");
//		Team t1 = new Team();
//		t1.setName("팀1");
//		Team t2 = new Team();
//		t2.setName("팀2");
//		
//		t1.setUsers(List.of(u1,u2));
//		t2.setUsers(List.of(u1,u2));
//		em.persist(t1);
//		em.persist(t2);
		//결과 : 오류 x
		
		//#8,#9는 아시죠?? -> 연결을 어디에 하는지에 따른 차이점 실험 (연결을 user에다가, 서로에다가)

		//8. User에 Team 객체 2개 연결, Team, User 모두 persist ( cascadeType=default )
//		User u1 = new User();
//		u1.setName("홍길동");		
//		User u2 = new User();
//		u2.setName("이길동");
//		Team t1 = new Team();
//		t1.setName("팀1");
//		Team t2 = new Team();
//		t2.setName("팀2");
//		
//		u1.setTeams(List.of(t1,t2));
//		u2.setTeams(List.of(t1,t2));
//		em.persist(u1);
//		em.persist(u2);
//		em.persist(t1);
//		em.persist(t2);
		//결과 : 1번에서 내가 실험했던 데로, 안됨. (user는 owning이 아니기 때문)
		
				
		//9. Team 과 User 객체 상호 연결, Team, User 모두 persist ( cascadeType=default )
//		User u1 = new User();
//		u1.setName("홍길동");		
//		User u2 = new User();
//		u2.setName("이길동");
//		Team t1 = new Team();
//		t1.setName("팀1");
//		Team t2 = new Team();
//		t2.setName("팀2");
//		
//		u1.setTeams(List.of(t1,t2));
//		u2.setTeams(List.of(t1,t2));
//		t1.setUsers(List.of(u1,u2));
//		t2.setUsers(List.of(u1,u2));
//		
//		em.persist(u1);
//		em.persist(u2);
//		em.persist(t1);
//		em.persist(t2);
		// 결과 : 그냥 team(owning)에 user를 추가해주는 것과 같음. 
		
//------------------------------------------------------------------------
		em.getTransaction().commit(); //(이 시점에 테이블에 반영한다.)
		
		em.close();
	}
}
