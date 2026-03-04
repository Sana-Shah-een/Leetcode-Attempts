/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//O(N)
class Solution {
    // static class TreeInfo{
    //     int ht;
    //     int diam;
    //     TreeInfo(int ht,int diam){
    //         this.ht=ht;
    //         this.diam=diam;
    //     }
    // }
    public static int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftsubtree=height(root.left);
        int rightsubtree=height(root.right);
        return Math.max(leftsubtree,rightsubtree)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
    //    return diameter(root).diam-1;
    if(root==null){
        return 0;
    }
    int diam1=diameterOfBinaryTree(root.left);
    int diam2=diameterOfBinaryTree(root.right);
    int diam3=height(root.left)+height(root.right);
    return Math.max(diam3,Math.max(diam1,diam2));

    }
    // public static TreeInfo diameter(TreeNode root){
    //     if(root==null){
    //         return new TreeInfo(0,0);
    //     }
    //     TreeInfo left=diameter(root.left);
    //     TreeInfo right=diameter(root.right);
    //     int treeHeight=Math.max(left.ht,right.ht)+1;
    //     int diam1=left.diam;
    //     int diam2=right.diam;
    //     int diam3=left.ht+right.ht+1;
    //     int treeDiam=Math.max(diam3,Math.max(diam1,diam2));

    //     return new TreeInfo(treeHeight,treeDiam);
    // }
}