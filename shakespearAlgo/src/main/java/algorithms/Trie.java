package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    TrieNode root = new TrieNode();

    List<Pair> stringsFound = new ArrayList();

    // Used while dev to see what keys failed
    List<String> errors = new ArrayList();

    String[] shakespear;

    public Trie(String[] ss) {
        this.shakespear = ss;

        for (int i = 0; i < this.shakespear.length; i++) {
            insert(this.shakespear[i]);
        }

        findAll(root);

        // for (Pair pair : stringsFound) {
        // System.out.println(pair);

        // }

    }

    public void insert(String key) {

        // Try catch to see if a key failed, what the given key was
        try {

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
                } else {
                    node = node.children[idx];
                }
            }
            // Setup wordTrue and count+1
            node.setIsWord(true);
            int count = node.getCount();
            node.setCount(count + 1);
            node.setWord(key);

        } catch (Exception e) {
            // Adds to a list of keys that went wrong
            errors.add(key);
        }
    }

    public void findAll(TrieNode node) {

        if (node.isWord) {
            stringsFound.add(new Pair(node.getCount(), node.word));
        }

        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] != null) {
                findAll(node.children[i]);
            }

        }

    }

    public TrieNode getRoot() {
        return root;
    }

    public List<Pair> getStringsFound() {
        return stringsFound;
    }

    public List<String> getErrors() {
        return errors;
    }

    private class TrieNode {

        public TrieNode() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;

            }
        }

        private int sizeOfAlphabet = 27;

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

        public boolean isIsWord() {
            return isWord;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public String getWord() {
            return word;
        }

    }

    public class Pair {

        private int count;
        private String name;

        public Pair(int count, String name) {
            this.count = count;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Name = " + name + " Count: " + count;
        }

    }
}
