
import java.util.HashMap;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;
import entity.Comment;
import entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;


//양방향 many에서는 상호참조를 방지하게끔 해야한다.
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
		//1. FetchType 설정 없이, Post객체를 find
//		Post p = em.find(Post.class, 1);
		//결과 : select p1_0.id,p1_0.content,p1_0.title from Post p1_0 where p1_0.id=?

		//2. FetchType설정 없이, Comment객체를 find
//		Comment comment = em.find(Comment.class, 1);
		//결과 : Hibernate: select c1_0.id,c1_0.content,p1_0.id,p1_0.content,p1_0.title from Comment c1_0 left join Post p1_0 on p1_0.id=c1_0.post_id where c1_0.id=?
		//		join을 하는 것을 볼 수 있다. -> OneToMany와 다르게 EAGER가 Default
		
		//3. FetchType설정 없이, Post객체를 find,toString()으로 Comments 사용
//		Post post = em.find(Post.class, 1);
//		System.out.println(post.getComments()); 
		//결과 : 엥 나는 에러 안남 -> 아 comment에서 post가지고 오는 toString이 없었음
//				StackOverFlowError <= 순환 참조 post - comment
//				양방향에서 Psot에 comments를 사용하는 코드를 실행할 때, Comment의 toString()이 Post의 toString(), 다시 Comment의 toString()...

		
		//4. toString 상호 참조 제거
		
		//5. FetchType = LAZY, Comment 객체를 find( #2 대비 )
//		Comment comment = em.find(Comment.class, 1);
		//결과 : Hibernate: select c1_0.id,c1_0.content,c1_0.post_id from Comment c1_0 where c1_0.id=?
		//		Post 1건 select
//		System.out.println(comment.getPost());
		
		
		//6. Post 객체 find(), Comment 객체 생성, 연결 Comment 객체 persist
		Post p = em.find(Post.class, 1);
		Comment c3 = new Comment();
		c3.setContent("댓글 3 내용");		
		c3.setPost(p); //연결
		
		em.persist(c3);
		
//------------------------------------------------------------------------

		em.getTransaction().commit(); //(이 시점에 테이블에 반영한다.)
		
		em.close();
	}
}
