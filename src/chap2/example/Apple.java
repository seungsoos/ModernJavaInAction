package chap2.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Apple  extends Fruit{

    private int weight;
    private Color color;


    public Apple() {

    }

    public Apple(Integer integer) {
        System.out.println("Integer = " + integer);
    }

    public Apple(Color color, Integer integer) {
    }
}
