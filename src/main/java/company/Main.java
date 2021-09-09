package company;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Обший поток");
        Thread thread = new Thread(new FristThread());
        thread.start();
        Thread thread1 = new Thread(new PrintThread());
        thread1.start();
        Thread thread2 = new Thread(new SecondThread());
        thread2.start();

        }
    }

