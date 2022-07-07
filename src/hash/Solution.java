package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

    /**
     * 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
     * 链接：https://leetcode.cn/problems/valid-anagram
     *
     * 哈希表做法，维护一个数组作为26个字母映射的哈希表，（字母映射为数字）
     * 数组表示：数组的下标表示被映射的字母，里面的内容表示字母出现了多少
     * 对第一个字符串，里面有的字母加进去，对第二个字符串，里面有的从数组中减去
     * 遍历数组，若最后数组为全0，说明加减抵消，是字母异位词，若里面有不为0的，说明不一样
     */
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26]; //维护一个数组

        for(char c : s.toCharArray()){
            record[ c - 'a'] +=1;
        }
        for(char c : t.toCharArray()){
            record[c - 'a'] -=1;
        }
        for(int a : record){
            if(a!=0){
                return false;
            }
        }
        return true;
    }

    /**
     * 349.两个数组的交集
     * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。
     * 输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序
     *
     * https://leetcode.cn/problems/intersection-of-two-arrays/
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length==0 || nums2==null || nums2.length==0){
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i :nums1){ //把第一个数组的数字记录下来
            set1.add(i);  //add
        }
        for(int i :nums2){
            if(set1.contains(i)){ //这个contains是有s的哦
                set2.add(i); //寻找交集
            }
        }
        int[] arr = new int[set2.size()]; //转化为数组
        int index=0;
        for(int i : set2){  //set这样来遍历 输出
            arr[index++] = i;
        }
        return arr;
    }

    /**
     * 快乐数
     * 编写一个算法来判断一个数 n 是不是快乐数。
     * 「快乐数」定义为：
     * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * 如果这个过程 结果为1，那么这个数就是快乐数。
     * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
     * 链接：https://leetcode.cn/problems/happy-number
     * @param n
     * @return
     */

    public static boolean isHappy(int n) {
        int sum =0;
        Set<Integer> set = new HashSet<>();
        while(true){
            sum=getSum(n);
            if(sum==1){
                return true;
            }
            if(!set.contains(sum)){
                set.add(sum);
            }else{  //如果sum出现过，说明已经进入循环，是无法得到1的！
                return false;
            }
            n=sum;
        }
    }

    public static int getSum(int n){
        int sum=0;
        while(n!=0){
            sum = sum+(n%10)*(n%10); //n模10 ，得到的是个位数的数字  这里不要忘记+sum啦
            //n除以10，得到的是个位数前面的数
            n=n/10;
        }
        return sum;
    }

    /**
     * 1. 两数之和
     * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     * 链接：https://leetcode.cn/problems/two-sum
     *2 <= nums.length <= 104 所以不怕nums为空了
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * 只会存在一个有效答案
     *
     * 下面是哈希法，当然可以暴力
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>(); //前面是值，后面是值对应的坐标
        for(int i = 0;i<nums.length;i++){
            int temp = target-nums[i]; //
            if(map.containsKey(temp)){ //map的方法 //如果存在相加为target的话（因为只有一个结果），就插入
                res[0] = i;
                res[1] = map.get(temp); //获取坐标
            }
            map.put(nums[i],i); //先加进去
        }
        return res;
    }

}
