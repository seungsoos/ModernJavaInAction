package chap4.section4;

import chap4.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass {

    public static void main(String[] args) {

        /**
         * 4.4.1 중간 연산
         */
        List<Dish> menu = new ArrayList<>();
        List<String> names = menu.stream()
                .filter(dish -> {
                    System.out.println("filtering : " + dish.getName());
                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping : " + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
    }
}
