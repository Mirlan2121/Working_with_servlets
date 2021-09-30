import entity.Course;
import entity.Group;
import entity.Mentor;
import entity.Student;
import org.hibernate.Session;
import util.HibernateUtil;


public class Application {
    public static void main(String[] args) {
        Group group = new Group();
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.close();
//        saveEntity(group);
//        student.setFullName("Мирлан");
//        student.setFullName("Александр");
//        student.setFullName("Азат");
//        student.setFullName("Чингиз");
//        student.setFullName("Елена");
//        student.setFullName("Айзада");
//        student.setFullName("Азамат");
//        student.setFullName("Бакай");

        /*
         * Задача B (30 баллов):
         * Ответить своими словами:
         * Привести примеры из реальной жизни следующих видов связи: OneToOne, ManyToOne, OneToMany и ManyToMany
         * 1 OneToOne один паспорот одному человеку. ManeToOne много пассижиров к одному автобусу. OneToMany одному
         * человеку много автомабилов.ManyToMany многи люди в многих одеждах
         * Что такое Jpa
         * 2JPA - это технология, обеспечивающая объектно-реляционное отображение простых JAVA объектов и
         * предоставляющая API для сохранения, получения и управления такими объектами.
         * простыми словами это храние и обработка данных
         * Что такое ORM и Hibernate
         * 3 Hibernate - ORM, JPA, JPQL. ORM (Object-Relational Mapping, объектно-реляционное отображение) —
         * технология программирования, которая связывает базы данных с концепциями объектно-ориентированных
         * языков программирования. В объектно-ориентированном программировании объекты приложения
         * представляют объекты реального мира
         *
         *
         *
         *
         */

//        Group group = new Group();
//        group.setName("Java-W21");
//        group.setName("Fronde_W21");
//        group.setName("Python_W21");
//        group.setName("PHP_W21");
//        saveEntit(group);
//
//        Course course = new Course();
//        course.setName("Java");
//        course.setName("Frondet");
//        course.setName("Python");
//        course.setName("PHP");
//        saveEntit(course);
//
//        Mentor mentor = new Mentor();
//        mentor.setFullName("Елена Белована");
//        mentor.setFullName("Николая Галустаян");
//        mentor.setFullName("Айдин Сабуров");
//        mentor.setFullName("Шамил Сатаров");
//        saveEntit(mentor);



//        User user = new User();
//        user.setAge(30);
//        user.setName("Alexander");
//        user.setLogin("Ker Tak");
//        user.setPassword("7809");
//
//        seveEntit(user);
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
}
