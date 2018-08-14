package algorithm;

import java.util.HashMap;
import java.util.Map;

public class TopologicalSort {
    public static void main(String args[]) {
        Map<String, String> idNameMap = new HashMap<>();
        idNameMap.put("002", "Target");
        idNameMap.put("003", "Coles");
        idNameMap.put("150", "Wesfarmers");
        idNameMap.put("001", "Shell");
        idNameMap.put("100", "Max Company X");
        idNameMap.put("250", "Woolworths Group");
        idNameMap.put("201", "Caltex");
        idNameMap.put("202", "Woolworths");

        Map<String, String> managingRelationMap = new HashMap<>();
        managingRelationMap.put("002", "150");
        managingRelationMap.put("003", "150");
        managingRelationMap.put("150", "100");
        managingRelationMap.put("001", "150");
        managingRelationMap.put("250", "100");
        managingRelationMap.put("201", "250");
        managingRelationMap.put("202", "250");

        // start from Max Company X since it's managed by `null`;
        printManagingStructure("100", managingRelationMap, idNameMap, 1);
    }

    private static void printManagingStructure(String managingId, Map<String, String> managingRelationMap,
                                               Map<String, String> idNameMap, int gapCount) {
        System.out.println(String.format("%" + (gapCount * 20) + "s", idNameMap.get(managingId)));
        if (!managingRelationMap.containsValue(managingId)) {
            return;
        }
        managingRelationMap.entrySet().stream().filter(entry -> entry.getValue().equalsIgnoreCase(managingId))
                .forEach(entry -> {
                    printManagingStructure(entry.getKey(), managingRelationMap, idNameMap, gapCount + 1);
                });
    }
}
