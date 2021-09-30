import entity.User;
import org.hibernate.Session;
import util.HibernateUtil;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        user.setAge(30);
        user.setName("Alexander");
        user.setLogin("Ker Tak");
        user.setPassword("7809");

        seveEntit(user);
    }
    public static <T> void seveEntit(T entiti){
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        hibernateSession.save(entiti);
        hibernateSession.getTransaction().commit();
        hibernateSession.close();
        System.out.println("Успех!!! " + entiti.toString());
    }
}
