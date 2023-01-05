package com.workspace.demo.ds.string;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap();

        for(String s:strs){
            String sorted = sortString(s);
            if(!map.containsKey(sorted))
                map.put(sorted, new ArrayList());
            map.get(sorted).add(s);
        }
        return new ArrayList(map.values());
    }


    public String sortString(String s){
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);

    }

    public static void main(String[] args) {

    }

}
