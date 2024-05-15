package com.example;

public class Uhrzeit {
    private int stunde;
    private int minute;

    public Uhrzeit(int stunde, int minute) {
        this.stunde = stunde;
        this.minute = minute;
    }

    @Override
    public String toString() {
        return String.format("%d:%d Uhr", this.stunde, this.minute);
    }
}
