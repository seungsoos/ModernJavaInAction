package chap6;

import chap4.Type;
import lombok.Data;

@Data
public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

}


