package time;

public class HelloWorld {
    public static void main(String... args) {
        System.out.println("Hello world");

        long b = System.currentTimeMillis();
        long a = b + 2400;

        System.out.println((long) Math.round((a - b) / 1000.0) * 1000);
        a = b + 2600;
        System.out.println((long) Math.round((a - b) / 1000.0) * 1000);
    }
}
