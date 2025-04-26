import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;
import entity.Comment;
import entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

//OneToMany
//	1. 테이블이 3개, Entity 각각 1개씩, 연관 관계를 표현하는 테이블 1개
//	2. ManyToOne은 Many가 Owning entity가 되므로, Many를 표현하는 테이블에 One에 해당하는 컬럼을 추가
//	3. OneToMany는 One이 Owning Entity인데, One을 표현하는 테이블에 복수개의 Many를 표현 X => 별도의 관계 테이블을 추가 (그룹 코드의 동작과 비슷)
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
		//0. 그냥 ManyToOne 실행
//			Hibernate: create table Comment (id integer not null auto_increment, content varchar(255), primary key (id)) engine=InnoDB
//			Hibernate: create table Post (id integer not null auto_increment, content varchar(255), title varchar(255), primary key (id)) engine=InnoDB
//			Hibernate: create table Post_Comment (Post_id integer not null, comments_id integer not null) engine=InnoDB
		
		Post p = new Post();
		p.setTitle("게시글 1");
		p.setContent("게시글 1 내용");
		
		Comment c1 = new Comment();
		c1.setContent("코멘트 1 내용");
		Comment c2 = new Comment();
		c2.setContent("코멘트 1 내용");
		
		//1. Post 한건만 persist
//		em.persist(p);
		//Hibernate: insert into Post (content,title) values (?,?)
		//Post 1건 정상 insert
		//-> post_comment 테이블에는 아무것도 안들어옴.
		
		//2. Comment 2건만 persist
//		em.persist(c1);
//		em.persist(c2);
//		Hibernate: insert into Comment (content) values (?)
//		Hibernate: insert into Comment (content) values (?)
		
		
		//3. 연결없이, Post 1건, Comment 2건 persist		
//		em.persist(p);
//		em.persist(c1);
//		em.persist(c2);
//		Hibernate: insert into Post (content,title) values (?,?)
//		Hibernate: insert into Comment (content) values (?)
//		Hibernate: insert into Comment (content) values (?)
		

		
		//4. Post에 comment 연결, Post 1건만 persist
		//연결 코드	
//		p.setComments(List.of(c1,c2)); // List.of :  list 객체를 return 해줌
//		em.persist(p);
//		java.lang.IllegalStateException: org.hibernate.TransientObjectException: persistent instance references an unsaved transient instance of 'entity.Comment' (save the transient instance before flushing)
		//OneToMany Post에 연결된 Comment 객체들이 영속화 되지 않았기 때문에 오류
		
		
		//5. Post에 comment 연결, Post 1건, Comment 2건 persist
		
//		p.setComments(List.of(c1,c2)); // List.of :  list 객체를 return 해줌
//		em.persist(p);
//		em.persist(c1);
//		em.persist(c2);
//		Hibernate: insert into Post (content,title) values (?,?)
//		Hibernate: insert into Comment (content) values (?)
//		Hibernate: insert into Comment (content) values (?)
//		Hibernate: insert into Post_Comment (Post_id,comments_id) values (?,?)
//		Hibernate: insert into Post_Comment (Post_id,comments_id) values (?,?)

		//6. Post에 comment 연결, Post 1건만 persist, 4와 다른점은 CascadeType.persist 를 OneToMany에 추가		
		
		p.setComments(List.of(c1,c2)); // List.of :  list 객체를 return 해줌
		em.persist(p);		
//		Hibernate: insert into Post (content,title) values (?,?)
//		Hibernate: insert into Comment (content) values (?)
//		Hibernate: insert into Comment (content) values (?)
//		Hibernate: insert into Post_Comment (Post_id,comments_id) values (?,?)
//		Hibernate: insert into Post_Comment (Post_id,comments_id) values (?,?)
		//CASCADE를 PERSIST로 해놓았기 때문에, 자동으로 C1,C2가 PERSIST된다.. 
		
		
		
		
//------------------------------------------------------------------------
		em.getTransaction().commit(); //(이 시점에 테이블에 반영한다.)
		
		em.close();
	}
}
