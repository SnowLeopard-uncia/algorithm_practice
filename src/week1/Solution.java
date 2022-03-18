package week1;

public class Solution {
    //记录最大深度
    static int res = 0;
    //记录遍历到节点的深度
    static int depth = 0;

    public static void main(String[] args) {
        TreeNode<String> treeNode = new TreeNode<String>();
        treeNode=treeNode.perfectBTInit();
//        treeNode=treeNode.init();
//       System.out.println(maxDepth(treeNode));
//        System.out.println(countTree(treeNode));
//        transBT(treeNode);
        printBT(treeNode);

    }

  //二叉树最大深度
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

    //计算二叉树节点
    public static int countTree(TreeNode root){
        if (root == null){
            return 0;
        }else {
            return 1+countTree(root.left)+countTree(root.right);
        }
    }

    //二叉树翻转 把二叉树上的每一个节点的左右子节点进行交换
    public static void transBT(TreeNode root){
        if (root == null) return;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        transBT(root.left);
        transBT(root.right);
        //打印出一棵二叉树 后序遍历
        System.out.println(root.val);
    }

    //先序遍历输出二叉树
    public static void printBT(TreeNode root){
        if (root == null){
            return;
        }else {
            System.out.println(root.val);
            printBT(root.left);
            printBT(root.right);
        }
    }

}
