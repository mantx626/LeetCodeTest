package com.company.BFS;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    //Q-102

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size(); //用来判断每层是否结束
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
            }
            res.add(level);
        }
        return res;
    }
    //Q-104
    public int maxDepth (TreeNode root){
        if (root == null){
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }

            }
            depth++;
        }
        return depth;
    }
    //Q-199 Binary Tree Right Side View
    public List<Integer> rightSideView (TreeNode root){
        List<Integer> res = new LinkedList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            res.add(queue.peek().val); //提取队列最前面的元素的值

            for (int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                //存取顺序定为从右到左
                if (cur.right != null){
                    queue.offer(cur.right);
                }
                if (cur.left != null){
                    queue.offer(cur.left);
                }
            }
        }
        return res;
    }
}
