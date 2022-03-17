package week1;

public class Traverse {

    public static void main(String[] args) {
        int [] arr = new int[10];
        init(arr);
//        traverse(arr);
        traverse(arr,0);
    }

    public static void init(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;
        }
    }

   static void traverse(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static void traverse(int[] arr,int i){
        if (i==arr.length){
            return;
        }
        //前序位置，输出0-9
//        System.out.println(arr[i]);
        traverse(arr,i+1);
        //后序位置，输出9-0
        System.out.println(arr[i]);
    }
}


 // Definition for a binary tree node. 二叉树类型
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

