package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import util.RandomGenerator;

public class SortByFrequency {
    public static void main(String[] args) {
        int N = 10_000 + new Random().nextInt(100);
        Long start;
        List<Long> list0 = new ArrayList<>();
        List<Long> list1 = new ArrayList<>();
        for (int i = 0; i < 100; ++i) {
            int[] arr = RandomGenerator.generateArrays(N, N, N / 10, N / 5, false);

            start = System.nanoTime();
            int[] arr0 = sortByCounting(arr);
            list0.add(System.nanoTime() - start);

            start = System.nanoTime();
            int[] arr1 = sortByPlainCounting(arr);
            list1.add(System.nanoTime() - start);

            System.out.println("Sorted by frequency: " + isFrequencyEqual(arr0, arr1));
        }
        System.out.println("Collection time cost: " + list0.stream().collect(Collectors.summarizingLong(Long::valueOf)));
        System.out.println("Custom   time   cost: " + list1.stream().collect(Collectors.summarizingLong(Long::valueOf)));
    }


    private static boolean isFrequencyEqual(int[] arr0, int[] arr1) {
        Map<Integer, Long> countMap0 = getCountMap(arr0);
        Map<Integer, Long> countMap1 = getCountMap(arr1);
        boolean isEqual = countMap0.entrySet().size() == countMap1.entrySet().size();
        if (!isEqual) return false;
        isEqual = countMap0.values().containsAll(countMap1.values()) &&
                countMap1.values().containsAll(countMap0.values());
        if (!isEqual) return false;
        List<Long> countList0 = countMap0.values().stream().collect(Collectors.toList());
        List<Long> countList1 = countMap1.values().stream().collect(Collectors.toList());
        for (int i = 0; i < countList0.size(); i++) {
            if (countList1.get(i) != countList0.get(i)) return false;
        }
        return true;
    }

    private static Map<Integer, Long> getCountMap(int[] arr) {
        return Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldV, newV) -> oldV, LinkedHashMap::new));
    }


    /**
     * works only when the frequency is different among the elements;
     *
     * @param arr
     * @return
     */
    private static int[] sortByStream(int[] arr) {
        Map<Integer, Long> freqMap = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
        return Arrays.stream(arr).boxed()
                .sorted(Comparator.comparing(a -> freqMap.get(a).intValue()).reversed())
                .mapToInt(Integer::intValue)
                .toArray();
    }

    /**
     * 1. count the frequency and sort the entry based on the frequency while using LinkedHashMap to retain the order;
     * 2. fill up the new array based on the frequency while traversing the LinkedHashMap;
     *
     * @param arr
     * @return
     */
    private static int[] sortByCounting(int[] arr) {
        Map<Integer, Long> countMap = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldV, newV) -> oldV, LinkedHashMap::new));
        int[] newArr = new int[arr.length];
        int i = 0;
        for (Map.Entry<Integer, Long> entry : countMap.entrySet()) {
            Arrays.fill(newArr, i, i += entry.getValue().intValue(), entry.getKey());
        }
        return newArr;
    }


    private static int[] sortByPlainCounting(int[] arr) {
        if (arr.length < 1) throw new IllegalArgumentException("Array cannot be empty");
        MyPair[] pairs = prepareMyPairs(arr);
        Arrays.sort(pairs, Comparator.comparing(MyPair::getCount).reversed());
        int[] newArr = new int[arr.length];
        int i = 0;
        for (MyPair pair : pairs) {
            Arrays.fill(newArr, i, i += pair.count, pair.key);
        }
        return newArr;
    }

    static MyPair[] prepareMyPairs(int[] arr) {
        Integer[] tmpArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(tmpArr, Comparator.reverseOrder());
        int count = 1;
        int prev = tmpArr[0];
        for (int i = 1; i < tmpArr.length; i++) {
            if (tmpArr[i] != prev) {
                prev = tmpArr[i];
                count++;
            }
        }
        MyPair[] pairs = new MyPair[count];
        int k = 0;
        for (int i = 0; i < tmpArr.length; i++) {
            if (pairs[k] == null) {
                pairs[k] = new MyPair(tmpArr[i]);
            } else {
                if (pairs[k].key == tmpArr[i]) {
                    pairs[k].inc();
                } else {
                    k++;
                    i--;
                }
            }
        }
        return pairs;
    }

    static class MyPair {
        int key;
        int count;

        public MyPair(int theKey) {
            this.key = theKey;
            this.count = 1;
        }

        public void inc() {
            this.count++;
        }

        public int getCount() {
            return this.count;
        }
    }
}
