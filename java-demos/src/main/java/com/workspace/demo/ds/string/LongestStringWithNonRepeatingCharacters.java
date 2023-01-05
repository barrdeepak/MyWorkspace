package com.workspace.demo.ds.string;

import java.util.HashSet;
import java.util.Set;

/*
LC 3. Longest Substring Without Repeating Characters
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
 */
public class LongestStringWithNonRepeatingCharacters {

    public static String lengthOfLongestSubstring(String s) {

        String result = null;
        Set<Character> seen = new HashSet<>();
        int length = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!seen.contains(s.charAt(i))) {
                length = Integer.max(length, i - start + 1);
                seen.add(s.charAt(i));
                result = s.substring(start, i+1);
            } else {
                while (s.charAt(start) != s.charAt(i)) {
                    seen.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "abcbacdbb";

        String length = LongestStringWithNonRepeatingCharacters.lengthOfLongestSubstring(input);
        System.out.println("length = " + length);
    }
}
