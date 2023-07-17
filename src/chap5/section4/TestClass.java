package chap5.section4;

import chap4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestClass {

    public static void main(String[] args) {
        List<Dish> menu = null;

        /**
         * 5.4.1 프레디케이트가 적어도 한 요소와 일치하는지 확인
         */
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("vegetarian food");
        }

        /**
         * 5.4.2 프레디케이트가 모든욧고와 일치하는지 검사
         */
        boolean isHealthy1 = menu.stream()
                                .allMatch(dish -> dish.getCalories() < 1000);

        /**
         * noneMatch
         */
        boolean isHealthy2 = menu.stream()
                                .noneMatch(dish -> dish.getCalories() >= 1000);

        /**
         * 5.4.3 요소 검색
         */
        Optional<Dish> dish = menu.stream()
                                .filter(Dish::isVegetarian)
                                .findAny();

        /**
         * 5.4.4 첫번째 요소 찾기
         */
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> first = someNumbers.stream()
                                            .map(x -> x * x)
                                            .filter(x -> x % 3 == 0)
                                            .findFirst();

    }
}
