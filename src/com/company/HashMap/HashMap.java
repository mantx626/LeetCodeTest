package com.company.HashMap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

public class HashMap {
    //Q-1: Two Sum input{2,5,7,8},target:9. Output: 0,2
    public int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new java.util.HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])) return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
        return new int[2];
    }
    //Q-1 另一种方法
    public int[] twoSum2(int[] nums, int target){
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[]{nums[i], nums[j]};
            } else if (sum > target){
                j--;
            } else {
                i++;
            }
        }
        return null;
    }

    //Q-560: Subarray Sum Equals K. eg: INTPU: [1,1,1], k = 2. OUTPUT: 2
    public int subarraySum(int[] nums, int k){
        Map<Integer,Integer> map = new java.util.HashMap<>();
        map.put(0,1);
        int sum = 0, cnt = 0;
        for (int x : nums){
            sum = sum + x;
            if(map.containsKey(sum - k)){
                cnt = cnt + map.get(sum - k);
            }
            map.put(sum,map.getOrDefault(sum,0) + 1);
        }
        return cnt;
    }
}
