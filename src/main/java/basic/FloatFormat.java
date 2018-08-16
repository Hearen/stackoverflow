package basic;

import java.util.Scanner;

public class FloatFormat {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Radius: ");
        int r = scanner.nextInt();
        double p = 2 * r * Math.PI; // use double for higher accuracy;
        double s = r * r * Math.PI; // use Math.PI for the same reason;
        System.out.println(String.format("Perimeter: %.2f \nSpace: %.2f",  p, s));
    }
}
