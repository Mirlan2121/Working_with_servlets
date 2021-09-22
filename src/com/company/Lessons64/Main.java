package com.company.Lessons64;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream stream = Stream.of("A", "B", "C");
        List<String> arryList = new ArrayList<>();
        arryList.add("A");
        arryList.add("B");
        arryList.add("C");
        arryList.add("D");

        String lasValue = arryList.get( arryList.size() - 1);

        arryList.stream().map(x  -> x.equals(lasValue) ? x + ""  : x + ",").forEach(x -> System.out.println(x));

//        stream.forEach(x -> System.out.print(x + "," ));
    }
}
