package io.chone.algorithm.dp;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/min-cost-climbing-stairs/
 */
public class ClimbStairMinCost {

    public static void main(String[] args) {
        System.out.println(new ClimbStairMinCost()
                .minCostClimbingStairsInplace(new int[]{1,100}));
    }

    public int minCostClimbingStairs(int[] cost) {
        //f(x) = min{f(x-1),f(x-2)}
        //f(0) = cost[0]
        //f(1) = min{cost[1],cost[0]}
//        if (cost.length == 0) {
//            return 0;
//        }
//        if (cost.length == 1) {
//            return cost[0];
//        }
        int dp[] = new int[cost.length];
        //第一个台阶直接跨过去
        dp[0] = 0;
        dp[1] = Math.min(cost[0], cost[1]);
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i - 1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[2];
    }

    public int minCostClimbingStairsSpace(int[] cost) {
        //f(x) = min{f(x-1),f(x-2)}
        //f(0) = cost[0]
        //f(1) = min{cost[1],cost[0]}
        int dp[] = new int[3];
        //"你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。"
        // 也就是说 从 到达 第 0 个台阶是不花费的，但从 第0 个台阶 往上跳的话，需要花费 cost[0]
        dp[0] = 0;
        dp[1] = 0 ;
        //dp[2] = dp[1];
        for (int i = 2; i <= cost.length; i++) {
            dp[2] = Math.min(dp[1] + cost[i-1], dp[0] + cost[i - 2]);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        System.out.println(Arrays.toString(dp));
        return dp[2];
    }

    public int minCostClimbingStairsInplace(int[] cost) {
        //f(x) = min{f(x-1),f(x-2)}
        //f(0) = cost[0]
        //f(1) = min{cost[1],cost[0]}
        int dp[] = new int[3];
        //"你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。"
        // 也就是说 从 到达 第 0 个台阶是不花费的，但从 第0 个台阶 往上跳的话，需要花费 cost[0]
        for (int i = 2; i < cost.length; i++) {
            cost[i] = Math.min(cost[i-1],cost[i-2])+cost[i];
        }
        return Math.min(cost[cost.length-1],cost[cost.length-2]);
    }


    public int minCostClimbingStairs1(int[] cost) {
        int size = cost.length;
        int[] minCost = new int[size];
        minCost[0] = 0;
        minCost[1] = Math.min(cost[0], cost[1]);
        for (int i = 2; i < size; i++) {
            minCost[i] = Math.min(minCost[i - 1] + cost[i], minCost[i - 2] + cost[i - 1]);
        }
        return minCost[size - 1];
    }
}
