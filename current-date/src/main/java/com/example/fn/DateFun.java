package com.example.fn;

import java.util.Date;

public class DateFun {

    public String handleRequest(String input) {

       return new Date(System.currentTimeMillis()).toString();   
	//return "Hello!";
    }

}
