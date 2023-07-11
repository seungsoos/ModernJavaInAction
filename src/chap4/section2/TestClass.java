package chap4.section2;

import chap4.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass {

    public static void main(String[] args) {

        List<Dish> menu = new ArrayList<>();

        /**
         * 파이프라인 연산 만들기
         */
        List<String> threeHighCaloricDishNames = menu.stream()
                .filter(dish -> dish.getCalories() > 300) // 첫번쨰로 고칼로리 요리를 필터링
                .map(Dish::getName)                       // 요리명을 추출
                .limit(3)                         // 3개로 제한
                .collect(Collectors.toList());            //결과를 리스트로 저장

    }
}
