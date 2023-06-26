package chap2;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        Apple apple1 = new Apple();
        apple1.setColor("GREEN");
        apple1.setWeight("100");
        inventory.add(apple1);
        filterGreenApples(inventory);
    }
    public static List<Apple> filterGreenApples(List<Apple> inventory) {

        List<Apple> result = new ArrayList<>(); // 사과 누적 리스트
        for (Apple apple : inventory) {
            if (GREEN.equals(apple.getColor())) { // 녹색사과 만 선택
                result.add(apple);
            }
        }
        return result;
    }
}
