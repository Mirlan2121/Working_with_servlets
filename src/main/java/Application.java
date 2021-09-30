import entity.Country;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import javax.swing.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Country country = Country.builder().name("KG").salary(100000).build();
        Country country1 = Country.builder().name("KZ").salary(100000).build();
        saveEntity(country);
        saveEntity(country1);

        Employee user1 = Employee.builder().name("Alexander").age(34).country(country).build();
        Employee user2 = Employee.builder().name("Daniel").age(34).country(country1).build();
        Employee user3 = Employee.builder().name("Vova").age(34).country(country1).build();
        Employee user4 = Employee.builder().name("Ohra").age(34).country(country).build();
        Employee user5 = Employee.builder().name("Alexander").age(54).country(country1).build();




        saveEmployee(user1);
        saveEmployee(user2);
        saveEmployee(user3);
        saveEmployee(user4);
        saveEmployee(user5);

        List<Employee> employeeList = getAllBySearchByName();
        System.out.println(employeeList);


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
    public static List<Employee> getAllEmployeesByCountryNameAndDepartmentName(String countryName, String departmentName) {
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        List<Employee> employees = hibernateSession.createQuery("from Employee e where e.country.name = :countryName and e.department.name = :departmentName", Employee.class)
                .setParameter("countryName", countryName).setParameter("departmentName", departmentName).list();
        hibernateSession.close();
        return employees;
    }

//    public static Employee updateEmployee(Employee employee) {
//        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
//        hibernateSession.beginTransaction();
//        Employee employeeFromDB = hibernateSession.load(Employee.class, employee.getId());
//        employeeFromDB.setFullName(employee.getFullName());
//        employeeFromDB.setAge(employee.getAge());
//        hibernateSession.getTransaction().commit();
//        hibernateSession.close();
//        System.out.println("Успешно изменен " + employeeFromDB);
//        return employeeFromDB;
//    }
//    public static Employee findById (Long id){
//        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
//        Employee employee = hibernateSession.load(Employee.class, id);
//        hibernateSession.close();
//        return employee;
//    }
//    public static void deleteById (Long id){
//        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
//        hibernateSession.beginTransaction();
//        Employee employee = findById(id);
//        hibernateSession.delete(employee);
//        hibernateSession.getTransaction().commit();
//        hibernateSession.close();
//        System.out.println("Успешно удален" + employee);
//    }
//    public static void deleteAll(){
//        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
//        hibernateSession.beginTransaction();
//        Query query = hibernateSession.createQuery("DELETE FROM Employee");
//        query.executeUpdate();
//        hibernateSession.getTransaction().commit();
//        hibernateSession.close();
//    }
    public List<Employee> gegtEmployeeByName(String searchFullName){
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();

        List<Employee> employees = hibernateSession.createQuery("FROM Employee where name = : pname",Employee.class).
                setParameter("pname", "Miki").list();

        hibernateSession.close();
        System.out.println("Найден: " + employees.size() + "Сотрудник");
        return employees;
    }
    public static List<Employee> getAllBySearchByName(){
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        List<Employee> employees =  hibernateSession.createQuery("FROM Employee where age > : age and name like:searchString")
                .setParameter("age", 18)
                .setParameter("searchString", "V%").list();
        hibernateSession.close();
        return employees;
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
