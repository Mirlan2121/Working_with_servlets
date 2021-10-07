package ExamenB;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyTheard("Java"));
        Thread t2 = new Thread(new MyTheard("C#"));
        Thread t3 = new Thread(new MyTheard("PHP"));
        Thread t4 = new Thread(new MyTheard("JavaScript"));
        Thread t5 = new Thread(new MyTheard("Go"));
        Thread t6 = new Thread(new MyTheard("Python"));

        try {
            t1.start();
            t1.join();

            t6.start();
            t6.join();

            t5.start();
            t5.join();

            t4.start();
            t4.join();

            t3.start();
            t2.join();

            t2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
