package com.company;

import sun.reflect.Reflection;
import sun.tools.java.ClassPath;
import sun.tools.java.Package;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        //testAnnotation();
        testSort();
        //testClassReflection();
        //testVarArgs(1,2,3,4,5);
        //testLambda(315,513, (a, b) -> a * b);
        //testStreamAndFunction();

    }

    private static void testSort(){
        List<String> l = Arrays.asList("Plo","PMo","Pmo");
        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.toUpperCase().compareTo(o2.toUpperCase());
            }
        };

        l.sort(String::compareTo);
        l.forEach(s -> {System.out.print(s + "__");});
        l.sort(c);
        l.forEach(s -> {System.out.print(s + "**");});
    }

    private static void testClassReflection() {
        try {
            Class<?> c = Class.forName("java.security.Identity");
            System.out.format("Class: %n  %s%n%s%n", c.getCanonicalName(), c.getGenericSuperclass());

            for (int i = 0; i < c.getAnnotations().length; i++) {
                System.out.format("Annotations: %n %s %n %n", c.getAnnotations()[i].toString());
            }

        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private static void testAnnotation(){
        try{
            Class<?> c = Class.forName("com.company.TestAnnotation");

            if (c.getAnnotation(MyAnnotation.class) == null){
                System.out.println("No Annotation");
            } else {
                for (Method m : c.getMethods()){
                    MyAnnotation anno = m.getAnnotation(MyAnnotation.class);
                    if (anno != null){
                        m.invoke(c.newInstance(),anno.quotation() + "this is a test" + anno.quotation());
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return;
        }
        return;
    }

    // functional interface
    interface CalcInt{
        int opration(int a, int b);

    }

    private static void testLambda(int m, int n, CalcInt c) {
        System.out.format("** %d op %d = %d %n%n", m, n, c.opration(m, n));

    }

    private static void testVarArgs(int... values) {
        for (int i : values) {
            System.out.println(i);
        }
    }

    private static void testStreamAndFunction() {
        List<Integer> id = Arrays.asList(0, 1, 2, 3);
        List<String> name = Arrays.asList("David", "Andrew", "Micheal", "Emily");
        Function<Integer, String> funcGetName = (Integer i) -> {
            return name.get(i.intValue());
        };
        Function<String, Character> funcGetInit = (String s) -> s.charAt(0);
        id.stream().map(funcGetName).forEach((item) -> System.out.format("%s%n%n",item));
        id.stream().map(funcGetName).filter(s -> s.contains("D") || s.contains("A")).forEach(System.out::println);
        id.stream().map(funcGetName).map(funcGetInit).forEach(System.out::print);
    }
}
