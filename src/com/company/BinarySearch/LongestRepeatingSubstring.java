package com.company.BinarySearch;
//Question 1062. Given a string s, find out the length of hte longest repeating substrings.
//有序区间：length of the longest Repeating substring.

import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingSubstring {
    //查找是否存在长度为length的重复子串
    public boolean f(String s, int length){
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < s.length() - length; i ++){
            int j = i + length - 1;
            String sub = s.substring(i, j + 1);
            if (seen.contains(sub)){
                return true;
            }
            seen.add(sub);
        }
        return false;
    }

    public int longestRepeatingSubstring(String s){
        int l = 0, r = s.length() - 1;
        while (l < r){
            int mid = l + (r - 1 + 1) / 2;
            if (f(s, mid)){
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }



}
