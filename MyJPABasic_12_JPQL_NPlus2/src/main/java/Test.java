import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import entity.Team;
import entity.Member;

public class Test {
    public static void main(String[] args) {
        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "create");

        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new MyPersistenceUnitInfo(), props);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        // --------------------------------------------------------------
     // 테스트 데이터 삽입
        Team team1 = new Team();
        team1.setName("Backend Team");

        Team team2 = new Team();
        team2.setName("Frontend Team");

        Team team3 = new Team();
        team3.setName("AI Research Team");

        em.persist(team1);
        em.persist(team2);
        em.persist(team3);

        Member m1 = new Member();
        m1.setName("Alice");
        m1.setTeam(team1);

        Member m2 = new Member();
        m2.setName("Bob");
        m2.setTeam(team1);

        Member m3 = new Member();
        m3.setName("Charlie");
        m3.setTeam(team2);

        Member m4 = new Member();
        m4.setName("Diana");
        m4.setTeam(team2);

        Member m5 = new Member();
        m5.setName("Edward");
        m5.setTeam(team3);

        Member m6 = new Member();
        m6.setName("Fiona");
        m6.setTeam(team3);

        em.persist(m1);
        em.persist(m2);
        em.persist(m3);
        em.persist(m4);
        em.persist(m5);
        em.persist(m6);


        // --------------------------------------------------------------
        em.getTransaction().commit();
        em.close();
    }
}
