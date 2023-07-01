package chap2.section3;

import chap2.example.Apple;
import chap2.example.Color;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

    List<Apple> inventory = new ArrayList<>();

    /**
     *  제네릭 사용
     *
     *  데이터 타입에 의존적이지 않고,
     *  외부에 의해 타입을 지정
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();

        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    List<Apple> redApples = filter(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));

}
