package com.example;

public class PalindromRekursiv implements Palindrom {
    private int l;
    private int r;

    public boolean istPalindrom(String s){
        l = 0;
        r = s.length()-1;
        return check(s.toLowerCase(), l, r);
    }

    private boolean check(String s,int l,int r) {
    	if(l <= r) {
    		return true;
    	}
    	
        if(s.charAt(l) != s.charAt(r)) {
            return false;
        } else {
            return true && check(s,l++,r--);
        } 
    }
}
