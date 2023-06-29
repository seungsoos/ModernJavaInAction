package chap3.section3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ExampleConsumer {

    public void test(){

        forEach(Arrays.asList(1,2,3,4,5),
                (Integer i) -> System.out.println(i));
    }

    public <T> void forEach(List<T> list, Consumer<T> c){

        for (T t : list) {
            c.accept(t);
        }
    }



}
