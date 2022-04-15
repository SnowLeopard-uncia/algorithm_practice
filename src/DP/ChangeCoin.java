package DP;

import java.util.Arrays;

import static java.lang.Math.min;

public class ChangeCoin {

    public static void main(String[] args) {

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


}
