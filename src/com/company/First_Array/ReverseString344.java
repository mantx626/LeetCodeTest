package com.company.First_Array;
//hello->olleh
//反向pointer

public class ReverseString344 {
    public char[] reverseString(char[] str){
        //initialize
        int i = 0;
        int j = str.length - 1;
        //two pointers opposite direction
        while (i<j){
            //swap str[i] and str[j]
            char tmp = str[1];
            str[i] = str[j];
            str[j] = tmp;
            i++;
            j--;
        }
        return str;
    }
    public static void main(String[] args) {

    }
}
