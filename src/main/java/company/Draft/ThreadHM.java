package company.Draft;

public class  ThreadHM extends Thread{

    private String simbol;
    private int num;

    public ThreadHM(String simbol, int num) {
        this.simbol = simbol;
        this.num = num;
    }

    public String getSimbol() {
        return simbol;
    }

    public void setSimbol(String simbol) {
        this.simbol = simbol;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        ActivSesion();
    }

    void ActivSesion(){

        switch (this.simbol){

            case ("+"): this.num = this.num + 2;break;
            case ("*"): this.num = this.num * 2;break;
            case ("-"): this.num = this.num - 2;break;
            case ("/"): this.num = this.num / 2;break;
        }
        System.out.println(this.simbol);
        System.out.println("Answer numbers: " + num);
    }
}
