import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class StreamWellBehaved {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>(Arrays.asList("one", "two"));
        Stream<String> sl = l.stream();
        l.add("three");
        System.out.println(sl.collect(joining(" ")));
    }
}

// Output :one two three