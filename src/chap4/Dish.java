package chap4;


public class Dish {

    private final int calories;
    private final String name;
    private final boolean vegetarian;
    private final Type type;

    public int getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public Type getType() {
        return type;
    }


    public Dish(int calories, String name, boolean vegetarian, Type type) {
        this.calories = calories;
        this.name = name;
        this.vegetarian = vegetarian;
        this.type = type;
    }
}
