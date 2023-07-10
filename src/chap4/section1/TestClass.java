package chap4.section1;

import chap4.Dish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 스트림이란 무엇인가?
 */
public class TestClass {

    public static void main(String[] args) {

        /**
         * 기존 자바 7코드
         */
        List<Dish> lowCaloricDishes = new ArrayList<>();
        List<Dish> menu = new ArrayList<>();

        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }

        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {   // 익명 클래스 사용
            @Override
            public int compare(Dish dish1, Dish dish2) {
                return Integer.compare(dish1.getCalories(), dish2.getCalories());
            }
        });

        List<String> lowCaloricDishesName1 = new ArrayList<>();
        for (Dish dish : lowCaloricDishes) {
            lowCaloricDishesName1.add(dish.getName());
        }

        /**
         * 자바 8 코드
         */
        List<String> lowCaloricDishesName2 =
                        menu.stream()
                        .filter(d -> d.getCalories() < 400)
                        .sorted(Comparator.comparing(Dish::getCalories))
                        .map(Dish::getName)
                        .collect(Collectors.toList());

        /**
         * parallelStream 사용
         */
        List<String> lowCaloricDishesName3 =
                        menu.parallelStream()
                        .filter(d -> d.getCalories() < 400)
                        .sorted(Comparator.comparing(Dish::getCalories))
                        .map(Dish::getName)
                        .collect(Collectors.toList());

    }
}
