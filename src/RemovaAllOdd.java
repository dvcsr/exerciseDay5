import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemovaAllOdd {
    public static void main(String[] args) {
        List<Integer> numList = Stream.of(1,2,3,4,5,6,7,8,9,10).collect(Collectors.toList());
        System.out.println(numList);

        List<Integer> oddRemoved = numList.stream().filter(e -> (e % 2) == 0).collect(Collectors.toList());
        System.out.println(oddRemoved);
    }
}
