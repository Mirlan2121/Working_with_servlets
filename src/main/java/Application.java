import entity.Country;
import entity.Department;
import entity.Employee;
import entity.EmployeeAddress;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Country country = Country.builder().name("KG").salary(100000).build();
        Country country1 = Country.builder().name("KZ").salary(100000).build();
        saveEntity(country);
        saveEntity(country1);

        Employee user1 = Employee.builder().fullName("Alexander").age(34).country(country).build();
        Employee user2 = Employee.builder().fullName("Daniel").age(34).country(country1).build();
        Employee user3 = Employee.builder().fullName("Vova").age(34).country(country1).build();
        Employee user4 = Employee.builder().fullName("Ohra").age(34).country(country).build();
        Employee user5 = Employee.builder().fullName("Alexander").age(54).country(country1).build();




        saveEmployee(user1);
        saveEmployee(user2);
        saveEmployee(user3);
        saveEmployee(user4);
        saveEmployee(user5);

        List<Employee> employeeList = getAllBySearchByName();
        System.out.println(employeeList);

        /////////////////////////////////////////////////////////

        Country country3 = Country.builder().name("KG").build();
        Country country2 = Country.builder().name("RU").build();
        saveEntity(country);
        saveEntity(country2);
        //Создаём отделы, необходимые для создания сотрдунков
        Department javaBackendDepartment = Department.builder().name("Java").build();
        Department frontendDepartment = Department.builder().name("Frontend").build();
        Department mobileDepartment = Department.builder().name("Mobile").build();
        saveEntity(javaBackendDepartment);
        saveEntity(frontendDepartment);
        saveEntity(mobileDepartment);

        //Создаём адреса, необходимые для создания сотрдунков
        EmployeeAddress employeeAddress = EmployeeAddress.builder().district("6 мкр").houseNumber(8).flatNumber(20).build();
        EmployeeAddress employeeAddress1 = EmployeeAddress.builder().district("8 мкр").houseNumber(2).flatNumber(14).build();
        EmployeeAddress employeeAddress2 = EmployeeAddress.builder().district("Кок-Жар").houseNumber(17).build();
        EmployeeAddress employeeAddress3 = EmployeeAddress.builder().district("Чон-Арык").houseNumber(25).build();
        saveEntity(employeeAddress);
        saveEntity(employeeAddress1);
        saveEntity(employeeAddress2);
        saveEntity(employeeAddress3);

        //указываем имя, возраст, Адрес и Отдел
//        Employee employee = Employee.builder()
//                .fullName("Петрович Петр")
//                .age(50)
//                .employeeAddress(employeeAddress)
//                .department(javaBackendDepartment)
//                .country(country)
//                .salary(200)
//                .build();
//        Employee employee1 = Employee.builder()
//                .fullName("Македонский Александр")
//                .age(22)
//                .employeeAddress(employeeAddress1)
//                .department(javaBackendDepartment)
//                .country(country2)
//                .salary(500)
//                .build();
//        Employee employee2 = Employee.builder()
//                .fullName("Аширов Адилет")
//                .age(15)
//                .employeeAddress(employeeAddress2)
//                .department(mobileDepartment)
//                .country(country)
//                .salary(400)
//                .build();
//        Employee employee3 = Employee.builder()
//                .fullName("Македонский Александр")
//                .age(50)
//                .employeeAddress(employeeAddress3)
//                .department(javaBackendDepartment)
//                .country(country)
//                .salary(200)
//                .build();
//        saveEntity(employee);
//        saveEntity(employee1);
//        saveEntity(employee2);
//        saveEntity(employee3);
//
//        System.out.println(getEmployees());
//
//        System.out.println("**************");
//        Department javaDepartmentFromDB = getDepartmentById(1L); //получили Java Department из базы
//        System.out.println(javaBackendDepartment);
//        System.out.println(javaDepartmentFromDB.getEmployees()); //вывели сотрудников отдела
//        System.out.println(getEmployees());
//
//        System.out.println("**********");

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
//    public static List<Employee> getAllEmployeesByCountryNameAndDepartmentName(String countryName, String departmentName) {
//        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
//        List<Employee> employees = hibernateSession.createQuery("from Employee e where e.country.name = :countryName and e.department.name = :departmentName", Employee.class)
//                .setParameter("countryName", countryName).setParameter("departmentName", departmentName).list();
//        hibernateSession.close();
//        return employees;
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
    public static List<Employee> getTopThreeSalaryEmployees() {
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        List<Employee> employees = hibernateSession.createQuery("from Employee e order by e.salary desc", Employee.class).setMaxResults(3).list();
        hibernateSession.close();
        return employees;
    }

    public static List<Department> getAllDepartmentsWhereEmployeeInKg() {
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        List<Department> departments = hibernateSession.createQuery("select distinct e.department from Employee e where e.country.name = 'KG'", Department.class).list();
        hibernateSession.close();
        return departments;
    }

    public static List<Employee> getAllEmployeesByCountryNameAndDepartmentName(String countryName, String departmentName) {
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        List<Employee> employees = hibernateSession.createQuery("from Employee e where e.country.name = :countryName and e.department.name = :departmentName", Employee.class)
                .setParameter("countryName", countryName).setParameter("departmentName", departmentName).list();
        hibernateSession.close();
        return employees;
    }

    public static List<Employee> getAllBySearchStringAndAge(Integer age, String searchString) {
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        List<Employee> employees = hibernateSession.createQuery("FROM Employee where age > :age and upper(fullName) like upper(:searchString)", Employee.class)
                .setParameter("age", age)
                .setParameter("searchString", "%" + searchString + "%").list();
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

}
