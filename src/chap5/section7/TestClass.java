package chap5.section7;

import chap4.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestClass {

    /**
     * 5.7 숫자형 스트림
     */
    public static void main(String[] args) {

        List<Dish> menu = new ArrayList<>();
        Integer reduce = menu.stream()
                            .map(Dish::getCalories)
                            .reduce(0, Integer::sum);

        /**
         * 5.7.1 기본형 특화 스트림
         */
        // 숫자 스트림으로 매핑
        int sum = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();

        // 객체 스트림으로 복원하기
        IntStream intStream = menu.stream()
                .mapToInt(Dish::getCalories); // Stream -> IntStream 변환
        Stream<Integer> boxed = intStream.boxed(); // IntStream -> Stream 변환

        // 기본값 : OptionalInt
        OptionalInt max = menu.stream().mapToInt(Dish::getCalories).max();

        /**
         * 5.7.2 숫자 범위
         */
        IntStream intStream1 = IntStream.rangeClosed(1, 100) // 1부터 100까지
                .filter(x -> x % 2 == 0); // 짝수

    }
}
