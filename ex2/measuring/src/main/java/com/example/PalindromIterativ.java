package com.example;

public class PalindromIterativ implements Palindrom {
    public boolean istPalindrom(String s){
    	s = s.toLowerCase();
    	
        boolean res = true;
        for(int i = 0; i<s.length();i++){
            int r = s.length()-(i+1);
            if (i > r){
                return res;
            
            } else {
                res = res && (s.charAt(i) == s.charAt(r));
            }
        } return res;
    }
    
}
    
