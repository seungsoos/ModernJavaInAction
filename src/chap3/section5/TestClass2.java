package chap3.section5;

import chap2.example.Apple;

import java.util.Comparator;

public class TestClass2 {


    // 형식을 추론하지않았음.
    Comparator<Apple> c1 = (Apple a1, Apple a2) -> {
        Integer overrideA1 = a1.getWeight();
        Integer overrideA2 = a2.getWeight();

       return overrideA1.compareTo(overrideA2);
    };

    //형식을 추론
    Comparator<Apple> c2 = (a1, a2) -> {
        Integer overrideA1 = a1.getWeight();
        Integer overrideA2 = a2.getWeight();

        return overrideA1.compareTo(overrideA2);
    };

    public static void main(String[] args) {

        int portNumber = 1337;
        Runnable r = () -> System.out.println(portNumber); // 에러발생
//        portNumber = 1111;
        r.run();
    }


}
