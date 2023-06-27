package chap2.section1;

import chap2.section2.ApplePredicate;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {
        List<Apple> inventory = null;
//        List<Apple> greenApples = filterApple(inventory, Color.GREEN, 0, true);
//        List<Apple> redApples = filterApple(inventory, null, 150, false);
    }
    public static List<Apple> filterApple(List<Apple> inventory, ApplePredicate  applePredicate) {

        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (applePredicate.test(apple)) { // ApplePredicate 객체를 이용한 사과 검사 조건
                result.add(apple);
            }
        }
        return result;
    }
}
