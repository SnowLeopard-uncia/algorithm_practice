package DP;

import java.util.Arrays;

import static java.lang.Math.cos;
import static java.lang.Math.min;

public class ChangeCoin {

    public static void main(String[] args) {
        int[][] nums ={{2,1,3},{6, 5, 4}, {7, 8, 9}};
//        System.out.println(minFallingPathSum(nums));
//        System.out.println(longestCommonSubsequence("abcde","ace"));
//        System.out.println(longestCommonSubsequenceMemo("abcde","ace"));
//        System.out.println(climbStairs(6));
        int[] cost ={10,12,20,30};
        System.out.println(minCostClimbingStairs(cost));

    }

    //力扣322 凑零钱问题，给你K种面值硬币，面值分别为c1,c2...ck,总金额amount,问最少几枚金币凑出
    //凑不出返回-1
    //使用备忘录
    int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        // dp数组全部初始化为特殊值
        Arrays.fill(memo, -666);
        return dp(coins, amount);
    }

    int dp(int[] coins, int n) {
        //如果0就需要0个币
        if (n == 0) return 0;
        //无解
        if (n < 0) return -1;
        //就是如果不是默认值，就是有记录的
        if (memo[n] != -666) {
            return memo[n];
        }
        int res = Integer.MAX_VALUE;

        for (int coin : coins) {
            //计算子问题的结果
            int subProblem = dp(coins, n - coin);
            //子问题无解跳
            if (subProblem == -1) continue;
            //子问题中找最优解，最后加一（为什么）
            res = min(res, 1 + subProblem);
        }
        memo[n] = (res == Integer.MAX_VALUE) ? -1 : res;
        //返回值代表了什么
        return memo[n];
    }

    //迭代解法
    // 在此解法中， dp数组表示的是 凑成那么多零钱最少需要的硬币数量
    public int coinChangeAnother(int[] coins, int amount) {
        int dp[] = new int[amount];
        Arrays.fill(dp,amount+1);//因为最大不会超过amount
        dp[0]=0; ///base case
        for (int i = 0; i < dp.length; i++) {
            //取最小值
            for (int j = 0; j < coins.length; j++) {
                if (i<j){
                    continue;
                }
                dp[i] = Math.min(dp[i],1+dp[i-j]);
            }
        }
        return (dp[amount] == amount+1)? -1:dp[amount];
    }


    //给你一个 n x n 的 方形 整数数组matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
    //力扣下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
    //链接：https://leetcode-cn.com/problems/minimum-falling-path-sum
    //解法 求最值用动态规划，base case是 状态：dp[][]表示在对应的格子里的最短路径的长度
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        //1.索引合法
        //2.base case
        //3.状态转移
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) { //j<n始终为true 为什么
                if (i==0){
                dp[0][j]=matrix[0][j];
                }else if(j==0){
                    dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j+1]);
                }else if(j==(m-1)){
                    dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j-1]);
                }
                else {
                    dp[i][j]=matrix[i][j]+min3(dp[i-1][j],dp[i-1][j+1],dp[i-1][j-1]);
                }
            }
        }

        int res =Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            System.out.println("");
//            for (int j = 0; j < m; j++) {
//                System.out.println(dp[i][j]);
//            }
//        }
        for (int i = 0; i < m; i++) {
            res = Math.min(dp[n-1][i],res);
        }
        return res;
    }


    //三个数取最小
    public static int min3(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }

    /** 力扣 1143. 最长公共子序列
     * 给定两个字符串text1 和text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
     * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
     * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
     * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        //1. 明确base case 边界，是当 dp[0][...] = dp[...][0] =0;第0个是0这个意思，因为第0个就是没有呀
        //2. 明确dp数组的定义  此处dp[i][j]数组定义为text1(i),text2(j)的最长公共子序列
        //3. 状态转移
        int n = text1.length();
        int m =text2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }

            }
        }
        return dp[n][m];

    }

    //递归-备忘录 解法
    static int[][] memo0;
    public static int longestCommonSubsequenceMemo(String text1, String text2) {
        //1. 明确base case 边界 当i=text1.length() 或者j=text2.length()的时候等于0。
        //2. 明确dp数组的定义  此处dp[i][j]数组定义为text1(i),text2(j)的最长公共子序列
        //3. 备忘录
        //4. 状态转移
        int n = text1.length();
        int m =text2.length();
        memo0 = new int[n][m];
        for (int i = 0; i < n; i++) {
           Arrays.fill(memo0[i],-1); //-1表示未曾计算
        }
        return longestCommonSubsequenceMemoDP(text1,0,text2,0);
    }
    // 定义：计算 s1[i..] 和 s2[j..] 的最长公共子序列长度
    public static int longestCommonSubsequenceMemoDP(String text1,int i,String text2,int j){
        //base case 这里是递归的边界，就是数组越界的条件

        if (i == text1.length() || j==text2.length()) {
            System.out.println("base case: 0");
            return 0;
        }
        //之前计算过直接返回备忘录答案
        if (memo0[i][j]!=-1){
            System.out.println("memo0[i][j]: "+memo0[i][j]);
            return memo0[i][j];
        }
        if (text1.charAt(i)==text2.charAt(j)){
            // s1[i] 和 s2[j] 必然在 lcs 中
            System.out.println("==");
            return 1+longestCommonSubsequenceMemoDP(text1,i+1,text2,j+1);
        }else {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中 相当于固定一个动另一个
            System.out.println("!=");
            memo0[i][j] = Math.max(longestCommonSubsequenceMemoDP(text1,i+1,text2,j),
                    longestCommonSubsequenceMemoDP(text1,i,text2,j+1));
        }
        return memo0[i][j];
    }

    /**
     * 爬楼梯，一次可以爬1级或者2级，有多少种方法可以爬到n级 同理青蛙跳台阶
     * 思路：动态规划，dp数组的定义是，跳i级，有dp[i]种方法
     */
    public static int climbStairs(int n){
        if (n<=1){
            return n;
        }  //这个是用来防止数组越界的，当n=1 的时候，数组长度2，dp[2]就越界了
        int[] dp = new int[n+1];
        dp[1]=1; //跳一级一种方法
        dp[2]=2; //跳2级2种方法，1+1，2
        for (int i = 3; i <=n ; i++) { //注意等于
            dp[i]=dp[i-1]+dp[i-2];  //跳三级的方法相当于前两级的方法相加（？） 因为跳n级，肯定先有跳n-1级或者n-2级，所以把n-1级和n-2级的跳法加起来
            // 因为前n-1 和 前 n-2阶梯的次数 再跳一级，就可以到达n了，所以跳法，其实就是前面的跳法相加嘛。画个树图就知道了
        }
        return dp[n];
    }

    /**
     * 使用最小花费爬楼梯
     * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
     * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
     * 请你计算并返回达到楼梯顶部的最低花费。
     * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
     * 思路：最后一步可以理解为 不用花费。dp[i]定义为：达到第i个台阶，花费最少体力为dp[i]
     * 因为是选最小的，所以min(dp[i-1],dp[i-2])+cos[i]
     * 初始化：dp[0] = cost[0], dp[1] = cost[1]
     */
    public static int minCostClimbingStairs(int[] cost) {
        if (cost==null ||cost.length == 0 ){
            return 0;  //如果没有东西，空数组要注意，因为||是先从前往后开始运算的，如果cost为空，cost.length会报错空指针异常
        }
        if (cost.length==1){
            return cost[0]; //等于1就不会有cost[1] 了，dp注意数组边界！
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i =2;i<cost.length;i++){
            dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        //最后一步，如果是由倒数第二步爬，则最后一步的体力花费可以不用算
//        return dp[cost.length-1]; 这里就不是返回最后一步了，为什么，因为1和2都可能行，所以不能只返回一个。
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }

}
