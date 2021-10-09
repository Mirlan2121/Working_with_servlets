import entity.Product;
import org.hibernate.Session;
import util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        Product product = new Product();
        product.setDescription("daadaf");
        product.setTitle("sdfsf");
        saveEntity(product);

    }
    public static <T> T saveEntity(T entity) {
        entity.getClass();
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        hibernateSession.saveOrUpdate(entity);
        hibernateSession.getTransaction().commit();
        hibernateSession.close();
        return entity;
    }

}
