package com.workspace.demo.ds.string;

import java.util.HashMap;
import java.util.Map;

public class CheckAnagrams {

    private static boolean isAnagram(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < word1.length(); i++) {
            Character c = word1.charAt(i);
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }
        for (int i = 0; i < word2.length(); i++) {
            Character c = word2.charAt(i);
            if (!map.containsKey(c) || map.get(c) == 0)
                return false;
            else map.put(c, map.get(c) - 1);
        }

        for (int v : map.values()) {
            if (v > 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String word1 = "flower", word2 = "flower";
        boolean result = isAnagram(word1, word2);
        System.out.println("result = " + result);
    }
}
