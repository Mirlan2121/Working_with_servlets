package ExamenA;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Student> students = createStudent(10);
        System.out.println(getNameList(students));
        System.out.println(getNameListByAge(students, 10));
        printAnonymos(students);
        System.out.println(getNameFristLetterList(students));


    }

    public static List<String> getNameList(List<Student> students) {
        return students.stream().map(Student::getName).collect(Collectors.toList());
    }

    public static List<String> getNameListByAge(List<Student> students, int minAge) {
        return students.stream().filter(x -> x.getAge() > minAge).map(Student::getName).collect(Collectors.toList());
    }

    public static void printAnonymos(List<Student> students) {
        students.forEach(x -> System.out.println("ID" + x.getId() + " ,Средная оценка: "
                + new DecimalFormat("#0.00").format(x.getAverage())));
    }

    public static List<String> getNameFristLetterList(List<Student> students) {
        return students.stream().map(x -> x.getName().charAt(0) + "" + x.getName().length()).collect(Collectors.toList());
    }

    private static List<Student> createStudent(int count) {
        List<Student> students = new ArrayList<>(count);
        String[] names = {"Мирлан", "Алксандр", "Чингиз", "Нурдин", "Азат", "Аброр", "Бермет", "Алманбет", "Максим", "Бакай", "Эсен"};
        Random random = new Random();
        for (int i = 0; i < count; i++)
            students.add(Student.builder().
                    id(i + 1L)
                    .name(names[random.nextInt(names.length)])
                    .average(2 + random.nextInt(2) + random.nextDouble()).age(7 + random.nextInt(11))
                    .gender(random.nextBoolean())
                    .build());
        return students;
    }

}
