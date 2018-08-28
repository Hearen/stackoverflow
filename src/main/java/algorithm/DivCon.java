package algorithm;

import java.util.Arrays;

import util.RandomGenerator;

public class DivCon {
    public static void main(String... args) {
        int[] arr = RandomGenerator.generateArrays(100, 1000, 0, 10000, true);
        int minIndex = dC(arr, 1, arr.length - 1);
        int theMin = arr[minIndex];
        Arrays.sort(arr);
        System.out.println(String.format("The min located correctly: %s", arr[0] == theMin));
    }

    private static int dC(int[] a, int l, int r) {
        if (r - l < 1) return l;
        int mid = l + (r - l) / 2;
        int lIndex = dC(a, l + 1, mid);
        int rIndex = dC(a, mid + 1, r);
        int theMinIndex = l;
        if (a[lIndex] < a[theMinIndex]) theMinIndex = lIndex;
        if (a[rIndex] < a[theMinIndex]) theMinIndex = rIndex;
        return theMinIndex;
    }
}
