package week1;

import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        maxDepth(treeNode);
    }

    //记录最大深度
    static int res = 0;
    //记录遍历到节点的深度
    static int depth = 0;
    public static int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    static void traverse(TreeNode root){
        if(root == null){
            return;
        }
        depth++;
        res = Math.max(res,depth);
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}
