package com.company;

public class Stundet {
    private int id;
    private int count;
    private String name;

    public Stundet() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Stundet{" +
                "id=" + id +
                ", count='" + count + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
