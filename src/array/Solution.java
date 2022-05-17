package array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] a = {2,3,3,2,1};
        int[] nums = {-4,-1,0,3,10};
        printNums(sortedSquares1(nums));

    }
    static void printNums(int[] a){
        for (int j : a) {
            System.out.println(j);
        }
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
    public int removeElement2(int[] nums, int val) {
        int low = 0;
        int high = nums.length-1;
        while (low<=high){
            while (low<=high && nums[low]!=val) low++; //寻找左边等于val的下标
            while (low<=high && nums[high]==val) high--; //寻找右边不等于val的下标  这里等于和不等于的情况反了！注意
            if (low<high){
                nums[low]= nums[high];
                low++;
                high--;
            }
        }
        return low; //左指针指向的最终数组末尾的下一个元素
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
        int k=high;
        while (low<=high){
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
}
