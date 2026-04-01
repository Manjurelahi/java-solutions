import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamLifeTest {
    public static void main(String[] args) {
        List<Integer> listA= Arrays.asList(3,4,5);
        Stream<Integer> numStream = listA.stream().map(x->x*x);
        listA.forEach(System.out::print);
        numStream.forEach(System.out::print);
    }
}

//Output :34591625