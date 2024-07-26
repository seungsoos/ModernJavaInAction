package chap2.example;


public class Apple  extends Fruit{

    private int weight;
    private Color color;

    public Apple(int weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public Apple() {

    }

    public Apple(Integer integer) {
        System.out.println("Integer = " + integer);
    }

    public Apple(Color color, Integer integer) {
    }

    public int getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }
}