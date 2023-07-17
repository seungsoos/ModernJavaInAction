package chap5.section3;

import chap4.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        /**
         * map과 Arrays.stream 활용
         */
        List<String> words = null;
        String[] arraysOfWord = {"Goodbye", "World"};
        Stream<String> streamOfWords = Arrays.stream(arraysOfWord);
        words.stream()
                .map(word -> word.split("")) // 각 단어를 개별 문자열로 반환
                .map(Arrays::stream) // 각 배열을 별도의 스트림으로 생성
                .distinct()
                .collect(Collectors.toList());

        /**
         * flatMap 사용
         */
        List<String> uniqueCharacters = words.stream()
                .map(word -> word.split("")) // 각 단어를 개별 문자를 포함하는 배열로 변환
                .flatMap(Arrays::stream) // 생성된 스트림을 하나의 스트림으로 평면화
                .distinct()
                .collect(Collectors.toList());

        /**
         * Quiz 1.
         */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect = numbers.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);

        /**
         * Quiz 2.
         */
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> collect1 = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());

        /**
         * Quiz 3.
         */
        List<int[]> collect2 = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .filter(j -> (i+j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());

    }

}
