package BinaryTree;

import sun.reflect.generics.tree.Tree;

import javax.management.QueryEval;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    //记录最大深度
    static int res = 0;
    //记录遍历到节点的深度
    static int depth = 0;

    public static void main(String[] args) {
        TreeNode<String> treeNode = new TreeNode<String>();
        treeNode=treeNode.perfectBTInit();
        int arr[] = new int[]{3,2,1,6,0,5};
        int preorder[] = new int[]{3,9,20,15,7};
        int inorder[] = new int[]{9,3,15,20,7};
        int postorder [] = new int[]{9,15,7,20,3};
//        treeNode=treeNode.init();
//       System.out.println(maxDepth(treeNode));
//        System.out.println(countTree(treeNode));
//        transBT(treeNode);
//        printBT(treeNode);
//        connect(treeNode);
//        printBT(constructMaximumBinaryTree(arr));
//        printBT(buildTree(preorder,inorder));

//        System.out.println(PrintFromTopToBottom(treeNode).toString());
//        printBT(buildTreeInPost(inorder,postorder));
    }

    /**
     * 先序遍历
     * @param root
     * @return
     */
    public static void traverse0(TreeNode root){
        if (root==null){
            return;
        }
        System.out.println(root.val);
        traverse0(root.left);
        traverse0(root.right);
    }

   static List<Integer> list1 = new LinkedList<>();
    /**
     * 中序遍历
     * @param root
     * @return
     */
    public static void traverse1(TreeNode root){
        if (root==null){
            return;
        }
        traverse1(root.left);
        System.out.println(root.val);
        list1.add((Integer) root.val);
        traverse1(root.right);
    }


    static List<Integer> list2 = new LinkedList<>();
    /**
     * 后序遍历
     * @param root
     * @return
     */
    public static void traverse2(TreeNode root){
        if (root==null){
            return;
        }
        traverse2(root.left);
        traverse2(root.right);
        System.out.println(root.val);
        list2.add((Integer) root.val);
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

    /**
     * 二叉树翻转 把二叉树上的每一个节点的左右子节点进行交换
     * @param root
     */
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

    /**
     * 先序遍历输出二叉树
     * @param root
     */
    public static void printBT(TreeNode root){
        if (root == null){
            System.out.println("null");

        }else {
            System.out.println(root.val);
            printBT(root.left);
            printBT(root.right);
        }
    }

    /**
     * 链接二叉树的同一层的结点
     * @param root
     * @return
     */
    public static TreeNode connect(TreeNode root) {
        if(root == null) return null;
        connectTwoNode(root.left,root.right);
        return root;
    }
    public static void connectTwoNode(TreeNode root1, TreeNode root2){
        if(root1 == null || root2 == null) return ;
        root1.next=root2;
        connectTwoNode(root1.left,root1.right);
        connectTwoNode(root2.left,root2.right);
        connectTwoNode(root1.right,root2.left);
    }

    /**
     * 利用数组的最大值作为根节点递归构造二叉树
     * @param nums
     * @return
     */
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
//        if (nums.length==0) return null;
        //头指针和尾指针
        return build(nums,0,nums.length-1);

    }

    //返回根节点
    public static TreeNode build(int[] nums, int head, int tail){
        if (head>tail){
            return null;
        }
        int max=-1; //max是-1是因为max取值是从0--1000，如果是0，if语句无法进入，就会出现index无法更新的错误
        int index=0; // index是0还是-1都无所谓
        for (int i = head; i <= tail ; i++) {
            if (nums[i]>max){
                index = i;
                max=nums[i];

            }
        }

        TreeNode node = new TreeNode(max);
//        int arrLeft[] = Arrays.copyOfRange(nums,0,index-1);
        node.left = build(nums,head,index-1);
//        int arrRight[] = Arrays.copyOfRange(nums,index+1,nums.length-1);
        node.right = build(nums,index+1,tail);
        return node;
    }

    /**
     * 105题 中序遍历和前序遍历构造二叉树  总体递归思路是对的，有点小细节
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,
                inorder,0,inorder.length-1);
    }

    /**
     * 返回二叉树根节点
     * @param preorder
     * @param preStart
     * @param preEnd
     * @param inorder
     * @param inStart
     * @param inEnd
     * @return
     */

    public static TreeNode build(int[] preorder, int preStart, int preEnd,
                                 int[] inorder, int inStart, int inEnd){
        //遍历边界
        if (preStart>preEnd){
            return null;
        }
        //先序遍历第一个是根节点
        //在中序遍历中找根节点坐标，得到左边树的长度
        int index=0;
        //要小于等于，不然坐标相同，也就是一个结点的情况，无法赋值index
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]){
                index = i;
            }
        }
        int leftSize = index - inStart;
//        int leftSize = index; 这里leftSize不应该直接等于index，它不是死的
        TreeNode treeNode = new TreeNode(preorder[preStart]);
       treeNode.left= build(preorder,preStart +1,preStart+leftSize,inorder,inStart,index-1);
       treeNode.right=build(preorder,preStart+leftSize+1,preEnd,inorder,index+1,inEnd);
        return treeNode;

    }

    /**
     * 106题目中序遍历和后序遍历确定二叉树
     * @param inorder
     * @param postorder
     * @return
     */
    public static TreeNode buildTreeInPost(int[] inorder, int[] postorder) {
        return buildInPost(inorder,0,inorder.length-1,
                postorder,0, postorder.length-1);
    }

    private static TreeNode buildInPost(int[] inorder, int inStart, int inEnd,
                                        int[] postorder, int postStart, int postEnd) {
        if (inStart>inEnd){
            return null;
        }
            int index =0;
        for (int i = inStart; i <= inEnd; i++) {
            //postorder[postorder.length-1] 我一开始这么写，有点写死了,因为这个的长度是会变的，数组长度不变，选中的子树会变
            if (inorder[i]==postorder[postEnd]){
                index=i;
                break;
            }
        }
        int leftSize =index- inStart;
        TreeNode treeNode = new TreeNode(postorder[postEnd]);
        treeNode.left=buildInPost(inorder,inStart,index-1,postorder,postStart,postStart+leftSize-1);
        treeNode.right=buildInPost(inorder,index+1,inEnd,postorder,postStart+leftSize,postEnd-1);
        return treeNode;

    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            //检索此队列的头部，但不删除，如果此队列为空，则返回null。返回值:此队列的头部,如果这个队列是空的为 null
            TreeNode<Integer> nowNode = q.peek();
            //检索并删除该队列的头部，如果该队列为空则返回null。返回值:此队列的头部,或null如果这个队列是空的
            q.poll();
            resultList.add(nowNode.val);
            if (nowNode.left != null) {
                q.add(nowNode.left);
            }
            if (nowNode.right != null) {
                q.add(nowNode.right);
            }
        }

        return resultList;
    }

    /**
     * 102 层序遍历
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
     */

    List<List<Integer>> resultList = new LinkedList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        checkFun(root);
        return resultList;

    }

    private void checkFun(TreeNode root) {
        if (root == null){
            return;
        }
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root); //把结点插入队列 第一个结点

        while (!que.isEmpty()){ //如果队列不空为结束条件，因为如果一直有子节点的话就会一直加入队列，所以队列为空就是没有结点了
            List<Integer> itemList = new ArrayList<Integer>(); //用来记录结果集合
            int len = que.size(); //队列长度，这里就是看有多少个要被取左右结点的
            while (len>0){
                TreeNode temp = que.poll(); //把第一个拿出来
                itemList.add((Integer) temp.val);  //结果集合加进去
                if (temp.left!=null) que.offer(temp.left); //如果左边不为空，加进队列，其实这里把左右结点都加进了队列
                if (temp.right !=null) que.offer(temp.right);
                len--; //取完
            }
            resultList.add(itemList);
        }
    }

}
