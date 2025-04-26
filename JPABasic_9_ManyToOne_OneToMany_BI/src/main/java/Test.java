import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;
import entity.Comment;
import entity.Post;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.ManyToOne;

//OneToMany - ManyToOne BI
//	1. ManyToOne을 가진 테이블이 Owning Entity 즉 여기서는 comment
//	2. Comment, Post 2개의 테이블이 생성( 그냥 두개다 하면 기본이 manyToOne 임 )
//	3. 연관 관계를 Comment의 post_id 컬럼으로 처리 
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
		//0. 아무것도 안하고 테이블을 생성했을 때 -> owning table이 comment이므로 새로운 comment_post 테이블은 생성되지 않는다. ( 그냥 many to one으로 표현이 다됨 )
		
		Post p = new Post();
		p.setTitle("게시글 1 제목");
		p.setContent("게시글 1 내용");
		
		Comment c1 = new Comment();
		c1.setContent("댓글1 내용");
		Comment c2 = new Comment();
		c2.setContent("댓글2 내용");
		
		//1. 연결 없이, Post만 1건 insert 
//		em.persist(p);
		//오류 x
		
		//2. 연결 없이, Comment만 2건 psersist				
//		em.persist(c1);
//		em.persist(c2);
		//연관 관계 컬럼인 post_id 가 null
		//오류 x
		
		//3. 연결 없이, Post 1건, Comment 2건 persist
//		em.persist(p);
//		em.persist(c1);
//		em.persist(c2);
		//오류 x
		
		// 4 ~ 6 : many to one 연결
		//4. Comment에만 post 연결 (ManyToOne), comment만 영속화
		//	 이제 연결을 했으니, 본격적으로 cascade 관련 오류가 나올거
		//	 즉, 채우려고 하는 객체가 영속화 되어 있지 않으면 오류가 나옴
//		c1.setPost(p);
//		c2.setPost(p);
//		
//		em.persist(c1);
//		em.persist(c2);
		
		//5. Comment에만 post 연결 (ManyToOne), 모두 영속화
		//	 
		//	 이제 연결을 했으니, 본격적으로 cascade 관련 오류가 나올거
		//	 즉, 채우려고 하는 객체가 영속화 되어 있지 않으면 오류가 나옴
//		c1.setPost(p);
//		c2.setPost(p);
//		
//		em.persist(p);
//		em.persist(c1);
//		em.persist(c2);
		//오류 x
		
		//6. Comment에만 post연결(ManyToOne), comment만 영속화하는데, @ManyToOne(cascade = CascadeType.PERSIST)지정후 실행
		
//		c1.setPost(p);
//		c2.setPost(p);
//		
//		em.persist(c1);
//		em.persist(c2);
		//결과 : 오류 x
		
		//7~8 : onetomany -> comment의 post_id : null 로 비워질 수 밖에 없음
		
		//7. post에만 comment 연결 (OneToMany), post만 영속화
		//결과 : Post 1건 insert, Comment는 insert X
		//ManyToOne, OneToMany 양방향의 Owning 연관관계는 ManyToOne
		//OneToMany를 가진 Post는 연관관계 관련 컬럼 X <= Comment가 함께 영속화 되지 않아도 됨. 
//		p.setComments(List.of(c1,c2));
//		em.persist(p);

		
		//8. post에만 comment 연결 (OneToMany), post만 영속화
		//결과 : 3건의 insert가 일어나지만, 연관관계 post_id에 null 
		//		왜냐하면 manyToOne의 관계를 결정 짓는 comment.setPost()가 호출 X
//		p.setComments(List.of(c1,c2));
//		em.persist(p);
//		em.persist(c1);
//		em.persist(c2);
		
		
		//9. post,comment 모두 (OneToMany + ManyToOne),모두 영속화				
		p.setComments(List.of(c1,c2));
		c1.setPost(p);
		c2.setPost(p);
		
		
		em.persist(p);
		em.persist(c1);
		em.persist(c2);
		
		//결과 : 모두 작동함. 근데, 5번과 같음. 즉, p.setComment는 하지 않아도 됨. 
		
		
		
		
		
//------------------------------------------------------------------------
		em.getTransaction().commit(); //(이 시점에 테이블에 반영한다.)
		
		em.close();
	}
}
