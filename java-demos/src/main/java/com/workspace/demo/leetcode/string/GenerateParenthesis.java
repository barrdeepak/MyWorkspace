package com.workspace.demo.leetcode.string;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// LC 22
public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {

        Set<String> result = new HashSet<>();
        if (n == 1)
            result.add("()");
        else {
                List<String> list = generateParenthesis(n-1);
                for(String s:list)
                {
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) == '(') {
                            StringBuilder sb = new StringBuilder();
                            sb.append(s.substring(0, i+1));
                            sb.append("()");
                            sb.append(s.substring(i+1));
                            result.add(sb.toString());
                        }
                        result.add(s +"()");
                    }
                }
            }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        List<String> permutations = generateParenthesis(3);
        System.out.println("permutations = " + permutations);
    }
}
