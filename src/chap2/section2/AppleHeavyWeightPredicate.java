package chap2.section2;

import chap2.example.Apple;

public class AppleHeavyWeightPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150; // 무거운 사과인지 판별
    }
}
