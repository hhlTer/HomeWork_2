package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String name, city, hobies;
        int age;
        String chars = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM " +
                "йцукенгшщзхїфівапролджєячсмитьбюЙЦУКЕНГШЩЗХЇФІВАПРОЛДЖЄЯЧСМИТЬБЮ" +
                "’-\'\"";
            name = answer( "Enter you name",
                     "Restriction: name must include symbols of english or ukrainian alphabet, and not contains digits",
                                chars);

        System.out.println(name);
            age = answer("How old are you?",
                    "Restriction: age must include only arabic digits and be biggest than 0");
        System.out.println(age);
            city = answer("Where are you from?",
                    "Restriction: name must include symbols of english or ukrainian alphabet, and not contains digits",
                               chars);
        System.out.println("city " + city);
    }
/*
 *  method asks and write restriction,
 *  array chars uses as mask, for checking entering symbols
 *
 *  метод запитує і виводить інформацію про обмеження вводу
 *  масив chars використовується як маска для перевірки введених символів
 *
 */
    private static String answer(String ask, String restriction, String chars){
        System.out.println(ask);
        System.out.println(restriction);
        System.out.println(":>");

        String ans = new Scanner(System.in).nextLine();
        for (int i = 0; i < ans.length(); i++) {
            String s = ans.substring(i,i+1);
            if (!chars.contains(s)){
                System.out.println("Wrong format data!");
                try {
                    Thread.sleep(900);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ans = answer(ask, restriction, chars);
            }
        }
        return ans;
    }
    private static int answer(String ask, String restriction){
        System.out.println(ask);
        System.out.println(restriction);
        System.out.println(":>");

        int ans;
        try {
            ans = new Scanner(System.in).nextInt();
            if (ans < 0) throw new Exception();
        } catch (Exception e) {
            System.out.println("Wrong format data!");
            try {
                Thread.sleep(900);
            } catch (InterruptedException e1) {
                e.printStackTrace();
            }
            ans = answer(ask, restriction);
        }
        return ans;
    }
}
