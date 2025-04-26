import java.util.HashMap;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;
import entity.Lecture;
import entity.Professor;
import entity.Student;
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
		
		Professor p = new Professor();
		p.setName("교수1");
		
		Lecture l1 = new Lecture();
		l1.setName("자료 구조");
		l1.setProfessor(p);
		Lecture l2 = new Lecture();
		l2.setName("컴퓨터 구조");
		l2.setProfessor(p);
		Student s1 = new Student();
		s1.setName("홍길동");
		s1.setMajor("컴퓨터 공학");
		s1.setLecture(l1);
		Student s2 = new Student();
		s2.setName("이길동");
		s2.setMajor("컴퓨터 공학");
		s2.setLecture(l1);
		Student s3 = new Student();
		s3.setName("삼길동");
		s3.setMajor("산업 공학");
		s3.setLecture(l2);
		Student s4 = new Student();
		s4.setName("사길동");
		s4.setMajor("기계 공학");
		s4.setLecture(l2);
		
		em.persist(p);
		em.persist(l1);
		em.persist(l2);
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.persist(s4);
		
		
//------------------------------------------------------------------------
		em.getTransaction().commit(); //(이 시점에 테이블에 반영한다.)
		
		em.close();
	}
}
