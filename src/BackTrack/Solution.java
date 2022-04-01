package BackTrack;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }

    //递归之前做选择，递归调用之后撤销选择
    //递归之前在选择列表中选择出来后，把该数字从选择列表中移除，添加到回溯路径
    //回溯后把该数字从路径中移除，再将该选择加入选择列表
    //46题全排列。输入一个数组nums，返回这些数字的全排列
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        //记录路径
        LinkedList<Integer> track = new LinkedList<>();
        //路径中元素会被标记为true，避免重复
        boolean[] used = new boolean[nums.length];
        return null;
    }

    //track记录路径
    //nums中不存在于track中的元素（used[i]为false
    public void backtrack(int[] nums,LinkedList<Integer> track,boolean[]used){

    }
}
