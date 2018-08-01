package basic;

import java.util.Scanner;

public class FloatSumAvg {
    public static void main(String... args) {
        int N = 5;
        float[] data = new float[N];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0;i < N; ++i) {
            data[i] = Float.parseFloat(scanner.nextLine());
            // data[i] = scanner.nextFloat();
            // would be better;
        }

        float sum = 0.0f;
        float avg = 0.0f;
        for (float grade : data) {
            sum += grade;
            avg = sum / data.length;
        }
        // avg = sum / data.length;
        // would be better;
        System.out.println("sum: " + sum + " \navg: " + avg);
    }
}
