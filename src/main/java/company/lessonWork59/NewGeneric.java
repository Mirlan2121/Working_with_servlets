package company.lessonWork59;

public class NewGeneric <T>{
    private T value;


    public NewGeneric(T value){
        this.value =value;
    }
    public T getValue(){
        return value;
    }
}
