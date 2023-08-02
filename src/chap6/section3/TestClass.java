package chap6.section3;

import chap4.Type;
import chap6.CaloricLevel;
import chap6.Dish;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;


public class TestClass {

    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Type.OTHER),
                new Dish("prawns", false, 300, Type.FISH),
                new Dish("rice", true, 350, Type.OTHER),
                new Dish("chicken", false, 400, Type.MEAT),
                new Dish("french fries", true, 480, Type.OTHER)
        );
        /**
         * 6.3 그룹화
         */
        Map<Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);

        menu.stream().collect(groupingBy(dish -> {
            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
            else return CaloricLevel.FAT;
        }));

        /**
         * 6.3.1 그룹화된 요소 조작
         */
        // 500 칼로리 이상 필터 후 그룹핑
        Map<Integer, List<Dish>> caloricDishesByType1 = menu.stream().filter(dish -> dish.getCalories() >= 500)
                .collect(groupingBy(Dish::getCalories));

        Map<Integer, List<Dish>> caloricDishesByType2 = menu.stream().collect(groupingBy(Dish::getCalories,
                Collectors.filtering(dish -> dish.getCalories() > 500, Collectors.toList())));

        System.out.println("caloricDishesByType1 = " + caloricDishesByType1);
        System.out.println("caloricDishesByType2 = " + caloricDishesByType2);

        /**
         * 6.3.2 다수준 그룹화
         */
        Map<Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream().collect(
                groupingBy(Dish::getType,       // 첫번째 수준의 분류함수
                        groupingBy(dish -> {    // 두번째 수준의 분류함수
                            if (dish.getCalories() <= 400)
                                return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else return CaloricLevel.FAT;
                        })));
        System.out.println("dishesByTypeCaloricLevel = " + dishesByTypeCaloricLevel);

        /**
         * 6.3.3 서브그룹으로 데이터 수집
         */
        Map<Type, Long> typesCount = menu.stream().collect(groupingBy(Dish::getType, counting()));
        System.out.println("typesCount = " + typesCount);

        Map<Type, Optional<Dish>> mostCaloricByType = menu.stream().collect(
                groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));
        System.out.println("mostCaloricByType = " + mostCaloricByType);

        // Optional 삭제
        Map<Type, Dish> mostCaloricByTypeNotOptional = menu.stream().collect(groupingBy(Dish::getType,
                collectingAndThen(maxBy(comparingInt(Dish::getCalories)),
                        Optional::get)));
        System.out.println("mostCaloricByTypeNotOptional = " + mostCaloricByTypeNotOptional);

    }
}
