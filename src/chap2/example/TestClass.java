package chap2.example;

import chap2.section1.AppleFormatter;

import java.util.List;

public class TestClass {

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter appleFormatter) {
        for (Apple apple : inventory) {
            int output = appleFormatter.weight(apple);
            System.out.println(output);
        }
    }
}
