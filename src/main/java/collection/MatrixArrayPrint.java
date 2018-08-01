package collection;

import java.util.Arrays;
import java.util.Random;

public class MatrixArrayPrint {
    public static void main(String... args) {
        int[][] arrs = randomArray(9);
        for (int[] arr : arrs) {
            System.out.println(Arrays.toString(arr));
        }
    }
    private static int[][] randomArray (int n) {
        int[][] randomMatrix = new int[n][n];

        Random random = new Random();
        for (int rows = 0; rows < n; rows++) {
            for (int columns = 0; columns < n; columns++) {
                Integer r = random.nextInt() % 100;
                randomMatrix[rows][columns] = Math.abs(r);
            }
        }
        return randomMatrix;
    }
}
