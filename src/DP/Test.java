package DP;

public class Test {
    public static void main(String[] args) {

//        int[][] nums = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] nums = {{0,1},{0,0}};
//        System.out.print(uniquePaths(3,7));
  //      System.out.println(uniquePathsWithObstacles(nums));
        System.out.println(integerBreak(5));
    }

    /**
     * 不同路径
     * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     * 问总共有多少条不同的路径？
     * 思路：动态规划
     * dp数组的定义 dp[i][j]表示从（0，0）出发到（i，j）有dp[i][j]条路
     * 确定递推公式 求dp[i][j]，只有两个方向推出来，要么dp[i-1][j],dp[i][j-1]
     * 初始化 dp[i,0]是1 （因为[0,0]到[i,0]只有1条路能走，同理dp[0,j]是1
     * 确定遍历顺序，左到右一层一层遍历
     * 距离推导dp
     *
     */
    public static int uniquePaths(int m, int n) {
//        if (m==0||n==0){
//            return 0;
//        }
//        因为题目：expected 'n' to have value from 1 to 100 only 所以不用判断0
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i]= 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 不同路径2
     * 一个机器人位于一个m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。
     * 链接：https://leetcode-cn.com/problems/unique-paths-ii
     *
     * 思路：动态规划 确定dp数组定义 dp[i][j]表示从0，0出发到i,j有dp[i][j]条路径
     * 确定递推公式： dp[i-1][j]+dp[i][j-1] ，当(i,j)没有障碍时再推导dp[i][j]
     * 初始化：这里与1不同，有障碍之后，障碍后面的位置都找不到了，障碍之后也应该是初始值0
     * 有障碍，对应DP数组的位置保持初始值为0
     *
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m =obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //dp数组定义
        //dp数组初始化
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0]==0){
                dp[i][0] = 1;
            }else {
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] ==0){
                dp[0][i] =1;
            }else {
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j]==1) continue;
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 整数拆分
     * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
     *
     * 返回 你可以获得的最大乘积 。
     * dp数组定义：dp[i]表示拆分数字i时乘积最大是多少
     * 递推式： dp[i]=max(dp[i-j]*j,(i-j)*j) 拆或者不拆  j表示要减的数（例如4，就要减 3，2，1）没有0，因为0就不能最大
     * 初始化： dp[2] = 1; 0 1都没法拆
     *
     */
    public static int integerBreak(int n) {
      int[] dp = new int[n+1];//为什么是i+1呢 如果不这样会漏掉最后一个 看来dp数组大小也很重要 +1是因为，这里面的i表示的是拆分的数字，所以要包含n
      dp[2]=1;
        for (int i = 3; i <= n; i++) { //从3开始，因为2是初始值了，这里要理清楚
            for (int j = 1; j < i-1; j++) {  //注意这里，j表示的是拆分的数字
                dp[i] = Math.max(dp[i], Math.max((i-j)*j,dp[i-j]*j)); //要么直接拆，要么拆完接着拆
            }
        }
        return dp[n];
    }
}
