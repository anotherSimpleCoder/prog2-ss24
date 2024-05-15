package com.example;

public class Mitarbeiter extends Person {
    private String email;

    
    public Mitarbeiter(String vorname, String nachname, String email){
        super(vorname, nachname);
        this.email = email;
    }
    @Override
    public String toString() {
        return String.format("%s (%s)",super.toString(),this.email);
    }
    public void reserviere(){
        
    }
}
