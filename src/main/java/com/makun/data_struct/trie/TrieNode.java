package com.makun.data_struct.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by makun
 * @Date 2019-09-25
 */
public class TrieNode {
    Map<Character, TrieNode> children;
    Boolean wordEnd;

    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
        wordEnd = false;
    }
}
