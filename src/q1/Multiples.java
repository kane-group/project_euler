package q1;

import java.util.stream.IntStream;

public class Multiples {
    public static void main(String[] args) {
        System.out.println(IntStream.rangeClosed(0, 1000).filter(i -> i % 3 == 0 || i % 5 == 0).sum());
    }
}