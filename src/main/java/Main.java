import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));
    }
}
