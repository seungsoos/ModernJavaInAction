package chap3.section8;

import chap2.example.Apple;
import chap2.example.Color;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * 3.8 람다 표현식을 조합 할 수 있는 유용한 메서드
 */
public class TestClass {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();

        /**
         * 3.8.1 Comparator 조합
         */
        Comparator<Apple> c = comparing(Apple::getWeight);

        /**
         * 역정렬
         */
        inventory.sort(comparing(Apple::getWeight).reversed());

        /**
         * Comparator 연결
         */
        inventory.sort(comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getColor)); // 색깔별로 정렬

        /**
         * 3.8.2 Predicate 조합
         */

    }
}
