package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;

public class GenericMethod {
    public static void main(String... args) {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(5, 3, 2, 4));
        ArrayList<Double> doubles = new ArrayList<>(Arrays.asList(5.3, 3.5, 2.1, 3.2));
        selection_sort(integers);
        selection_sort(doubles);
        System.out.println(integers);
        System.out.println(doubles);

        Collections.shuffle(integers);
        Collections.shuffle(doubles);
        System.out.println(integers);
        System.out.println(doubles);

        selection_sort_2(integers, Comparator.comparing(Integer::intValue));
        selection_sort_2(doubles, Comparator.comparing(Double::doubleValue));
        System.out.println(integers);
        System.out.println(doubles);
    }

    private static <T extends Comparable<T>> ArrayList<T> selection_sort(ArrayList<T> arr) {
        for (int i = 0; i < arr.size(); i++) {
            int pos = i;
            for (int j = i; j < arr.size(); j++) {
                if (arr.get(j).compareTo(arr.get(pos)) < 0)
                    pos = j;
            }
            T min = arr.get(pos);
            arr.set(pos, arr.get(i));
            arr.set(i, min);
        }
        return arr;
    }

    private static <T extends Comparable<? super T>> ArrayList<T> selection_sort_1(ArrayList<T> arr) {
        for (int i = 0; i < arr.size(); i++) {
            int pos = i;
            for (int j = i; j < arr.size(); j++) {
                if (arr.get(j).compareTo(arr.get(pos)) < 0)
                    pos = j;
            }
            T min = arr.get(pos);
            arr.set(pos, arr.get(i));
            arr.set(i, min);
        }
        return arr;
    }

    private static void selection_sort_2(ArrayList arr, Comparator comparator) {
        for (int i = 0; i < arr.size(); i++) {
            int pos = i;
            for (int j = i; j < arr.size(); j++) {
                if (comparator.compare(arr.get(j), arr.get(pos)) < 0)
                    pos = j;
            }
            Object min = arr.get(pos);
            arr.set(pos, arr.get(i));
            arr.set(i, min);
        }
    }
}
