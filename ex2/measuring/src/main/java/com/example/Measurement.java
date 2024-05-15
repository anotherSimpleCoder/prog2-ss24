package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Measurement {

    private Palindrom[] palindrom = {
        new PalindromIterativ(),
        new PalindromRekursiv()
    };

    private String[] types = {
    	"iterative",
    	"recursive"
    };

    private ArrayList<String> results = new ArrayList<>();

    public String measure(String s) throws Exception{
        int type = 0;
        long time = 0;
        String csvResult = "";

        for(Palindrom p : palindrom){
            long start = System.nanoTime();
            boolean b = p.istPalindrom(s);
            
            if(!b) {
            	throw new Exception("This is not a palindrome!");
            }
            
            long end = System.nanoTime();
            time = end - start;

            csvResult += String.format("%d,%s,%d\n",s.length(), types[type], time);
            type++;
        }

        return csvResult;
    }
    
    private void writeFile(){
        try(FileWriter fw =new FileWriter("measurement.csv")){
            fw.write("length,type,time\n");
            fw.write(String.join("\n", results));
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
    }

}
