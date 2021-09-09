package company;

public class SecondThread implements Runnable{
    private int sum;
    private int num;
    @Override
    public void run() {
        num = 2;
       sum = num + 2;
        System.out.println("Поток 3: Добавляет к переменной 2: " + sum);
    }
}
