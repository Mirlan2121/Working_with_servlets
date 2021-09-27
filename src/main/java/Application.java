import entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class Application {
    public static void main(String[] args) {

    }
    public static Long saveEmployee(Employee e){
        Session HibernateSession =
                HibernateUtil.getSessionFactory().openSession();
        HibernateSession.beginTransaction();
        HibernateSession.save(e);
        HibernateSession.getTransaction().commit();
        HibernateSession.close();
        System.out.println("Успешный создан" + e.toString());
        return e.getId();
    }
    public static List<Employee> getAllEmployee(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Employee> employees =session.createQuery("FROM Employee", Employee.class).list();
        session.close();
        System.out.println("Найден: " + employees.size() + "Сотрудник");
        return employees;
    }

    public static Employee updateEmployee(Employee employee) {
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        Employee employeeFromDB = hibernateSession.load(Employee.class, employee.getId());
        employeeFromDB.setFullName(employee.getFullName());
        employeeFromDB.setAge(employee.getAge());
        hibernateSession.getTransaction().commit();
        hibernateSession.close();
        System.out.println("Успешно изменен " + employeeFromDB);
        return employeeFromDB;
    }
    public static Employee findById (Long id){
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Employee employee = hibernateSession.load(Employee.class, id);
        hibernateSession.close();
        return employee;
    }
    public static void deleteById (Long id){
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        Employee employee = findById(id);
        hibernateSession.delete(employee);
        hibernateSession.getTransaction().commit();
        hibernateSession.close();
        System.out.println("Успешно удален" + employee);
    }
    public static void deleteAll(){
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        Query query = hibernateSession.createQuery("DELETE FROM Employee");
        query.executeUpdate();
        hibernateSession.getTransaction().commit();
        hibernateSession.close();
    }
}
