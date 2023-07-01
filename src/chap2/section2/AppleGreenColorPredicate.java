package chap2.section2;

import chap2.example.Apple;
import chap2.example.Color;

public class AppleGreenColorPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return Color.GREEN.equals(apple.getColor()); //녹색 사과인지 판별
    }
}
