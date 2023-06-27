package chap2.example;

import chap2.section1.Apple;

public class AppleFancyFormatter implements AppleFormatter{
    @Override
    public int weight(Apple apple) {
        return apple.getWeight();
    }
}
