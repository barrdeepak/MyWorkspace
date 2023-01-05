package com.workspace.demo.tries;

public class TrieNode {
    TrieNode[] children;
    boolean endOfWord;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.endOfWord = false;
    }

}
