package company.Homework59;

public class Main {
    public static void main(String[] args) {

        OldGeneric var = new OldGeneric(23);
        OldGeneric var2 = new OldGeneric("String");
        System.out.println(var);
        System.out.println(var2);

        var = var2;
        System.out.println(var);


        NewGeneric<Integer> num = new NewGeneric<>(14);
        NewGeneric<String> write = new NewGeneric<>("Hi");

        System.out.println(num);
        System.out.println(write);
    }
    /*
    Для чего нужны Generics?
    Примеры Generic классов в Java?
    Почему плохо создавать поля так: Object value; нежели T value?
     */
}
