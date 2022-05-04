package DP;

import java.util.Map;

public class Backpack01 {
    public static void main(String[] args) {
        int[] wt={2,1,3};
        int[] val={4,2,3};
        System.out.println(knapsack(4,3,wt,val));
    }

    /**
     * 0-1背包 可转载 W 的背包 N个物品，每个物品有对应重量和价值
     * 第i个物品重量wt[i]，价值val[i],用背包装最多能装价值
     * 例如N =3， W =4
     * wt=[2,1,3]
     * val=[4,2,3]
     *
     * 动态规划问题
     * 状态：背包容量，可选择物品
     * 选择：装或不装
     *
     * for state1 in state1_all
     *  for state2 in state2_all:
     *      dp[state1][state2] = best(choice1,choice2)
     *
     * dp定义 对于前 i 个物品（从 1 开始计数）
     * dp[i][w]:当前i个物品，当前背包容量w，可装最大价值为dp[i][w]
     *
     * base case: dp[0][...]=dp[...][0] =0
     * 没有物品或者背包没有空间 能装的是0
     *
     * 没装第i个 dp[i][w]等于dp[i-1][w]
     * 装了第i个：dp[i][w]等于val[i-1]+dp[i-1][w-wt[i-1]]
     * 数组索引从 0 开始，而我们定义中的 i 是从 1 开始计数的，所以 val[i-1] 和 wt[i-1] 表示第 i 个物品的价值和重量。
     */

   static int knapsack(int W ,int N,int[] wt,int[] val){
        int [][] dp = new int[N+1][W+1];
        for (int i = 1; i <=N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w-wt[i-1]<0){
//                    选择不装进背包 因为装不下了 w是假设背包的容量， wt[i-1] 是当前的要装的东西
                    dp[i][w] = dp[i-1][w];
                }else {
                    //装或者不装 择优
                    dp[i][w] = Math.max(
                            dp[i-1][w-wt[i-1]]+val[i-1],
                            dp[i-1][w]
                    );
                }
            }
        }
        return dp[N][W];
    }


}
