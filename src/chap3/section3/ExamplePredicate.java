package chap3.section3;

import chap2.section3.Predicate;

import java.util.ArrayList;
import java.util.List;

public class ExamplePredicate {

    List<String> listOfStrings = new ArrayList<>();

    public <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> results = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                results.add(t);
            }
        }
        return results;
    }

    Predicate<String> nonEmpryStringPredicate = (String s) -> !s.isEmpty();

    List<String> nonEmpty = filter(listOfStrings, nonEmpryStringPredicate);
}
