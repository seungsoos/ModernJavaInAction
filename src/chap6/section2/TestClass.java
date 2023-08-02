package chap6.section2;

import chap4.Type;
import chap6.CaloricLevel;
import chap6.Dish;

import java.util.*;
import java.util.stream.Collectors;

public class TestClass {

    /**
     * 6.2 리듀싱과 요약
     * @param args
     */
    public static void main(String[] args) {

        List<Dish> menu = new ArrayList<>();

        // Counting 메서드를 이용하여 메뉴에서 요리수를 계산
        long counting1 = menu.stream().collect(Collectors.counting());
        // 불팔요과정을 생략사용가능
        long counting2 = menu.stream().count();

        /**
         * 6.2.1 스트림값에서 최댓값과 최솟값 검색
         */
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> max = menu.stream().collect(Collectors.maxBy(dishComparator));
        Optional<Dish> min = menu.stream().collect(Collectors.minBy(dishComparator));

        /**
         * 6.2.2 요약 연산
         */
        // 총 칼로리 계산
        int totalCalories1 = menu.stream().collect(Collectors.summingInt(Dish::getCalories));

        // 칼로리의 평균값 계산
        Double avgCalories = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));

        // 하나의 요약 연산으로 메뉴에 있는 수, 칼로리합계, 평균, 최댓값, 최솟값등을 계산
        menu.add(new Dish("생선", false, 1200, Type.FISH));
        menu.add(new Dish("돼지고기", false, 2300, Type.MEAT));
        menu.add(new Dish("김치", true, 200, Type.OTHER));
        menu.add(new Dish("양파", true, 300, Type.OTHER));
        menu.add(new Dish("소고기", false, 1000, Type.MEAT));

        IntSummaryStatistics collect = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(collect);

        /**
         * 6.2.3 문자열 연결
         */
        String joiningNames = menu.stream().map(Dish::getName).collect(Collectors.joining());
        System.out.println(joiningNames);

        // 구분자 사용
        String joiningNamesSeparator = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println(joiningNamesSeparator);

        /**
         * 6.2.4 범용 리듀싱 요약 연산
         */
        Integer reducing1 = menu.stream()
                .collect(Collectors.reducing(0, Dish::getCalories, (a, b) -> a + b));
        System.out.println("reducing1 = " + reducing1);

        // 가장 칼로리가 높은 요리를 찾는 방법
        Optional<Dish> reducing2 = menu.stream()
                .collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        System.out.println("reducing2 = " + reducing2);

        Integer reducing3 = menu.stream().collect(Collectors.reducing(0,    // 초깃값
                                                                        Dish::getCalories, // 변환함수
                                                                        Integer::sum)); // 합계 함수

        // 한개의 인수를 갖는 reduce
        int totalCalories2 = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();

    }
}
