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
 * удобство использования методов общих для всех обьектов и классов.
 * Абстрактные возможности котоыре позволяют не повторять постоянно повторяющиеся код.
 * как примермассив в качестве хранения большого количества данных.
 *
 * Примеры Generic классов в Java?
 * листы, мапы, клас Object, цикл foreach
 *
 * Почему плохо создавать поля так: Object value; нежели T value?
 * потому что может произойти колизия в логике что приведет к ошибке.
 * и чтобы не было путаницы в использовании того или другого метода за ним закрепляется класс
 * что позволяет не путаться в использовании одного и того же генерика.
 * так же не вижу смысл обьявлять Object в геенерике так как сам класс object в него можно передать.
     */
}
