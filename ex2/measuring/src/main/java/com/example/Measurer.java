package com.example;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;

public class Measurer {
    Measurement measurement = new Measurement();

    public void start(String args[]) {
        try {
        	switch(args[0]) {
	            case "-f": {
	                this.measureFile(args[1]);
	                break;
	            }
	
	            default: {
	                String result = this.measurement.measure(args[0]);
	                System.out.println(result);
	                break;
	            }
        	}
        } catch(Exception e) {
        	System.err.println(e.getMessage());
        }
    }
    
    private void measureFile(String fileName) throws Exception {
    	if(fileName.isEmpty()) {
    		throw new Exception("Invalid filename!");
    	}
    	
    	FileInputStream fis = new FileInputStream(fileName);
    	BufferedInputStream bis = new BufferedInputStream(fis);
    	
    	String input = new String(bis.readAllBytes());
    	fis.close();
    	
    	String[] inputList = input.split("\r\n");
    	
    	FileOutputStream fos = new FileOutputStream("result.csv");
    	
    	for(String i: inputList) {
    		String result = this.measurement.measure(i);
    		fos.write(result.getBytes());
    	}
    	
    	fos.close();
    }
}
