package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final String NAME = "Name";
        final String AGE = "Age";
        final String CITY = "City";
        final String HOBBIES = "Hobbies";

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
        String[] names = { NAME, AGE, CITY, HOBBIES };
        String[] data = { name, "" + age, city, hobbies };

        try {
            System.out.println("\n");
            Thread.sleep(1000);
            System.out.println("1:");
            Thread.sleep(1500);
            printAsTable(names, data);

            System.out.println("\n");
            Thread.sleep(1000);
            System.out.println("2:");
            Thread.sleep(1500);
            System.out.printf("Человек по имени %s живет в городе %s.\n" +
                    "Этому человеку %d лет и любит он заниматься %s.", name, city, age, hobbies);

            System.out.println("\n");
            Thread.sleep(1000);
            System.out.println("3:");
            Thread.sleep(1500);
            printTextFormat(names, data);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    private static void printAsTable(String[] namesCol, String[] datas){
//sets lohg of table
        final int COUNT_COL = namesCol.length;
        int lengthTable;
        int lengthColum = 0;
        int lengthDatas = 0;
        for (int i = 0; i < COUNT_COL; i++) {
            if (namesCol[i].length() > lengthColum) lengthColum = namesCol[i].length();
            if (datas[i].length() > lengthDatas) lengthDatas = datas[i].length();
        }
        lengthTable = lengthColum + 2 + lengthDatas + 2;

        for (int i = 0; i < COUNT_COL; i++) {
            for (int j = 0; j < lengthTable+2; j++) {
                System.out.print('-');
            }
            System.out.println();
            System.out.print("| " + namesCol[i]);
            for (int j = namesCol[i].length(); j < lengthColum; j++) {
                System.out.print(' ');
            }
            System.out.print(" | " + datas[i]);
            for (int j = datas[i].length(); j < lengthDatas+1; j++) {
                System.out.print(' ');
            }
            System.out.println('|');
        }
        for (int j = 0; j < lengthTable+2; j++) {
            System.out.print('-');
        }
    }
    private static void printTextFormat(String[] namesCol, String[] data){
        for (int i = 0; i < namesCol.length; i++) {
            System.out.println(namesCol[i] + " - "+ data[i]);
        }
    }

}
