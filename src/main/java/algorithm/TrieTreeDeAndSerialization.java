package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TrieTreeDeAndSerialization {
    public static void main(String... args) {
        TrieNode root = prepareTrieNode();
        System.out.println(root);
    }

    private static TrieNode prepareTrieNode() {
        String[] words = { "abandon", "absorb", "absurd", "abuse"};
        TrieNode root = new TrieNode();
        TrieNode cur = null;
        for (String word : words) {
            cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode();
                else cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }
        return root;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;
    String value;
    public TrieNode() {
    }

    public TrieNode(String theValue) {
        this.value = theValue;
    }

    @Override
    public String toString() {
        List<String> resultList = new ArrayList<>();
        for (TrieNode child : children) {
            if (child == null) resultList.add("#");
            else resultList.add(child.toString());
        }
        return resultList.stream().collect(Collectors.joining(","));
    }

    public TrieNode fromString(String s) {
        List<String> list = new ArrayList<>(Arrays.asList(s.split(",")));
        return fromList(list, Arrays.asList(0, 0));
    }


    /**
     * parse the fixed-sized tree from a list;
     * @param list
     * @param indexes used to track the start index (list.get(0)) and the nodes consumed (list.get(1));
     * @return
     */
    private TrieNode fromList(List<String> list, List<Integer> indexes) {
        TrieNode root = new TrieNode(list.get(indexes.get(0))); // parse the root;
        int i = indexes.get(0) + 1; // start to parse its children recursively;
        while (i < list.size()) {
            // it's null;
            if (list.get(i).equals("#")) {
                indexes.set(1, indexes.get(1)); // consume one node;
                root.children[i - indexes.get(0) - 1] = null;
            }
            else { // parse the not null child recursively;
                root.children[i - indexes.get(0) - 1] = fromList(list, indexes);
                indexes.set(1, indexes.get(1) + root.children.length);
            }
        }
        return root;
    }
}
