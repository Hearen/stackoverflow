package basic;

public class AssertListLength {
    public static void main(String... args) {
    String[] arr = new String[3];
    if (arr.length != 4) {
        throw new IllegalStateException("Array length is not expected");
    }
    }
}
