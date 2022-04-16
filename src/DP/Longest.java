package DP;

import java.util.Arrays;

public class Longest {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        //   System.out.println(numWays(46));
        int nums[]={10,9,2,5,3,7,101,18};
        int num[] = {5,4,-1,7,8};
  //      System.out.println(lengthOfLIS(nums));
        System.out.println(maxSubArray(num));
    }
    //3 f(1)+f(2)=2
    //4= f(2)+f(3)= 3
    //5= f(3)+f(4)=5
    public static Long numWaysLong(int n) {
        if(n==0 || n==1){
            return 1L;
        }
        Long dp[] = new Long[n+1];
        dp[0]=1L;
        dp[1]=1L;
        dp[2]=2L;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n]%1000000007L;
    }
    //青蛙跳台阶 剑指offer 动态规划类似斐波那契数列。
    public static int numWays(int n) {
        if(n==0 || n==1){
            return 1;
        }
        //dp数组表示跳上i级台阶需要的次数
        int dp[] = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%1000000007;
        }
        return dp[n];
    }
    //最长递增子序列 力扣300
    //想法：动态规划，dp[i]表示以num[i]为结尾的最长子序列，只要求出dp[0....i-1]的最长子序列，让比num[i]小的子序列拼上
    public static int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        //base case 数组全部初始化为1
        Arrays.fill(dp,1);
        for(int i=0;i<nums.length;i++){
            //每个数字开始遍历
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    //如果发现了比i小的，子序列加1，否则默认1（子序列初始长度，包含本身）
                    dp[i] = Math.max(dp[i],1+dp[j]);
                }
            }
        }
        int res = 0;
        for(int i = 0;i<dp.length;i++){
            res=Math.max(res,dp[i]);
        }
        return res;

    }
    //最长子序列，如果输出这个序列要怎么做

    //力扣53 最长子数组和  给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
    //子数组 是数组中的一个连续部分。
    public static int maxSubArray(int[] nums) {
        if (nums.length==0) return 0;
        int dp[]= new int[nums.length];
        dp[0]=nums[0]; //第0个没有子数组
        for (int i = 1; i < dp.length; i++) {
            //最大子数组 连续，要么是本身，要么是前面的加上本身 （如果前面加上本身更小，那本身就是最大了）
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
