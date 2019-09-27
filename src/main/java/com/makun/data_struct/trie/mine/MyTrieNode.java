package com.makun.data_struct.trie.mine;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by makun
 * @Date 2019-09-26
 */
@Data
class MyTrieNode {
    Map<Character, MyTrieNode> children = new HashMap<>();
    boolean wordEnd;
}
