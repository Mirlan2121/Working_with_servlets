package company.lessonWork59;

public class OldGeneric {
private Object[] objects = new Object[10];


    public Object[] getObjects() {
        return objects;
    }
    public void add(Object object, int index){
        objects[index] = object;

    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }
}

