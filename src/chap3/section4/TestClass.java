package chap3.section4;

import chap2.section3.Predicate;

import java.util.function.IntPredicate;

public class TestClass {

    IntPredicate evenNumbers = (int i) -> i % 2 == 0;

    Predicate<Integer> oddNumbers = (Integer i) -> i % 2 != 0;
    public void test() {
        evenNumbers.test(1000); // true(박싱 없음)

        oddNumbers.test(1000); // false(박싱)
    }
}
