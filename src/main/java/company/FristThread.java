package company;

public class FristThread implements Runnable{
    private int num;
    private int sum;
    @Override

    public void run(){
        num = 2;
        sum = num * 2;
        System.out.println("Поток 1: Умножает переменную на 2: " + sum);
        }

    }

