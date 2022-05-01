package Search;

import BinaryTree.Solution;
import BinaryTree.TreeNode;
import LinkList.LinkListConstruct;
import LinkList.ListNode;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int arr[]={-1,1,2,3,4,5,6,7,8,9,12,13,14,15,16,17,23,34,45,56};
//        int arr2D[][] = new int[5][5];
        //剑指offer 4.二维数组查找 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
        int [ ][ ]  arr2D={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},
                {10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        int [ ][ ]  arr2DNull={};
        int [ ][ ]  arr1DNull={{-1,3}};

        //创建链表
        ListNode listNode1 = new ListNode(1,null);
        ListNode listNode2 = new ListNode(2,listNode1);
        ListNode listNode3 = new ListNode(3,listNode2);

//        System.out.println(findNumberIn2DArray(arr1DNull,3));
//        System.out.println(replaceSpace("How are you"));
        System.out.println(reversePrint(listNode3));
        //测试
        /*
        System.out.println(searchSeq(arr,5));

        System.out.println(searchSeqImprove(arr,5));

        System.out.println(searchBin(arr,12));

       int result =  searchBinRecursion(arr,9,arr[1],arr.length-1);
        System.out.println("result: "+result);

        System.out.println(searchBST(TreeNode.orderBTInit(),3).val);

        System.out.println(findNumberIn2DArray(arr2DNull,1));
         */

        /*
       TreeNode<Integer> treeNode =  orderBTInit();
        TreeNode<Integer> newNode= insertBST(treeNode,8);
        Solution.printBT(treeNode);
 */

        /*
        int i=1,j=1;
        //结果：i：1，j：0 【i--是先取值后减 --j是先减后取值】，会提示说i--更改的值不会被使用
        System.out.println("i"+(i--)+"j"+(--j));
         */
    }

    //建立二叉树
    public static TreeNode<Integer> orderBTInit(){
        // 结构如下：(由下往上建立)
        //            4
        //       2         6
        //    1     3    5     7
        TreeNode<Integer> one = new TreeNode<Integer>(1, null, null);
        TreeNode<Integer> three = new TreeNode<Integer>(3, null, null);
        TreeNode<Integer> five = new TreeNode<Integer>(5, null, null);
        TreeNode<Integer> seven = new TreeNode<Integer>(7, null, null);
        TreeNode<Integer> two = new TreeNode<Integer>(2, one, three);
        TreeNode<Integer> six = new TreeNode<Integer>(6, five, seven);
        TreeNode<Integer> four = new TreeNode<Integer>(4, two, six);
        return four;  // 返回根节点
    }

//在顺序表中查找关键字为key的数据元素，找到则返回相应位置，否则为0
    public static int searchSeq(int[] arr, int key){
        for (int i = arr.length-1; i>=1 ; i--) {
            if (arr[i]==key) return i;
        }
        return 0;
    }
    //改进：设置0位是哨岗 减去了数组越界的判断
    public static int searchSeqImprove(int[] arr, int key){
        arr[0]=key;
        int i;
        for ( i = arr.length-1; arr[i]!=key ; i--);
        return i;
    }

    //二分查找
    public static int searchBin(int[] arr, int key){
        int low =1;
        int high = arr.length-1; //查找区间初值
        while(low<=high){
            int mid = (low+high)/2;
            if (key==arr[mid]) return mid;
            else if (key>mid) low=mid+1; //在前一个子表进行查找
            else high=mid-1; // 在后一个子表查找
        }
        return 0; //查找不到元素
    }

    //二分查找 递归版
    public static int searchBinRecursion(int[] arr, int key, int low, int high){
        int mid =(high+low)/2;
        if (key==arr[mid]) return mid; // 找到了
        else if (low>high) return 0; //找不到
        else if (key>mid) return searchBinRecursion(arr,key,mid+1,high);//在前一个子表进行查找
        else return searchBinRecursion(arr,key,low,mid-1);// 在后一个子表查找
    }

    //二叉排序树的递归查找
    public static TreeNode<Integer> searchBST(TreeNode<Integer> treeNode, int key){
        //找不到 则返回空，找到了就返回相应的值
        if ((treeNode==null) || key==(treeNode.val)) return treeNode;
        else if (key<treeNode.val) return searchBST(treeNode.left,key); // 在左子树中查找
        else return searchBST(treeNode.right,key);// 在右子树中查找
    }

    //二叉排序树的插入
    public static TreeNode<Integer> insertBST(TreeNode<Integer> treeNode, int key){
        //若二叉排序树不存在关键字等于key的元素，则插入
        if (treeNode==null){ //找到插入位置之后递归结束
            treeNode = new TreeNode();
            treeNode.left=treeNode.right=null;
            treeNode.val=key;
            return treeNode;
        }
        else if (key<treeNode.val) return insertBST(treeNode.left,key); // 在左子树中查找
        else return insertBST(treeNode.right,key);// 在右子树中查找
    }

    //剑指 4 二维数组查找 特殊的二维数组每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        //二维数组不存在的特殊情况  其中matrix.length==0的条件要写在matrix[0].length的前面，不然出现空数组会报错数组越界
        //因为先执行的前面的或，如果matrix.length写在后面IDE也会提示 matrix.length==0必为false
        if (matrix==null || matrix.length==0|| matrix[0].length==0 ){
            return false;
        }
        int row = 0;
        //matrix.length是二维数组的行数，matrix[0].length是列数
        int column = matrix[0].length-1;
        //结束条件是越界条件
        while (row<matrix.length && column>=0) {
            if (matrix[row][column]==target){
                System.out.println("row"+row+" column"+column);
                return true;
            }else if(matrix[row][column]>target){
                System.out.println("row"+row+" column"+column);
                column--;
            }else {
                System.out.println("row?"+row+" column"+column);
                row++;
            }
        }
        return false;
    }

    /**
     * 剑指5 替换空格 请实现一个函数，把字符串 s 中的每个空格替换成"%20"
     * 可以用StringBuilder
     * return s.replace(/\s/g, '%20')  看见有人用正则
     *官方是char[] array = new char[length * 3]; 用char存，然后
     * String newStr = new String(array, 0, size);转换成String
     * @param s
     * @return
     */

    public static String replaceSpace(String s) {
        int numOfBlank=0;
        int newLength=0;
        for (int i = 0; i < s.length(); i++) {
            Character a = s.charAt(i);
            if (a.equals(' ')){
                numOfBlank++;
            }
        }
        newLength=s.length()+numOfBlank*3;
//        String[] newString = new String[newLength];
        StringBuilder stringBuilder = new StringBuilder();
        int p1 = s.length();
        int p2 = newLength-1;
        for (int j = p1-1; j >=0; j--) {
           Character a = s.charAt(j);
            System.out.println("a:"+a);
           //注意这里是单引号  'a.equals(" ")' 始终为 'false' 'equals' 位于 'Character' 和 'String' 不可转换类型的对象之间
            if (a.equals(' ')){
//                newString[p2--]="0";
//                newString[p2--]="2";
//                newString[p2--]="%";
                stringBuilder.insert(0,"%20");
            }else {
//                newString[p2]= String.valueOf(a);
                stringBuilder.insert(0,a);
            }
        }
        return stringBuilder.toString();
    }

    //剑指6 从尾到头打印链表
    public static int[] reversePrint(ListNode<Integer> head) {
        Stack<ListNode<Integer>> stack = new Stack<>();
        while (head!=null){
            stack.push(head);
            head=head.next;
        }
        int[] a = new int[stack.size()];
        int size = stack.size();//为什么要加这一步呢，因为stack的size是会变的！pop一个出来栈的size就减一，而我们是想把数组填满，数组的size不能变。
        for (int i = 0; i < size; i++) {
            System.out.println("size:"+stack.size());
            a[i]=stack.pop().val;
//            System.out.println(a[i]);
        }
        //下面是傻傻的操纵，都没想到用栈长度来确定数组长度
        //        List<Integer> list = new ArrayList<>();
//
//        for (int i = 0; !stack.empty(); i++) {
//            list.add(stack.pop().val);
//        }
//        int[] a = new int[list.size()];
//        for (int i = 0; i < a.length; i++) {
//            a[i]=list.get(i);
//        }

        return a;
    }

}
