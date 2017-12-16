package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String name, city, hobbies;
        int age;
        String chars = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM " +
                "йцукенгшщзхїфівапролджєячсмитьбюЙЦУКЕНГШЩЗХЇФІВАПРОЛДЖЄЯЧСМИТЬБЮ" +
                "’-\'\"";

        name = answer( "Enter you name",
                       "Restriction: name must include symbols of english or ukrainian alphabet, and not contains digits",
                        chars);
        age  = answer("How old are you?",
                 "Restriction: age must include only arabic digits and be biggest than 0");
        city = answer("Where are you from?",
                      "Restriction: name must include symbols of english or ukrainian alphabet, and not contains digits",
                        chars);
        hobbies = answer("What you hobbies?");

        System.out.println();

    }
/*
 *  method answer() asks and write restriction,
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
/*
 *  reload answer():
 *  return integer, checked format and currently enter (>0 & < 160(optimist))
 */
    private static int answer(String ask, String restriction){
        System.out.println(ask);
        System.out.println(restriction);
        System.out.println(":>");

        int ans;
        try {
            ans = new Scanner(System.in).nextInt();
            if ((ans < 0)||(ans > 160)) throw new Exception();
        } catch (Exception e) {
            System.out.println("Wrong data!");
            try {
                Thread.sleep(900);
            } catch (InterruptedException e1) {
                e.printStackTrace();
            }
            ans = answer(ask, restriction);
        }
        return ans;
    }
/*
 *  reload answer() - entering data not have restrictions
 */
    private static String answer(String ask){
        System.out.println(ask);
        System.out.println(":>");
        return new Scanner(System.in).nextLine();
    }

}
