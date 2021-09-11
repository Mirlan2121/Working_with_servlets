package company.lessonWork56;

public class Formula1 implements Runnable {

    public volatile static int num = 1;
    private String man;
    public Formula1() {
    }

    public String getMan() {
        return man;
    }

    public void setMan(String man) {
        this.man = man;
    }
    @Override
    public  void run(){
        System.out.println(Thread.currentThread().getName() + " занял " + num++ + " место");
    }
}

