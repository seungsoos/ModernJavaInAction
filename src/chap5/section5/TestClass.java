package chap5.section5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestClass {

    public static void main(String[] args) {

        /**
         * 5.5.1 요소의 합
         */
        List<Integer> numbers = Arrays.asList(4, 5, 3, 9);

        Integer reduce = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduce);

        /**
         * 메서드 참조 사용
         */
        Integer reduce1 = numbers.stream().reduce(0, Integer::sum);

        /**
         * 초깃값 없음
         */
        Optional<Integer> reduce2 = numbers.stream().reduce((a, b) -> (a + b));

        /**
         * 5.5.2 최댓값과 최솟값
         */
        Optional<Integer> reduceMax = numbers.stream().reduce(Integer::max);
        Optional<Integer> reduceMin = numbers.stream().reduce(Integer::min);
    }
}
