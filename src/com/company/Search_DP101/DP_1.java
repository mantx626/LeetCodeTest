package com.company.Search_DP101;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DP_1 {
    //Q-139 word break
//    boolean是基本数据类型，而Boolean是一个包装类
//    boolean一般存在于栈空间中，而Boolean对象存在于堆空间中
//    boolean有true和false两种值，Boolean除了有true和false之外，还有null
//    进行强制转换时，需要使用Boolean.
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict){
        int n = s.length();
        memo = new Boolean[n + 1];
        return DFS(s, n, new HashSet<>(wordDict)); //HashSet的查找时间复杂度为O(1)
    }
    private boolean DFS(String s, int len, Set<String> dict){
        if (len == 0){
            return true;
        }
        if (memo[len] != null){
            return memo[len];
        }

        memo[len] = false;
        for (int j = 0; j < len; j++){
            boolean right = dict.contains(s.substring(j, len));
            if (!right){
                continue;
            }
            boolean left = DFS(s, j, dict);
            if (left){
                memo[len] = true;
                break;
            }
        }
        return memo[len];
    }

    public static void main(String[] args) {
        DP_1 dp = new DP_1();
        List<String> s = new LinkedList<>();
        s.add("apple");
        s.add("pen");
        String ss = "applepenapple";
        System.out.println(dp.wordBreak(ss,s));
        for (int i = 0; i < dp.memo.length; i++){
            System.out.print(dp.memo[i]);
        }


    }
}
