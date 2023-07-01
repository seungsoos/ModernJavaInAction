package chap3.section8;

import chap2.example.Apple;
import chap2.example.Color;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

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
        Predicate<Apple> redApples = (Apple apple) -> Color.RED.equals(apple.getColor());
        // redApples의 결과를 반전시킨다.
        Predicate<Apple> notRedApple = redApples.negate();
        // 두 Predicate를 연결하여 새로운 Predicate로 만든다.
        Predicate<Apple> redAndHeavyApples = redApples.and((apple -> apple.getWeight() > 150));
        // Predicate 를 연결하여 복잡한 Predicate를 만든다.
        Predicate<Apple> redAndHeavyAppleOrGreen = redApples.and(apple -> apple.getWeight() > 150)
                                                .or(apple -> Color.GREEN.equals(apple.getColor()));

        /**
         * 3.8.3 Function 조합
         */
        // andThen
        Function<Integer, Integer> f1 = x -> x + 1;
        Function<Integer, Integer> g1 = x -> x * 2;
        Function<Integer, Integer> h1 = f1.andThen(g1);
        int result1 = h1.apply(1); // 4을 반환

        // compose
        Function<Integer, Integer> f2 = x -> x + 1;
        Function<Integer, Integer> g2 = x -> x * 2;
        Function<Integer, Integer> h2 = f2.compose(g2);
        int result2 = h2.apply(1); // 3을 반환

    }

}
