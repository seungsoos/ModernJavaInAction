package chap4.section3;

import chap4.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestClass {

    public static void main(String[] args) {
        /**
         * 4.3.1 딱 한 번만 탐색 할 수 있다.
         */
        List<String> title = Arrays.asList("Java", "In", "Action");

        Stream<String> s = title.stream();
        s.forEach(System.out::println);
//        s.forEach(System.out::println); // IllegalStateException: stream has already been operated upon or closed

        /**
         * 4.3.2 외부 반복과 내부 반복
         */
        // 컬렉션 for-each루프를 이용하는 외부 반복
        List<Dish> menu1 = new ArrayList<>();
        List<String> names1 = new ArrayList<>();
        for (Dish dish : menu1) {
            names1.add(dish.getName());
        }
        // 컬렉션 내부적으로 숨겨졌던 반복자를 사용한 외부 반복
        List<String> menu2 = new ArrayList<>();
        List<String> names2 = new ArrayList<>();
        Iterator<String> iterator = menu2.iterator();

        while (iterator.hasNext()) {
            String dish = iterator.next();
            names2.add(dish);
        }
        // 스트림 내부반복
        List<Dish> menu3 = new ArrayList<>();
        List<String> names3 = menu3.stream()
                    .map(Dish::getName).collect(Collectors.toList());


    }
}
