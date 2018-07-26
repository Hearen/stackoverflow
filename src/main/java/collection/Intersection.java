package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection {
    public static void main(String... args) {
        List<Integer> primes = new ArrayList<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37));
        List<Integer> fibos = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34));
        List<Integer> ret = new ArrayList<>(primes);
        ret.retainAll(fibos);
        System.out.println(ret);
        fibo(40);
    }

    static void fibo(int n) {
        List <Integer> fibos = new ArrayList<>(n);
        fibos.add(0);
        fibos.add(1);
        System.out.print(fibos.get(0) + "," + fibos.get(1));
        for (int i = 2; i <= n; i++) {
            int a = fibos.get(i-1) + fibos.get(i-2);
            if (a <= n) {
                fibos.add(a);
                System.out.print("," + a);
            } else break;
        }
    }

}
