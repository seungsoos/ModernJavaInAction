package chap5.section8;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestClass {

    /**
     * 5.8 스트림 만들기
     */
    public static void main(String[] args) {

        /**
         * 5.8.1 값으로 스트림 만들기
         */
        Stream<String> modern = Stream.of("Modern", "Java", "In", "Action");
        modern.map(String::toUpperCase).forEach(System.out::println);
        Stream<Object> empty = Stream.empty(); // empty메서드를 이용 Stream을 비울수 있다.

        /**
         * 5.8.2 null이 될 수 있는 객체로 스트림 만들기
         */
        String homeValue = System.getProperty("home");
        Stream<String> homeValueStream1 = homeValue == null ? Stream.empty() : Stream.of("value");

        // ofNullable 사용
        Stream<String> homeValueStream2 = Stream.ofNullable(System.getProperty("home"));

        /**
         * 5.8.3 배열로 스트림 만들기
         */
        int[] numbers = {2, 3, 4, 5, 6, 7, 8};
        int sum = Arrays.stream(numbers).sum();

        /**
         * 5.8.4 파일로 스트림 만들기
         */
        /*long uniqueWords = 0;
        try (Stream<String> lines =
                     Files.lines(Paths.get("data.txt"), Charset.defaultCharset())){
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split("")))
                            .distinct()
                            .count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        /**
         * 5.8.5 함수로 무한 스트림 만들기
         */
        // iterate 메서드
/*
        Stream.iterate(0, n -> n+2)    // 초기값 0에서 +2 증가
                .limit(10)          // 10개
                .forEach(System.out::println);

        // 초깃값 0에서, 0보다 작을때가지, +4 증가
        IntStream.iterate(0, n -> n < 100, n -> n + 4)
                .forEach(System.out::println);
        // filter 메서드가 적용되지않음, 무한 증가
        IntStream.iterate(0, n -> n + 4)
                .filter(n -> n < 100)
                .forEach(System.out::println);
        // 해결방법 : takeWhiles
        IntStream.iterate(0, n -> n + 4)
                .takeWhile(n -> n < 100)
                .forEach(System.out::println);
*/

        //generate 메서드
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }
}
