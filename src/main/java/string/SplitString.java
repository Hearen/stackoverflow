package string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javafx.util.Pair;

public class SplitString {
    public static void main(String... args) {
        String[] myArr = {"Bob    Marley", "Barbara    Newton", "John    Smith"};
        splitArray(myArr);
        splitArrayUsingStream(myArr);
    }

    private static void splitArray(String[] arr) {
        int len = arr.length;
        String[] firstNames = new String[len];
        String[] lastNames = new String[len];
        for (int i = 0; i < len; ++i) {
            String[] names = arr[i].split("\\s+");
            firstNames[i] = names[0];
            lastNames[i] = names[1];
        }
        System.out.println(Arrays.deepToString(firstNames));
        System.out.println(Arrays.deepToString(lastNames));
    }

    private static void splitArrayUsingStream(String[] arr) {
        Pair[] pairs = Arrays.stream(arr).map(s -> {
            String[] names = s.split("\\s+");
            return new Pair<>(names[0], names[1]);
        }).collect(Collectors.toList()).toArray(new Pair[arr.length]);
        System.out.println(Arrays.deepToString(pairs));
    }
}
