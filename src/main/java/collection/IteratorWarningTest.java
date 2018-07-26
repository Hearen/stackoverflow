package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorWarningTest {
    public static void main(String... args) {
        int N = 5;
        List list = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            list.add(i);
        }
        for (Iterator<Integer> iter = list.iterator(); iter.hasNext(); ) {
            System.out.println(iter.next());
        }
    }
}
