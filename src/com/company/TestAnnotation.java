package com.company;

/**
 * Created by lvlihong on 3/2/18.
 */
@MyAnnotation
public class TestAnnotation {
    @MyAnnotation(quotation = "^^^^")
    public void printQuotation(String s){
        System.out.println(s);
    }
}

