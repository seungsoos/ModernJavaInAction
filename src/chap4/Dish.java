package chap4;

import lombok.Data;

@Data
public class Dish {

    private final int calories;
    private final String name;
    private final boolean vegetarian;
    private final Type type;
}
