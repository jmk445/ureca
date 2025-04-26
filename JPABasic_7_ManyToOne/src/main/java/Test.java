import java.util.HashMap;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;
import entity.Comment;
import entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;


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
		
		Post p = new Post();
		p.setTitle("제목1");
		p.setContent("내용1");
		
		Comment c1 = new Comment();
		c1.setContent("댓글1");
		Comment c2 = new Comment();
		c2.setContent("댓글2");
		//------------------------------------------------------------------------
		//1.연결 없이 post만 insert
//		em.persist(p);
		//------------------------------------------------------------------------
		//2.연결 없이 Comment만 insert -> post는 null로
//		em.persist(c1);
		//------------------------------------------------------------------------
		//3. 연결하고 Post만 
//		c1.setPost(p);
//		c2.setPost(p);
//		
//		em.persist(p);
		//------------------------------------------------------------------------
		//4. 연결하고 comment만
//		c1.setPost(p);
//		c2.setPost(p);
//		
//		em.persist(c1);
		//Caused by: java.lang.IllegalStateException: org.hibernate.TransientObjectException: persistent instance references an unsaved transient instance of 'entity.Post' (save the transient instance before flushing)
		//------------------------------------------------------------------------
		//5.연결하고 Post, Comment 모두
		//post가 맨 마지막에 돼서 마지막에 댓글 튜플들을 update 해줘야함.
//		c1.setPost(p);
//		c2.setPost(p);
//				
//		em.persist(c1);
//		em.persist(c2);
//		em.persist(p);
		//------------------------------------------------------------------------
		//6. 연결하고 Post,Comment모두 , p->c1->c2
		//post가 먼저 되었기 때문에 insert만 3개(update 필요 x)
//		c1.setPost(p);
//		c2.setPost(p);
//		
//		em.persist(p);
//		em.persist(c1);
//		em.persist(c2);
		
		
		//7.연결하고 @ManyToOne(cascade=CascadeType.PERSIST)를 COMMENT 에 추가
		// C1,C2만 PERSIST
		
		//PERSIST로 CASCADE를 하기 때문에 POST도 INSERT가 되는 것을 알 수 있다.
//		Hibernate: insert into Post (content,title) values (?,?)
//		Hibernate: insert into Comment (content,post_id) values (?,?)

		c1.setPost(p);
		c2.setPost(p);
		
		
		em.persist(c1);
//		em.persist(c2);
		
		
		
		
		
		
		
//------------------------------------------------------------------------
		em.getTransaction().commit(); //(이 시점에 테이블에 반영한다.)
		
		em.close();
	}
}
