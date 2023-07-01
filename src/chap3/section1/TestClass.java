package chap3.section1;

import chap2.example.Apple;

import java.util.Comparator;

public class TestClass {

    public static void main(String[] args) {

        // 기존코드
        Comparator<Apple> byWeight1 = new Comparator<Apple>() {
            public int compare(Apple o1, Apple o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        };

        // 람다를 이용한 코드
        Comparator<Apple> byWeight2 =
                (Apple o1, Apple o2) -> Integer.compare(o1.getWeight(), o2.getWeight());


    }

}
