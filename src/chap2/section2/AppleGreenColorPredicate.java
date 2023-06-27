package chap2.section2;

import chap2.section1.Apple;
import chap2.section1.Color;

public class AppleGreenColorPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return Color.GREEN.equals(apple.getColor()); //녹색 사과인지 판별
    }
}
