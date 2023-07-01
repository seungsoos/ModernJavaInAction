package chap3.section5;

import chap2.example.Apple;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.ToIntBiFunction;

public class TestClass {

    Comparator<Apple> c1 = (Apple a1, Apple a2) -> {
        Integer a3 = a1.getWeight();
        Integer a4 = a2.getWeight();

        return a3.compareTo(a4);
    };

    ToIntBiFunction<Apple, Apple> c2 = (Apple a1, Apple a2) -> {
        Integer a3 = a1.getWeight();
        Integer a4 = a2.getWeight();

        return a3.compareTo(a4);
    };
    BiFunction<Apple, Apple, Integer> c3 = (Apple a1, Apple a2) -> {
        Integer a3 = a1.getWeight();
        Integer a4 = a2.getWeight();

        return a3.compareTo(a4);
    };
}
