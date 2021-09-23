package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            map.put(i, "{write [" + i + "]}");
        }
        map.entrySet().stream().filter(e -> e.getKey() > 5).forEach(e -> System.out.print(e.getValue() + " "));
        System.out.println();
        map.entrySet().stream().filter(e -> e.getKey() % 3 == 0).forEach(e -> System.out.print(e.getValue() + ", "));
        System.out.println();
        int num = map.entrySet()
                .stream()
                .filter(e -> e.getValue().length() > 5)
                .mapToInt(Map.Entry::getKey)
                .reduce(1, (x, y) -> x * y);
        System.out.println(num);
        System.out.println();


        List<Integer> list = new ArrayList<>();
        Random ran = new Random();
        for (int i = 0; i < 100; i++) {
            list.add(ran.nextInt(100 - 1 + 1) + 1);
        }
        list.stream().filter(e -> e % 2 == 0).forEach(e -> System.out.print("["+e + "] "));
        System.out.println();
        List<Integer> listNums = list.stream().filter(e -> e % 2 != 0).map(e -> e + 10).collect(Collectors.toList());
        System.out.println(listNums);

    }
}
