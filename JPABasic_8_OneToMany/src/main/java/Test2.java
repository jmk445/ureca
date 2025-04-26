
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
		
		//1. FetchType 설정 없이 Post 객체만 find
//		Post p = em.find(Post.class, 1);
		//OneTomany의 One에 해당하는 Post에 달린 Many에 해당하는 Comment가 매우 많을 수 있기 때문에 
		//기본 fetch 옵션은 LAZY -> post_comment테이블은 조회 X
//		Hibernate: select p1_0.id,p1_0.content,p1_0.title from Post p1_0 where p1_0.id=?

		
		//2. FetchType 설정 없이 Comment 객체만 find
//		Comment c1 = em.find(Comment.class, 1);
		//OneToMany의 Many에 해당하는 Comment는 연관관계가 없으므로 독립적으로 select 수행
		
		//3. FetchType 설정 없이 Post 객체만 find, Post 객체의 comments 사용
//		Post p = em.find(Post.class, 1);
//		p.getComments(); //참조 변수만 가져오는 것으로 Comment 객체를 사용하는 코드가 아님
		
//		try {
//			Thread.sleep(5000);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		p.getComments().forEach(comment -> System.out.println(comment));
//		p.getComments().forEach(System.out::println);
		//결과
//		Hibernate: select p1_0.id,p1_0.content,p1_0.title from Post p1_0 where p1_0.id=?
		//5초 대기
		//OneToMany의 기본 fetch 옵션은 LAZY이므로 사용하는 시점에 다시 select
//		Hibernate: select c1_0.Post_id,c1_1.id,c1_1.content from Post_Comment c1_0 join Comment c1_1 on c1_1.id=c1_0.comments_id where c1_0.Post_id=?
//		Comment [id=1, content=코멘트 1 내용]
//		Comment [id=2, content=코멘트 1 내용]


		//4. FetchType 설정을 EAGER로 변경후 Post 객체만 find, Post 객체의 comments 사용
		//@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
//		Post p = em.find(Post.class, 1);		
//		try {
//			Thread.sleep(5000);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		p.getComments().forEach(comment -> System.out.println(comment));
		
		//결과
		//바로 한꺼번에 join으로 가져오는 것을 알 수 있다. (연관된 것은 다 가져온다.)
//		Hibernate: select p1_0.id,p1_0.content,p1_0.title,c1_0.Post_id,c1_1.id,c1_1.content from Post p1_0 left join Post_Comment c1_0 on p1_0.id=c1_0.Post_id left join Comment c1_1 on c1_1.id=c1_0.comments_id where p1_0.id=?
//		Comment [id=1, content=코멘트 1 내용]
//		Comment [id=2, content=코멘트 1 내용]

		
		//5. Post 1개 find, Comment 1개 생성, 연결 -> Comment persist
		//	 즉 새로운 댓글이 추가되는 상황 
		Post p = em.find(Post.class, 1);
		
		Comment c3 = new Comment();
		c3.setContent("댓글 3 내용");
		
		//Post p와 Comment c3 연결		
//		p.setComments(List.of(c3)); // 기존 연결 모두 삭제하고  c3 연결을 연결한다는 의미
		p.getComments().add(c3); // 기존 연결을 유지한 체, 새로운 c3 객체를 추가
		//연결 후, p, c3가 영속화가 되어야한다. 근데, p는 이미 find() 했으므로 영속화가 진행된 상태
		//그래서 c3만 영속화 하면 된다.
		em.persist(c3);
		//결과
		//delete->insert 처리가 된다.
//		Hibernate: select p1_0.id,p1_0.content,p1_0.title,c1_0.Post_id,c1_1.id,c1_1.content from Post p1_0 left join Post_Comment c1_0 on p1_0.id=c1_0.Post_id left join Comment c1_1 on c1_1.id=c1_0.comments_id where p1_0.id=?
//		Hibernate: insert into Comment (content) values (?)
//		Hibernate: delete from Post_Comment where Post_id=?
//		Hibernate: insert into Post_Comment (Post_id,comments_id) values (?,?)
//		Hibernate: insert into Post_Comment (Post_id,comments_id) values (?,?)
//		Hibernate: insert into Post_Comment (Post_id,comments_id) values (?,?)

		em.getTransaction().commit(); //(이 시점에 테이블에 반영한다.)
		
		em.close();
	}
}

