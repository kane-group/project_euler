package q2;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class EvenFibonacci3 {
    private static Map<Integer, BigInteger> memo = new HashMap<>();
    public static void main(String[] args) {
        long sum = Stream.iterate(BigInteger.ONE, b -> b.add(BigInteger.ONE))
                .limit(100l)
                .map(b -> fibo(b.intValue()))
                .filter(i -> i.compareTo(BigInteger.valueOf((long) 4000000)) < 0)
                .mapToLong(b -> b.longValue())
                .sum();
        System.out.println("結果:" + sum);
    }

    static BigInteger fibo(int i) {
        System.out.println("fibo:" + i);
        return memo.computeIfAbsent(
                i, n -> n == 1 ? BigInteger.valueOf(1) :
                        n == 2 ? BigInteger.valueOf(2) :
                                 fibo(n - 2).add(fibo(n - 1)));
    }
}