package com.workspace.demo.tries;

public class Main {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.addString("deepak");
        trie.addString("deeper");
        trie.addString("google");
        trie.addString("googlecloud");
        trie.addString("googler");
        trie.addString("cloudconsultant");
        trie.addString("cloudengineer");

        boolean wordExists = trie.search("deep");
        System.out.println("wordExists = " + wordExists);

        wordExists = trie.search("google");
        System.out.println("wordExists = " + wordExists);

        wordExists = trie.search("cloud");
        System.out.println("wordExists = " + wordExists);

        wordExists = trie.search("cloudconsultant");
        System.out.println("wordExists = " + wordExists);

        boolean prefixExists = trie.searchPrefix("deep");
        System.out.println("prefixExists = " + prefixExists);

        prefixExists = trie.searchPrefix("googl");
        System.out.println("prefixExists = " + prefixExists);

        prefixExists = trie.searchPrefix("googlecloud");
        System.out.println("prefixExists = " + prefixExists);

        prefixExists = trie.searchPrefix("cloudconsultant");
        System.out.println("prefixExists = " + prefixExists);
    }
}
