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
//            age = answer("How old are you?",
//                    "Restriction: age must include only arabic digits and be biggest than 0")
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
        boolean correctSymbols = true;
        for (int i = 0; i < ans.length(); i++) {
            String s = ans.substring(i,i+1);
            if (!chars.contains(s)){
                System.out.println("Wrong format data!");
                ans = answer(ask, restriction, chars);
            }
        }
        return ans;
    }
}
