
import java.util.HashMap;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;
import entity.Comment;
import entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;


//ManyToOne find 
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
		
		
		//1. post
//		Post post = em.find(Post.class, 1);
//		Hibernate: select p1_0.id,p1_0.content,p1_0.title from Post p1_0 where p1_0.id=?

		//2. comment
//		Comment comment = em.find(Comment.class, 1);
//		join으로 가져오는 것을 알 수 있다 (manytoOne의 cascade default : eager)
//		Hibernate: select c1_0.id,c1_0.content,p1_0.id,p1_0.content,p1_0.title from Comment c1_0 left join Post p1_0 on p1_0.id=c1_0.post_id where c1_0.id=?
		
		//3. comment
//		fetch=FetchType.LAZY로
		Comment comment = em.find(Comment.class, 1);
//		Hibernate: select c1_0.id,c1_0.content,c1_0.post_id from Comment c1_0 where c1_0.id=?
//		join이 아니라 자기 자신것만 가져온다.
		System.out.println(comment);
		
		//4. comment
//		ToString을 통해 post 사용 
//		Comment comment = em.find(Comment.class, 1);
//		System.out.println(comment);
//		Hibernate: select c1_0.id,c1_0.content,c1_0.post_id from Comment c1_0 where c1_0.id=?
//		Hibernate: select p1_0.id,p1_0.content,p1_0.title from Post p1_0 where p1_0.id=?

		//5. find한 post와 new 한 comment
//		//	post 하나를 find해서 가져오고, 누군가 새로운 댓글을 달았을 때
//		Post post = em.find(Post.class, 1);
//		
//		Comment c3 = new Comment();
//		c3.setContent("코멘트 3");
//		
//		c3.setPost(post);
//		em.persist(c3);
		
		
		
		em.getTransaction().commit(); //(이 시점에 테이블에 반영한다.)
		
		em.close();
	}
}

