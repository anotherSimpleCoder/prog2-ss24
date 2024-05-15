package com.example;

public class Person {
    private String vorname;
    private String nachname;

    public Person(String v, String n) {
        this.vorname = v;
        this.nachname = n;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.vorname, this.nachname);
    }
}
