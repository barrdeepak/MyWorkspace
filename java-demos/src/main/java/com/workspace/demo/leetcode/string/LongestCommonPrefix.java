package com.workspace.demo.leetcode.string;

//LC 14
public class LongestCommonPrefix {

    private static String getCommonPrefix(String[] input) {
        StringBuilder sb = new StringBuilder();
        char[] first = input[0].toCharArray();
        int firstWordLength = first.length;

        for (int i = 0; i < firstWordLength; i++) {
            char c = first[i];
            int k = 1;
            for (; k < input.length; k++) {
                if (i>=input[k].length() || input[k].charAt(i) != c)
                    break;
            }
            if (k == input.length)
                sb.append(c);
            else break;
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String a = "deepak";
        System.out.println("a.substring(0, 1) = " + a.substring(0, 1));
        System.out.println("a.substring(0, 1) = " + a.substring(1, a.length()));


        String[] input = new String[]{"aflower", "aflo", "afloor"};
        String commonPrefix = getCommonPrefix(input);
        System.out.println("commonPrefix = " + commonPrefix);
    }
}


