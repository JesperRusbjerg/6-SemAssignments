package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    TrieNode root = new TrieNode();
    //Used to show time complexity of an insert
    Integer insertCounter = 0;
    Integer size = 0;
    public static int sizeOfAlphabet = 27;
    //Used to show this algorithm is N time sorting
    // It inserts a word, and it is automaticly sorted
    Integer timeUnits = 0;

    public Trie() {
    }

    public TrieNode CreateTrie(String[] ss){
        for (int i = 0; i < ss.length; i++) {
            insert(ss[i]);
        }

        return getRoot();
    }

    public void printTrieInOrder(){
        List<Pair> pairs = findAll(getRoot(), null);
        for(Pair p: pairs){
            System.out.println(p);
        }

    }


    private void insert(String key) {
        //Used to show this algorithm is N time sorting
        // It inserts a word, and it is automaticly sorted
            timeUnits++;
            TrieNode node = root;

            char[] keyChars = key.toLowerCase().toCharArray();

            for (int i = 0; i < key.length(); i++) {
                int idx = keyChars[i] - 'a';
                if (keyChars[i] == '\'') {
                    idx = 26;
                }

                // Checks if the idx of a given char is null
                // If it is null we make a new trieNode for that given char/index
                if (node.children[idx] == null) {
                    TrieNode newNode = new TrieNode();
                    node.children[idx] = newNode;
                    node = newNode;
                    //Used to show time complexity of an insert
                    this.insertCounter++;
                } else {
                    node = node.children[idx];
                }
            }
            // Setup wordTrue and count+1
            node.setIsWord(true);
            int count = node.getCount();
            node.setCount(count + 1);
            node.setWord(key);
    }

    public int getSpace(){
        findAll(getRoot(), null);
        return getSize()*sizeOfAlphabet;
    }

    private List<Pair> findAll(TrieNode node, List<Pair> pairs) {
        if(pairs == null){
            pairs = new ArrayList();
        }

        if (node.isWord) {
            pairs.add(new Pair(node.getCount(), node.word));
        }

        for (int i = 0; i < node.children.length-1; i++) {
            if (node.children[i] != null) {
                size++;
                findAll(node.children[i], pairs);
            }

        }
        return pairs;
    }

    public Pair search(String word) {
        TrieNode node = getRoot();
         word = word.toLowerCase();

        for (int i = 0; i < word.length(); i++) {
            insertCounter++;
            int idx = word.charAt(i) - 'a';
            if (word.charAt(i) == '\'') {
                idx = 26;
            }
            if (node.children[idx] != null) {
                node = node.children[idx];
                if (node.isWord) {
                    return (new Pair(node.getCount(), node.word));
                }
            }else{
                break;
            }
        }
        return null;
    }


    public Integer getInsertCounter() {
        return insertCounter;
    }

    public void setInsertCounter(Integer insertCounter) {
        this.insertCounter = insertCounter;
    }

    private TrieNode getRoot() {
        return root;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getTimeUnits() {
        return timeUnits;
    }

    private class TrieNode {

        public TrieNode() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;

            }
        }

       private int sizeOfAlphabet = Trie.sizeOfAlphabet;

        private int count = 0;
        private boolean isWord = false;
        private TrieNode[] children = new TrieNode[sizeOfAlphabet];
        private String word;

        public void setCount(int count) {
            this.count = count;
        }

        public void setIsWord(boolean isWord) {
            this.isWord = isWord;
        }

        public int getCount() {
            return count;
        }

        public void setWord(String word) {
            this.word = word;
        }

    }

    public class Pair {

        private int count;
        private String name;

        public Pair(int count, String name) {
            this.count = count;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Name = " + name + " Count: " + count;
        }
    }
}
