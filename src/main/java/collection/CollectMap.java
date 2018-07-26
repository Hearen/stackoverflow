package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectMap {
    public static void main(String... args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            list.add(String.valueOf(i));
        }
        list.addAll(list);
        Map<String, String> sMap = list.stream().collect(Collectors.toMap(s -> s, s -> s+s));
        Map<String, String> sMap1 = list.stream().collect(Collectors.toMap(s -> s, s -> s+s, (oldKey, newKey) -> oldKey));
        System.out.println(sMap);
    }
}
