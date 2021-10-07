package ExamenB;

public class MyTheard implements Runnable{

    private String Langueage;

    public MyTheard(){

    }
    public MyTheard(String Langueage) {
        this.Langueage = Langueage;
    }

    @Override
    public void run() {
        System.out.println(Langueage);
    }
}
