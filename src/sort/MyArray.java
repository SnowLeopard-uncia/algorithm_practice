package sort;

import java.util.HashSet;
import java.util.Set;

public class MyArray {
    public static void main(String[] args) {
        int nums[] ={2,3,1,0,5,3};
        System.out.println(findRepeatNumber(nums));
    }

    //数组中重复的数字找出数组中重复的数字。
    //在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
    //链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
   //官方思路：遍历数组，添加到set中，若添加失败，说明该数字是重复数字
    public static int findRepeatNumber(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int repeat=-1;
        for (int n: nums) {
            if (!s.add(n)){
                repeat=n;
                break;
            }
        }
        return repeat;
    }

}
