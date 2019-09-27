package com.makun.data_struct.trie.mine;

/**
 * @author Created by makun
 * @Date 2019-09-26
 */
public class Main {
    public static void main(String[] args) {
        MyTrie tree = new MyTrie();
        tree.insert("great");
        tree.insert("good");
        System.out.println(tree.search("great"));
        System.out.println(tree.search("marvelous"));
    }
}
