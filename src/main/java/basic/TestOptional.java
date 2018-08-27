package basic;

import java.util.Optional;

import others.Test;

public class TestOptional {
    public static void main(String... args) {
        Optional<String> val = Optional.ofNullable("Hello");
        String s = val.orElse(test());
        System.out.println(s);
        s = val.orElseGet(() -> test());
        System.out.println(s);
    }

    public static String test() {
        System.out.println("Hello world");
        return "hi";
    }
}
