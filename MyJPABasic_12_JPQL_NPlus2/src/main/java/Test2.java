import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import config.MyPersistenceUnitInfo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import entity.Team;
import entity.Member;

public class Test2 {
    public static void main(String[] args) {
        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true");
        //props.put("hibernate.hbm2ddl.auto", "update");

        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new MyPersistenceUnitInfo(), props);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        // --------------------------------------------------------------

        // 1. N+1 발생 확인
//        String jpql = "select t from Team t";
//        List<Team> teamList = em.createQuery(jpql, Team.class).getResultList();
//        teamList.forEach(team -> team.getMembers().size());

        // 2. FetchType.EAGER 지정해도 여전히 N+1
//        String jpql = "select t from Team t";
//        List<Team> teamList = em.createQuery(jpql, Team.class).getResultList();
//        teamList.forEach(team -> team.getMembers().size());

        // 3. find() 사용해도 개별 조회일 뿐 join X
//        em.find(Team.class, 1);
//        em.find(Team.class, 2);
//        em.find(Team.class, 3);

        // 4. 조건 검색 시에도 N+1 발생
//        String jpql = "select t from Team t where t.id = 1";
//        List<Team> teamList = em.createQuery(jpql, Team.class).getResultList();
//        teamList.forEach(team -> team.getMembers().size());

        // 5. 해결 방법 - join fetch 사용
//        String jpql = "select t from Team t join fetch t.members";
//        List<Team> teamList = em.createQuery(jpql, Team.class).getResultList();
//        teamList.forEach(team -> team.getMembers().size());

        // --------------------------------------------------------------
        em.getTransaction().commit();
        em.close();
    }
}
