package com.company;

public class Main {
    public static void main(String[] args) {
    MyList<String> list = new MyList<>();
    list.addFirstElement("FirstElement");
    list.addLastElement("LastElement");
    list.addFirstElement("IntermediaWrite");

        System.out.println(list.getIndexElement(1));
    }
}
