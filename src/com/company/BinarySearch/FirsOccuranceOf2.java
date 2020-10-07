package com.company.BinarySearch;

public class FirsOccuranceOf2 {
    public int binarySearch(int[] arr, int k){
        int l = 0, r = arr.length - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            if (arr[mid] < k){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return l;
    }
}
