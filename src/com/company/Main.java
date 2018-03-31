package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Calculator calculator = new Calculator(s);
        try {
            calculator.calculate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
