package chap2.section1;

import chap2.example.Apple;

public class AppleFancyFormatter implements AppleFormatter{
    @Override
    public int weight(Apple apple) {
        return apple.getWeight();
    }
}
