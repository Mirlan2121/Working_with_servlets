import entity.Employee;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Employee employee = Employee.builder().fullName("Mirlan").age(19).build();
//        create(employee);
//        Employee employee1 = Employee.builder().fullName("Alex").age(30).build();
//        create(employee1);
        List<Employee> list = reade();
        System.out.println(list);

    }
    public static Long create(Employee e){
        Session HibernateSession =
                HibernateUtil.getSessionFactory().openSession();
        HibernateSession.beginTransaction();
        HibernateSession.save(e);
        HibernateSession.getTransaction().commit();
        HibernateSession.close();
        System.out.println("Успешный создан" + e.toString());
        return e.getId();
    }
    public static List<Employee> reade(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Employee> employees =session.createQuery("FROM Employee").list();
        session.close();
        System.out.println("Найден: " + employees.size() + "Сотрудник");
        return employees;
    }
}
