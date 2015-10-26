package Q5;

import java.util.stream.LongStream;


public class MinimumMultiple {
    // 引数の数値の倍数を一つずつ確認していく方法
    public static long minimumMultiple(long n) {
        for(int i = 1; i < Integer.MAX_VALUE; i++) {
            long divided = i * n;
            for(long j = n; j > 0; j--) {
                if (divided % j != 0) {
                    break;
                }

                if(j == 2) {
                    return divided;
                }
            }
        }
        return 0;
    }

    /**
     前の数値の計算結果の値と次の値の最小公倍数を繰り返し求めていく方法
     2 -> 2,
     3 -> 2と3の最小公倍数である6,
     4 -> 6と4の最小公倍数である12のような感じ
     */
    public static long minimumMultiple2(long n) {
        return LongStream.rangeClosed(2, n).reduce(2, (a, b) -> lcm(a, b));
    }

    private static long lcm(long x, long y) {
        return x * y / gcd(x, y);
    }

    private static long gcd(long x, long y) {
        return x == 0l ? y : gcd(y % x, x);
    }


    public static void main(String[] args) {
        System.out.println("answer=" + minimumMultiple(20));
        System.out.println("answer=" + minimumMultiple2((long)20));
    }
}