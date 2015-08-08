package q2;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class EvenFibonacci {
    private static Map<Integer, BigInteger> memo = new HashMap<>();
    public static void main(String[] args) {
        int c = 1;
        BigInteger sum = BigInteger.ZERO;
        while(true) {
            BigInteger b = fibo(c);
            if(b.compareTo(BigInteger.valueOf((long)4000000)) > 0) {
                break;
            }
            if(b.remainder(BigInteger.valueOf(2)).longValue() == (long)0) {
                sum = sum.add(fibo(c));
            }
            c++;
        }
        System.out.println("結果:" + sum);
    }

    static BigInteger fibo(int i) {
        return memo.computeIfAbsent(i, n -> n == 1 ? BigInteger.valueOf(1) : n == 2 ? BigInteger.valueOf(2) : fibo(n - 2).add(fibo(n - 1)));
    }
}