package q3;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class PrimeFactor {
    public static List<Long> getPrimeFactorizationList(long n) {
        int sqrt = (int)Math.sqrt(Double.valueOf(String.valueOf(n)));
        List<Long> searchList = LongStream.rangeClosed(2, sqrt)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));
        List<Long> result = new LinkedList<>();
        while (true) {
            long firstElement = searchList.get(0);
            if (firstElement > Math.sqrt(sqrt)) {
                break;
            }
            result.add(firstElement);
            searchList.removeIf(i -> i % firstElement == 0);
        }
        result.addAll(searchList);
        return result;
    }

    public static long primeFactorizationMax(long n) {
        return getPrimeFactorizationList(n)
                .stream()
                .filter(i -> n % i == 0)
                .max(Comparator.naturalOrder())
                .orElse(0l);
    }

    public static void main(String[] args) {
        System.out.println(primeFactorizationMax(600851475143l));
    }
}
