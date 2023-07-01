package chap3.section6;

import chap2.example.Apple;
import chap2.example.Color;
import chap2.example.Fruit;
import chap2.example.Orange;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.Comparator.comparing;

/**
 * 3.6 메서드 참조
 */
public class TestClass {


    public static void main(String[] args) {

        /**
         * 3.6.1 요약
         */
        // 기존 코드
        List<Apple> inventory = new ArrayList<>();

        inventory.sort((Apple a1, Apple a2) ->{
            Integer overrideA1 = a1.getWeight();
            Integer overrideA2 = a2.getWeight();

            return overrideA1.compareTo(overrideA2);
        });

        // 메서드 참조
        inventory.sort(comparing(Apple::getWeight));

        /**
         * 3.6.2 생성자 참조
         */
        Supplier<Apple> c1 = Apple::new;
        Apple a1 = c1.get();

        Supplier<Apple> c2 = () -> new Apple();
        Apple a2 = c2.get();

        Function<Integer, Apple> c3 = Apple::new;
        Apple a3 = c3.apply(100);

        Function<Integer, Apple> c4 = (Integer) -> new Apple(Integer);
        Apple a4 = c4.apply(120);

        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> apples = map(weights, Apple::new);
    }

    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer i : list) {
            result.add(f.apply(i)); // Function을 이용 Integer -> Apple 변형 후 add
        }
        return result;
    }

    BiFunction<Color, Integer, Apple> c3 = Apple::new;
    Apple a3 = c3.apply(Color.GREEN, 110);

    BiFunction<Color, Integer, Apple> c4 = (color, weigth) -> new Apple(color, weigth);
    Apple a4 = c4.apply(Color.GREEN, 100);

    static Map<String, Function<Integer, Fruit>> map = new HashMap<>();
    static {
        map.put("apple", Apple::new);
        map.put("orange", Orange::new);
    }
    public static Fruit giveMeFruit(String fruit, Integer weight) {
        return map.get(fruit.toLowerCase()).apply(weight);
    }
}
