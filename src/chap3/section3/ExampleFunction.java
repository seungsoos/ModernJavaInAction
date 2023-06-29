package chap3.section3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ExampleFunction {

    public void test(){

        List<Integer> l = map(
                Arrays.asList("lambdas", "in", "action"),
                (String s) -> s.length());
    }

    public <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();

        for (T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }

}
