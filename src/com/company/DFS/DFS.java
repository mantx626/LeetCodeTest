package com.company.DFS;



public class DFS {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    //Q-104 Maximum Depth of Binary Tree
    public int maxDepth(TreeNode node){
        if (node == null){
            return 0;
        }
        int maxleft = maxDepth(node.left);
        int maxright = maxDepth(node.right);
        int maxDepth = Math.max(maxleft,maxright) + 1;
        return maxDepth;
    }
    //Q-124 Binary Tree Maximum Path Sum
    int max = Integer.MIN_VALUE;
    public int MaximumPathSum(TreeNode root){
        MaximumSide(root);
        return max;
    }
    public int MaximumSide(TreeNode node){
        if (node == null){
            return 0;
        }
        int left = MaximumSide(node.left);
        int right = MaximumSide(node.right);
        left = left < 0 ? 0 : left;
        right = right < 0 ? 0 : right;
        max = Math.max(max, left + right + node.val);
        return Math.max(left + node.val, right + node.val);
    }
    //Top Down DFS
    //Q-129 Sum Root to Leaf Numbers
    int sum = 0;
    public int sumNumbers(TreeNode root){
        if (root == null){
            return 0;
        }
        sumDFS(root,0);
        return sum;
    }
    public void sumDFS(TreeNode root, int num){
        num = num * 10 + root.val;
        if (root.left == null && root.right == null){
            sum += num;
            return;
        }
        if (root.left != null){
            sumDFS(root.left, num);
        }
        if (root.right != null){
            sumDFS(root.right, num);
        }
    }







    //Preorder Traversal
    public void PreDFS(TreeNode node){
        if (node == null){
            return;
        }
        System.out.println(node.val);
        PreDFS(node.left);
        PreDFS(node.right);
    }
    //Inorder Traversal
    public void InorderDFS(TreeNode node){
        if (node == null){
            return;
        }
        InorderDFS(node.left);
        System.out.println(node.val);
        InorderDFS(node.right);
    }
    //Postorder Traversal
    public void PostorderDFS(TreeNode node){
        if (node == null){
            return;
        }
        PostorderDFS(node.left);
        PostorderDFS(node.right);
        System.out.println(node.val);
    }
}
