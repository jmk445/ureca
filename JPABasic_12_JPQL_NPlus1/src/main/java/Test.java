import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;
import entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;


//N+1
//어떤 Entity A가 연관 관계를 가진 상대 Entity B에 대해서 FetchType이 LAZY일 때,
// A의 목록을 가져오는 경우, B는 가져오지 않는다.
// A의 목록을 가져와서 각각의 A에 대해 연관관계에 있는 B를 사용하면 B를 가져오게된다.
// 이 때, A의 목록에 포함된 A의 수만큼, B를 가져오는 select가 수행된다.
// 결국 이 과정에서 A목록 가져오는 select 1회, A 목록 수(N) 만큼 B를 select N회 수행 -> N + 1
// 유사한 개념 주의 : 
// eager : jpa를 이용하는데, 비효율적인 코드를 바로 잡는 상황이지, N+1과는 거리가 있는 것 
// Eager -> Lazy, Lazy -> Eager 해결 ... (X)
// N+1 은 join fetch 를 통해서 해결
public class Test {
	public static void main(String[] args) {
		Map<String,String> props = new HashMap<>();
		props.put("hibernate.show_sql","true"); 
		props.put("hibernate.hbm2ddl.auto","update");
				
		EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
				new MyPersistenceUnitInfo(), props				
				);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
//------------------------------------------------------------------------
		//1.
		// N+1 확인
//		String jpql = "select p from Post p";
//		List<Post> postList = em.createQuery(jpql, Post.class).getResultList();//Post목록 
//		postList.forEach(post->post.getComments().size());
		//결과 ( post가 3개 있다 )
//		Hibernate: select p1_0.id,p1_0.content,p1_0.title from Post p1_0
//		Hibernate: select c1_0.post_id,c1_0.id,c1_0.content from Comment c1_0 where c1_0.post_id=?
//		Hibernate: select c1_0.post_id,c1_0.id,c1_0.content from Comment c1_0 where c1_0.post_id=?
//		Hibernate: select c1_0.post_id,c1_0.id,c1_0.content from Comment c1_0 where c1_0.post_id=?

		//2.
		// 해결 시도 : Post의 Comment에 대한 연관 관계 FetchType.EAGER
		// 미리 가져오긴 하는데 join을 통한 한번의 select가 아닌, 여전히 N+1 발생
//		String jpql = "select p from Post p";
//		List<Post> postList = em.createQuery(jpql, Post.class).getResultList();//Post목록 
//		Hibernate: select p1_0.id,p1_0.content,p1_0.title from Post p1_0
		//3건에 대한 select 추가 수행
//		Hibernate: select c1_0.post_id,c1_0.id,c1_0.content from Comment c1_0 where c1_0.post_id=?
//		Hibernate: select c1_0.post_id,c1_0.id,c1_0.content from Comment c1_0 where c1_0.post_id=?
//		Hibernate: select c1_0.post_id,c1_0.id,c1_0.content from Comment c1_0 where c1_0.post_id=?

		
//		postList.forEach(post->post.getComments().size());
		//결과 ( 여전히 발생 )

		
		//3. 
		// 해결 시도 : Post의 Comment에 대한 연관 관계 FetchType.EAGER
		// #2 대한 결과를 가지고 , jpql 대신 find()와 비교,find() 형태의 목록을 가져오는 메소드 X
		// find() != jpql
//		em.find(Post.class, 1);
//		em.find(Post.class, 2);
//		em.find(Post.class, 3);
//		Hibernate: select p1_0.id,p1_0.content,p1_0.title,c1_0.post_id,c1_0.id,c1_0.content from Post p1_0 left join Comment c1_0 on p1_0.id=c1_0.post_id where p1_0.id=?
//		Hibernate: select p1_0.id,p1_0.content,p1_0.title,c1_0.post_id,c1_0.id,c1_0.content from Post p1_0 left join Comment c1_0 on p1_0.id=c1_0.post_id where p1_0.id=?
//		Hibernate: select p1_0.id,p1_0.content,p1_0.title,c1_0.post_id,c1_0.id,c1_0.content from Post p1_0 left join Comment c1_0 on p1_0.id=c1_0.post_id where p1_0.id=?
		
		//4.
		// Post 목록 대신 PK로 조건을 줘서 select <= find() 와 동일하게 EAGER로 가져오는지 확인			
		String jpql = "select p from Post p where p.id=1";
		List<Post> postList = em.createQuery(jpql, Post.class).getResultList();//Post목록 
		postList.forEach(post->post.getComments().size());
		//결과 ( 1건에 대한 select 추가 수행 )
//		Hibernate: select p1_0.id,p1_0.content,p1_0.title from Post p1_0 where p1_0.id=1
//		Hibernate: select c1_0.post_id,c1_0.id,c1_0.content from Comment c1_0 where c1_0.post_id=?

		//중간 결론
		// 2,3,4로 테스트한 결과 
		// FetchType을 Lazy에서 Eager로 변경하는 방법은 실패
		
		
		//최종 결론
		//Post 목록을 가져와서 Post만 사용하려는 목적이라면 N+1 문제는 발생 X
		//Post 목록을 가져와서 Post외 Post의 연관관계인 comment를 사용하려면 미리 Comment도 가져오는 것이 N+1문제를 해결할 수 있다.
		//그 방법이 join fetch : join으로 한꺼번에 가져와라고 jpql에게 알려줄 수 있다.
		

		//5.
		// N+1에 대해 join fetch로 미리 가져와서 해결 -> 표준 sql 문법이 아님
//		String jpql = "select p from Post p join fetch p.comments";
//		List<Post> postList = em.createQuery(jpql, Post.class).getResultList();//Post목록 
//		postList.forEach(post->post.getComments().size());
		//결과 ( 해결 , 추가 건수 X )
//		Hibernate: select p1_0.id,c1_0.post_id,c1_0.id,c1_0.content,p1_0.content,p1_0.title from Post p1_0 join Comment c1_0 on p1_0.id=c1_0.post_id



//------------------------------------------------------------------------
		em.getTransaction().commit(); 
		
		em.close();
	}
}
