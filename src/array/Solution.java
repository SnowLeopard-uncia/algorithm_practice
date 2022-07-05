package array;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] a = {2,3,3,2,1};
        int[] nums = {-4,-1,0,3,10};
        int[] num={2,3,1,2,4,3};
        int[] num0={1,1,1,1,1,1,1,1};
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        int[] numsp={3,2,2,3};
        //printNums(sortedSquares1(nums));
       // print(minSubArrayLen1(7,num));
        print(minSubArrayLenp(7,num));
//        rotate(matrix);
//        printNums(removeElementp(numsp,3));
//        printNums(removeElement2(numsp,3));
        generateMatrix(4);

    }
    static void printNums(int[] a){
        for (int j : a) {
            System.out.println(j);
        }
    }

    static <E> void print(E e){
        System.out.println(e);
    }
    /** 27. 移除元素
     * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * 链接：https://leetcode.cn/problems/remove-element
     * 方法一：暴力破解：两个for循环，外层for用于遍历整个数组，内层for用于比较后讲数组元素集体提前一位
     * 方法二：双指针法：快慢指针亦步亦趋
     * 方法三：相向双指针方法
     */
    public static int removeElement(int[] nums, int val) {
        int size = nums.length;
        for (int i=0;i<size;i++){
            if (nums[i]==val){
                for (int j = i+1;j<size;j++){ //发现需要移除的元素，将数组集体向前移动一位
                    nums[j-1]=nums[j];
                }
                i--; //因为下标i之后的数值向前移动了一位，所以i也向前移动了一位
                size--; //数组大小--
            }
        }
        System.out.println("size"+size);
        return size;
    }

    /**
     * 方法二：双指针法：快慢指针亦步亦趋
     * fast指针向前移动，slow指针
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement1(int[] nums, int val) {
        int slowIndex=0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (val!=nums[fastIndex]){
                nums[slowIndex++]=nums[fastIndex];
            }
        }
        return slowIndex;
    }

    /**
     * 方法三：相向双指针方法 【看着很快排啊】
     * 就是寻找左边等于val的，寻找右边不等于val的，然后将右边不等于val 的数字覆盖左边的
     * （感觉前提是排好之后可以乱序）
     * @param nums
     * @param val
     * @return
     */
    public static int[] removeElement2(int[] nums, int val) {
        int low = 0;
        int high = nums.length-1;
        while (low<=high){
            while (low<=high && nums[low]!=val) low++; //寻找左边等于val的下标
            while (low<=high && nums[high]==val) high--; //寻找右边不等于val的下标  这里等于和不等于的情况反了！注意!!!!【又一次反了！！】
            if (low<high){
                nums[low]= nums[high];
                low++;
                high--;
            }
        }
        return nums; //左指针指向的最终数组末尾的下一个元素
    }

    /**
     * 练习版
     * @param nums
     * @param val
     * @return
     */
    public static int[] removeElementp(int[] nums, int val) {
        int size = nums.length; //因为size 会变，所以不能length
        for(int i=0;i<size;i++){
            if(val==nums[i]){
                for(int j = i;j<nums.length-1;j++){
                    nums[j]=nums[j+1];
                }
                i--;
                size--;   //这俩要写在里面
            }

        }
        System.out.println("size"+size);
        return nums;
    }


    /**
     * 有序数组的平方
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     * 暴力破解法：每个数平方之后，再排序
     */
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i]*=nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 方法二：双指针法
     * 思路：数组平方的最大值，肯定在数组两端，不是在最右边就是在最左边
     * i指向起始，j指向终止位置
     * 定义一个新数组，和原来的数组一样长，让k指向末端
     * 让指针i和j分别向中间移动，选出大的放进新数组
     * @param nums
     * @return
     */
    public static int[] sortedSquares1(int[] nums) {
        int[] result = new int[nums.length];
        int low=0;
        int high=nums.length-1;
        int k=high;  //记得这里！
        while (low<=high){  //还有等号！！！！！不然两个相等就不算了
            int l=nums[low]*nums[low];
            int h= nums[high]*nums[high]; //记住这里，还是不要去改变原数组的值
            if (l>h){
                result[k--]=l;
                low++;
            }else {
                result[k--]=h;
                high--;
            }

        }
        return result;
    }

    /**
     * 209 长度最小的子数组
     * 给定一个含有n个正整数的数组和一个正整数 target 。
     *
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     * 链接：https://leetcode.cn/problems/minimum-size-subarray-sum
     * 方法一：暴力法
     */

    public int minSubArrayLen(int target, int[] nums) {
        int result=Integer.MAX_VALUE; //最终结果
        int subLength=0; //组成子数组的长度
        int sum; //计算和
        //思路：双层for循环，外层用来遍历每个数，内层是每个数和后面的组子数组
        for (int i = 0; i < nums.length; i++) {
            sum=0;
            for (int j = i; j < nums.length; j++) {
                sum+=nums[j];  //数组连续的数求和
                if (sum>=target){
                    subLength=j-i+1;  //找最小
                    result=result>subLength?subLength:result;
                    break;
                }
            }
        }
        return result==Integer.MAX_VALUE?0:result; //这里如果没有达到target标准，result应该等于0，这样的话上面的result还会表示最大值
    }
    /**
     * 滑动窗口法：不断调整子序列的起始坐标和终点坐标
     * 窗口内是什么？
     * 如何移动窗口的起始位置？
     * 如何移动窗口的结束位置？
     */
    public static int minSubArrayLen1(int target, int[] nums){
        int result=Integer.MAX_VALUE;
        int subLength=0;
        int sum=0;
        int i=0;//滑动窗口的起始位置。记住这里有一个指针
        for (int j = 0; j < nums.length; j++) {
            sum+=nums[j];
            while (sum>=target){
                subLength=j-i+1; //子数组长度
                result= Math.min(result, subLength);
                //i++;
                sum-=nums[i++]; //滑动窗口重点！这里维护的sum这变量，减去前面的数字并且移动i指针，维护了窗口

            }
        }
        return result==Integer.MAX_VALUE?0:result;
    }

    /**
     滑动窗口法 练习版
     */
    public static int minSubArrayLenp(int target, int[] nums) {
        int low =0; //起始坐标
        int subLength=0; //记录子数组的长度
        int sum = 0;// 记录sum
        int result = Integer.MAX_VALUE; //还是需要一个记录最终的结果 ,万一出现的0
        for(int high =0;high<nums.length;high++){
            sum = sum + nums[high]; //取窗口里面值的大小
            //用于移动起始位置
            while(sum>=target){ //问题在这，因为题目说，大于等于target都成立，所以这里要等于，不然等于7也判定为false
                // 大概是这里如果不写等于，就不会判124和43组合是合法的，最终结果呈现的是243的长度
                subLength=high-low+1;  //子序列长度
                sum = sum - nums[low]; //因为起始的指针移动，所以sum减小
                low++;
                result=result>subLength?subLength:result; //更新还是要在里面更新
            }

        }
        return result==Integer.MAX_VALUE?0:result; // 防止全0
    }

    /**
     * 48 旋转图像
     * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
     * 链接：https://leetcode.cn/problems/rotate-image
     * 【操作二维数组】
     * 旋转数组思路：首先沿着对角线交换数组元素，然后左右交换元素
     */
    public static void rotate(int[][] matrix) {
        int n =matrix.length; //二维数组的行数
        //这里是沿着对角线交换数字
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //反转二维数组的每一行
        for (int[] a: matrix){
            reserve(a);
        }

    }
    //反转一维数组 思路：双指针，一个在前一个在后，往中间靠拢 ，交换前后
    private static void reserve(int[] a) {
        int i=0;
        int j = a.length-1;
        while (i<j){
            int temp = a[i];
            a[i] =a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }

    /**
     * 水果成篮
     * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
     * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
     * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
     * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
     * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
     * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
     * 链接：https://leetcode.cn/problems/fruit-into-baskets
     * @param fruits
     * @return
     */

//    public static int totalFruit(int[] fruits) {
//        Map<Integer,Integer> map = new HashMap<>();
//        //滑动窗口
//        int sum =0;
//        int result =
//    }

    /**
     * 螺旋矩阵 II
     * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，
     * 且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     */
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int loop = n/2; //循环的次数
        int mid = n/2; //最中间的坐标
        int startx=0;
        int starty=0; //定义每次循环的起始坐标
        int offset = 1; //每次循环后,右边缩小一位
        int count=1;//每一个格子赋值
        int i,j;
        while(loop-->0){
            i=startx;
            j=starty;

            //四条边
            //左往右
            for( j = starty;j<n-offset;j++){
                res[startx][j]=count++;  //先赋值再自增
            }
            //上往下
            for( i =startx;i<n-offset;i++ ){
                res[i][j]=count++;
            }
//右往左
            for(;j>starty;j--){
                res[i][j]=count++;
            }
//下往上
            for(;i>startx;i--){
                res[i][j]=count++;
            }
            //第二圈的时候起始位置发生改变
            startx++;
            starty++;
            offset++;

        }
        if(n%2==1){
            res[mid][mid]=count;
            //处理中间
        }
        return res;
    }

}
