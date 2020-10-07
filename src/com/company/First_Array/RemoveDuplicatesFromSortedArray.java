package com.company.First_Array;
//question 26 [1,1,2]->[1,2]
//同向
//i标记赋值的位置，j寻找下一个值
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] arr){
        //initialization
        int i = 0, j = 0;
        while(j < arr.length){
            //If not duplicate, keep it, otherwise skip it
            if (i == 0 || arr[j] != arr[i - 1]){
                arr[i++] = arr[j++];
            } else {
                j++;
            }
        }
        //i is now at the length of the new array.
        return i;
    }
}
