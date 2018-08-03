package basic;

public class PrintVShape {
    public static void main(String[] args) {
        int N = 8;
        printV(N);
    }

    private static void printV(int N) {
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < i; ++k) {
                System.out.print("x");
            }
            System.out.print("V");
            for (int j = 0; j < (N - i - 1) * 2; ++j) {
                System.out.print("p");
            }
            System.out.print("V");
            for (int k = 0; k < i; ++k) {
                System.out.print("x");
            }
            System.out.print("\n");
        }
    }
}
