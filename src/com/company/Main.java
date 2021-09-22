package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Double> arrayString = new ArrayList<>();
        int count = 0;
        for (double i = 0; i < 10; i++) {
            arrayString.add(i);
        }
//        arrayString.stream().map(x -> x / 10).forEach(x -> System.out.println(x));

//        List<String> winter = new ArrayList<>();
//        winter.add("Mirlan");
//        winter.add("Alex");
//        winter.add("Azat");
//        winter.stream().forEach(x -> System.out.println(x.replace("a", "o")));
//        winter.stream().map(x -> x + x).forEach(x -> System.out.println(x));

//        List<Stundet> stundets = new ArrayList<>();
//        Stundet stundet1 = new Stundet();
//        stundet1.setName("saaas");
//        stundet1.setName("saaas2");
//        stundet1.setName("saaas3");
//        stundet1.setName("saaas4");
//        stundet1.setId(12);
//        stundets.add(stundet1);
//      List<String > studentString = stundets.stream().map(x -> stundet1.getName()).collect(Collectors.toList());

        Stundet stundet = new Stundet();
        stundet.setName("Miki");
        stundet.setName("Alex");
        stundet.setName("Bakai");

        stundet.setId(1);
        stundet.setId(2);
        stundet.setId(3);

        stundet.setCount(2);
        stundet.setCount(4);
        stundet.setCount(5);

//        List<Stundet> arrayStudent = new ArrayList<>();
//        arrayStudent.add(stundet);
//        arrayStudent.stream().filter(x -> stundet.getCount() > 2).forEach(x -> System.out.println(stundet));

        List<Stundet> arrayStu = Stream.of(stundet).filter(x -> x.getCount()> 3).collect(Collectors.toList());
        arrayStu.stream().forEach(x -> System.out.println(x.getName()));
        // stream это своего рода поток данных трансилироваюшя
    }
}
