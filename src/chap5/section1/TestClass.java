package chap5.section1;

import chap5.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) {

        /**
         * 5.1.1 프레디케이트로 필터링
         */
        List<Dish> menu = new ArrayList<>();
        List<Dish> vegetarianMenu = menu.stream()
                    .filter(Dish::isVegetarian) // 채식 요리인지 확인하는 메서드참조
                    .collect(Collectors.toList());

    }
}
