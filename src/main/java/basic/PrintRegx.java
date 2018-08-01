package basic;

public class PrintRegx {
    public static void main(String... args) {
        final int i=123;
        byte b=i;
        test1();
        test2();
    }

    private static void test1() {
        String str1 = new String("ja1") + new String("va");
        str1.intern();
        String str2 = "ja1va";
        System.out.println("Result:" + (str1 == str2));
    }

    private static void test2() {
        String str1 = new String("ja") + new String("va");
        str1.intern();
        String str2 = "java";
        System.out.println("Result:" + (str1 == str2));
    }
}
