package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterAnotherList {
    public static void main(String... args) {
        List<String> aList = new ArrayList<>(Arrays.asList("X", "Y", "Y", "Z"));
        List<String> bList = new ArrayList<>(Arrays.asList("Y", "Z"));
//        List<String> cList = new ArrayList<>(aList);
//        cList.removeAll(bList);
//        List<String> cList = aList.stream().filter(s -> !bList.contains(s)).collect(Collectors.toList());
        List<String> cList = new ArrayList<>(aList);
        for (String s: bList) {
            cList.remove(s);
        }
        System.out.println(cList);
    }

}
