package company.Homework59;

public class OldGeneric {
    private Object val;

    public OldGeneric(Object val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "(" + val +
                ')';
    }

    public Object getVal() {
        return val;
    }

}
