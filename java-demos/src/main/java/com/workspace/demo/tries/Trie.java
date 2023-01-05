package com.workspace.demo.tries;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    TrieNode root = new TrieNode();

    private TrieNode addChar(TrieNode node, char c) {
        int idx = c - 'a';
        if (node.children[idx] == null)
            node.children[idx] = new TrieNode();
        return node.children[idx];
    }

    public void addString(String s) {
        TrieNode curr = root;
        for (char c : s.toCharArray())
            curr = addChar(curr, c);
        curr.endOfWord = true;
    }

    private TrieNode searchChar(TrieNode curr, char c) {
        int idx = c - 'a';
        return curr.children[idx];
    }

    public boolean search(String s) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            curr = searchChar(curr, c);
            if (curr == null)
                return false;
        }
        return curr.endOfWord;
    }

    public boolean searchPrefix(String s) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            curr = searchChar(curr, c);
            if (curr == null)
                return false;
        }
        return true;
    }

//    public List<String> getAllWords() {
//        List<String> words = new ArrayList<>();
//        getWords(root, words);
//        return words;
//    }
//
//    private void getWords(TrieNode root, List<String> words) {
//        if (root != null){
//
//            for(root!=c)
//
//        }
//    }
}
