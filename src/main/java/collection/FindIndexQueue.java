package collection;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class FindIndexQueue {
    static BlockingQueue<String> queue = new LinkedBlockingDeque<>();
    public static void main(String... args) {
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
        queue.add("5");
        System.out.println(findIndex("1"));
        System.out.println(findIndex("3"));
        System.out.println(findIndex("6"));
    }

    private static int findIndex(String s) {
        int i = 0;
        Iterator<String> iter = queue.iterator();
        while(iter.hasNext()) {
            String ele = iter.next();
            if (ele.equalsIgnoreCase(s)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
