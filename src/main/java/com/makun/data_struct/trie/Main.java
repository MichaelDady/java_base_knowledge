package com.makun.data_struct.trie;

/**
 * @author Created by makun
 * @Date 2019-09-26
 */
public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("good");
        trie.insert("marvelous");
        trie.insert("perfect");
        System.out.println(trie.search("good"));
    }
}
