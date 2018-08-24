package stream.io.test;

public class Test {
    public static void main(String... args) {
        String packageName = Test.class.getPackage().getName();
        String basePackageName = packageName.substring(0, packageName.lastIndexOf("."));
        System.out.println(Test.class.getCanonicalName());
        System.out.println(basePackageName);
    }
}
