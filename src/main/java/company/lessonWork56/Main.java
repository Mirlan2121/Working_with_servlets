package company.lessonWork56;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Thread firstPilot = new Thread(new Formula1(), "Miki");
        Thread firstPilot1 = new Thread(new Formula1(), "Alex");
        Thread firstPilot2 = new Thread(new Formula1(), "Bakai");
        Thread firstPilot3 = new Thread(new Formula1(), "Chika");
        System.out.println("Start");
        firstPilot.setPriority(Thread.MAX_PRIORITY);
        firstPilot1.setPriority(Thread.MIN_PRIORITY);
        firstPilot2.setPriority(Thread.MIN_PRIORITY);
        firstPilot3.setPriority(Thread.MIN_PRIORITY);


        firstPilot.start();
        firstPilot1.start();
        firstPilot2.start();
        firstPilot3.start();






    }
}
