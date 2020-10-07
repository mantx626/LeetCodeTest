package com.company.BinarySearch;

public class lastOccuranceOf2 {
    public int binarySearch(int[] arr, int k){
        int l = 0, r = arr.length - 1;
        while (l < r -1){
            int mid = l + (r - l) / 2;
            if (arr[mid] < k){
                l = mid;
            } else {
                r = mid;
            }
        }

        if (arr[r] < k){
            return r;
        } else if (arr[l] > k){
            return l;
        } else {
            return k - arr[l] < arr[r] - k ? l : r;
        }
    }
}
