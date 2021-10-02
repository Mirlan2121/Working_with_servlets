import entity.*;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.Arrays;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        Sport sport1 = Sport.builder().name("Футбол").build();
        Sport sport2 = Sport.builder().name("Баскетбол").build();
        Sport sport3 = Sport.builder().name("Волебол").build();
        Sport sport4 = Sport.builder().name("Хокей").build();
        saveEntity(sport1);
        saveEntity(sport2);
        saveEntity(sport3);
        saveEntity(sport4);
//        sport1.setId(1L);
//        sport2.setId(2L);
//        sport3.setId(3L);
//        sport4.setId(4L);

        Country country1 = Country.builder().name("Кыргызстан").build();
        Country country2 = Country.builder().name("Россия").build();
        Country country3 = Country.builder().name("США").build();
        Country country4 = Country.builder().name("Италия").build();

        saveEntity(country1);
        saveEntity(country2);
        saveEntity(country3);
        saveEntity(country4);
//        country1.setId(1L);
//        country2.setId(2L);
//        country3.setId(3L);
//        country4.setId(4L);

        Tournament tournament1 = Tournament.builder().name("Чемпионат по Футболу").country(country4).sport(sport1).build();
        Tournament tournament2 = Tournament.builder().name("Чемпионат по Валейболу").country(country3).sport(sport3).build();
        Tournament tournament3 = Tournament.builder().name("Чемпионат по Баскетболу").country(country2).sport(sport2).build();
        Tournament tournament4 = Tournament.builder().name("Чемпионат по Хокей").country(country1).sport(sport4).build();
        saveEntity(tournament1);
        saveEntity(tournament2);
        saveEntity(tournament3);
        saveEntity(tournament4);


        Team team1 = Team.builder()
                .name("Дордой")
                .country(country1)
                .logo("Находится по адрису1")
                .site("Находитсяс по адрису 1")
                .sport(sport1)
                .build();

        Team team2 = Team.builder()
                .name("Спартак")
                .country(country2)
                .logo("Находится по адрису 2")
                .site("Находитсяс по адрису 2")
                .sport(sport2)
                .build();

        Team team3 = Team.builder()
                .name("CrowStreets")
                .country(country3)
                .logo("Находится по адрису 3")
                .site("Находитсяс по адрису 3")
                .sport(sport3)
                .build();

        Team team4 = Team.builder()
                .name("ДзенЛяпин")
                .country(country4)
                .logo("Находится по адрису3")
                .site("Находитсяс по адрису 3")
                .sport(sport4)
                .build();


        saveEntity(team1);
        saveEntity(team2);
        saveEntity(team3);
        saveEntity(team4);




        System.out.println("=========================================================");

        getAllTeamNameAndWebsite().forEach(i -> System.out.println(Arrays.toString(i)));

        System.out.println("=========================================================");

        getAlLTeamItalyTournament().forEach(System.out::println);

//        List<Tournament> tournamentList = getAllTournament("");
//        System.out.println(tournamentList);
    }

    public static <T> T saveEntity(T entity){
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        hibernateSession.save(entity);
        hibernateSession.getTransaction().commit();
        hibernateSession.close();

        System.out.println("Успешное сохронение " + entity.toString());
        return entity;
    }
    public static Tournament getAllTournament (String name){
       try( Session hibernateSession = HibernateUtil.getSessionFactory().openSession()) {
           Tournament tournamentList = hibernateSession.createQuery(
                           "FROM tournament c where upper(c.name) = upper(:name)", Tournament.class).
                   setParameter("name", name).uniqueResult();

           hibernateSession.close();
           return tournamentList;
       }catch (NonUniqueObjectException e){
           System.err.println(e.getMessage());
           return null;
       }
    }
    public static List<Team> getAlLTeamItalyTournament(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Team> teamList = session.createQuery("from teams where country.name = 'Италия' order by sports",
        Team.class).list();
        session.close();
        return teamList;
    }
    public static List<Object[]> getAllTeamNameAndWebsite(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Object[]> teams = session.createQuery("select t.name, t.logo from teams t order by t.id",
                Object[].class).setMaxResults(3).list();// teams is not mapped [select t.name, t.logo from teams t order by t.id]
        // я не понимая иза чего он не работает
        session.close();
        return teams;
    }
}
