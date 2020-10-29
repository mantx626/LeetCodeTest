package com.company.Search_DP101;

import java.util.ArrayList;
import java.util.List;

public class SearchDP {
    //Q-78 Subsets
    //一个set 有 2的n次方个subsets
    //Top Down DFS模板
    //1. Define STATE of subproblems
    //2. Initialize initial state
    //3. Call DFS(init_state)
    //DFS(state):
    //  1. base case check
    //  2. for each subproblem x
    //      a. Update state = next_state_x
    //      b. Branch down -> call DFS(next_state_x)
    //      c. Restore state
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        DFS(res, nums, new ArrayList<>(), 0);
        return res;
    }
    private void DFS(List<List<Integer>> res, int[] nums, List<Integer> cur, int index){
        if (index >= nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[index]);
        DFS(res, nums, cur, index+1);
        cur.remove(cur.size() - 1);
        DFS(res, nums, cur, index + 1);
    }


}
