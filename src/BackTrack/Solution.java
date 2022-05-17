package BackTrack;

import LinkList.ListNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
//        List<Integer> l = new ArrayList<>();
//        l.add(1);
        int[] nums = {1,2,3};

        for (List<Integer> list: subsets(nums) ){
            System.out.println("分行");
            for (int a: list){
                System.out.println(a);
            }
        }

    }

    /**
     *     递归之前做选择，递归调用之后撤销选择
     *     递归之前在选择列表中选择出来后，把该数字从选择列表中移除，添加到回溯路径
     *     回溯后把该数字从路径中移除，再将该选择加入选择列表
     *     46题全排列。输入一个数组nums，返回这些数字的全排列
     */

    List<List<Integer>> res0 = new LinkedList<>();
    //记录路径
    LinkedList<Integer> track0 = new LinkedList<>();
    //路径中元素会被标记为true，避免重复
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {  //主函数
        used = new boolean[nums.length];
        backtrack(nums);
        return res0;
    }

    //track记录路径
    //nums中不存在于track中的元素（used[i]为false
    public void backtrack(int[] nums){
        if (track.size() == nums.length){
            //如果到达叶子结点，收集叶子结点的值
            res.add(new LinkedList<>(track0));
            return;
        }
        for (int i =0;i<nums.length;i++){
            //存在track，不能重复选择
            if (used[i]){
                continue;
            }
            //选择
            used[i]=true;
            track.addLast(nums[i]);
            //进入下一层回溯树
            backtrack(nums);
            //取消选择
            track.removeLast();
            used[i]=false;
        }
    }

    /**
     * 78 子集
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     */
    static List<List<Integer>> res = new LinkedList<>(); //记录结果
    //记录回溯算法的递归路径
    static LinkedList<Integer> track = new LinkedList<>();
    //track记录根节点到每个结点路径的值

    public static List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0);
        return res;
    }

    //回溯算法核心，遍历子集问题的回溯树
   static void backtrack(int[] nums,int starts){
        //前序位置，每个结点的值都是子集
        res.add(new LinkedList<>(track)); //这个是收集所有
        //回溯算法框架
        for (int i = starts; i < nums.length; i++) {
            //选择
            track.addLast(nums[i]);
            //通过start选择 控制参数遍历，避免重复子集
            backtrack(nums,i+1);
            //撤销选择
            track.removeLast();
        }
    }


}
