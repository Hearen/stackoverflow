package collection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TreeMapComparator {
    public static void main(String... args) {
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("hi", 1);
        treeMap.put("there", 3);
        treeMap.put("hey", 2);
        treeMap = treeMap.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldV, newV) -> oldV, LinkedHashMap::new));
        System.out.println(treeMap);
    }
}
