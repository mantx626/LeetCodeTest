package com.company.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Stack {
    //739.Daily Temperature
    //Find the distance to next greater element for each arr[i]
    public int[] dailyTemperature(int[] T){
        int n = T.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i ++){
            while(!stack.isEmpty() && T[i] >= T[stack.peek()]){
                stack.pop();
            }
            if (stack.isEmpty()) result[i] = 0;
            else result[i] = stack.peek() - i;
            stack.push(i);
        }
        return result;
    }

    //735. Asteroid Collision
    //1.
    public int[] asteroidCollision(int[] asteroids){
        Deque<Integer> stack = new ArrayDeque<>();
        for (int ast : asteroids){
            //1.栈顶为负（说明站内全负），或者空，遇到正数，直接入栈
            if (ast > 0){
                stack.push(ast);
            } else {
                //2.栈不空，栈顶为正，栈顶小于遇到的数，栈顶弹出。遇到的数入不入栈待定。（直到栈为空，说明遇到的负数最大，入栈。）
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < - ast){
                    stack.pop();
                }
                //2.1.栈不空，栈顶为正，定义绝对值相等的情况，遇到的数不入栈。
                if (!stack.isEmpty() && stack.peek() > 0 && stack.peek() == -ast){
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0){ //2.2 直到栈为空或者只剩负数，说明遇到的负数最大，入栈
                    stack.push(ast);
                }
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--){
            result[i] = stack.pop();
        }
        return result;
    }
}
