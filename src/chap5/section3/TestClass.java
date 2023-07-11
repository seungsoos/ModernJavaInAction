package chap5.section3;

import chap4.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass {

    public static void main(String[] args) {

        List<Dish> menu = new ArrayList<>();

        /**
         * 5.3.1 스트림의 각 요소에 함수 적용하기
         */
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());

        // 요리명의 길이 추가
        List<Integer> dishNameLengths = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());

        /**
         * 5.3.2 스트림 평면화
         */
        List<String> list = Arrays.asList("Hello", "World");

        List<String[]> result = list.stream()
                .map(word -> word.split(""))
                .distinct().collect(Collectors.toList());

        result.stream().forEach(x -> System.out.println(Arrays.toString(x)));
    }
}
