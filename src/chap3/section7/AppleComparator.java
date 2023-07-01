package chap3.section7;

import chap2.example.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.*;

/**
 * 람다, 메서드 참조 활용하기
 */
public class AppleComparator implements Comparator<Apple>{
    /**
     * 3.7.1 1단계 : 코드 전달
     */
    @Override
    public int compare(Apple o1, Apple o2) {
        return ((Integer) o1.getWeight()).compareTo((Integer) o2.getWeight());
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();

        inventory.sort(new AppleComparator());

        /**
         * 3.7.2 2단계 : 익명 클래스 사용
         */
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return ((Integer) o1.getWeight()).compareTo((Integer) o2.getWeight());
            }
        });
        /**
         * 3.7.3 3단계 : 함다 표현식 사용
         */
        inventory.sort((Apple o1, Apple o2) -> {
            return ((Integer) o1.getWeight()).compareTo((Integer) o2.getWeight());
        });
        /**
         * 파라미터 추론방식
         */
        inventory.sort((o1, o2) -> {
            return ((Integer) o1.getWeight()).compareTo((Integer) o2.getWeight());
        });
        /**
         * 3.7.4 4단계 : 메서드 참조 사용
         */
        inventory.sort(comparing(Apple::getWeight));

    }


}

class TestClass{


    public static void main(String[] args) {

    }
}

