package company;

public class PrintThread implements Runnable{

    private int num ;
    private int sum;

    @Override
    public void run() {
        num = 2;
        sum = num / 2;
        System.out.println( "Поток 2: Делит переменную на 2 " + sum);
    }
}
