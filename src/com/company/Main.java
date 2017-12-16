package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

    }
    static String answer(String ask){
        System.out.println(ask);
        System.out.println(":>");
        return new Scanner(System.in).nextLine();
    }
}
