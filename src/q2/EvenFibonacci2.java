package q2;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class EvenFibonacci2 {
    private static Map<Integer, BigInteger> memo = new HashMap<>();
    public static void main(String[] args) {
        Optional<BigInteger> sum = Stream.iterate(1, i -> i + 1)
                .map(i -> fibo(i))
                .filter(i -> i.compareTo(BigInteger.valueOf((long) 4000000)) < 0)
                .reduce((i, total) -> total.add(i));
        System.out.println("結果:" + sum.orElse(BigInteger.ZERO));
    }

    static BigInteger fibo(int i) {
        System.out.println(i);
        return memo.computeIfAbsent(
                i, n -> n <= 1 ? BigInteger.valueOf(1) :
                        n == 2 ? BigInteger.valueOf(2) :
                                 fibo(n - 2).add(fibo(n - 1)));
    }
}