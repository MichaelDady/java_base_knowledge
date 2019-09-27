package com.makun.data_struct.trie.mine;

/**
 * @author Created by makun
 * @Date 2019-09-26
 */
class MyTrie {
    private MyTrieNode root = new MyTrieNode();

    void insert(String word) {
        MyTrieNode tmp = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (!tmp.children.containsKey(c)) {
                tmp.children.put(c, new MyTrieNode());
            }
            tmp = tmp.children.get(c);
        }
        tmp.wordEnd = true;
    }

    boolean search(String word) {
        MyTrieNode tmp = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            Character c = word.charAt(i);
            if (!tmp.children.containsKey(c)) {
                return false;
            }
            tmp = tmp.children.get(c);
        }
        return tmp.wordEnd;
    }
}
