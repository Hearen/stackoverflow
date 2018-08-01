package basic;

import java.util.Scanner;
import java.util.stream.IntStream;

public class DrawBasicRect {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a height of a rectangle:");
        int height = scanner.nextInt();
        System.out.print("Enter a width of a rectangle:");
        int width = scanner.nextInt();
        String theLying = "|" + (new String(new char[width-2])).replace('\0', '-') + "|";
//        StringBuilder stringBuilder = new StringBuilder();
//        IntStream.range(0, height).forEach(i -> stringBuilder.append("\n" + theLying));
//        System.out.println(stringBuilder.toString());
        for (int r = 0; r < height; ++r) {
            System.out.println(theLying);
        }
//        for (int r = 0; r < height; ++r) {
//            System.out.print("|");
//            for (int c = 2; c < width; ++c) {
//                System.out.print("-");
//            }
//            System.out.println("|");
//        }
    }
}
