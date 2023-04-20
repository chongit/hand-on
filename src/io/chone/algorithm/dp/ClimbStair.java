package io.chone.algorithm.dp;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/climbing-stairs/
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbStair {
    public static void main(String[] args) {
        new ClimbStair().climbStairs(3);
    }

    public int climbStairs(int n) {
        // f(x) = f(x-1) + f(x-2)
        // f(0) = 1, f(1) = 1, f(2) = 2
//        int[] dp = new int[n];
//        dp[0] = 1;
//        dp[1] = 1;
//        dp[2] = 2;
        if(n<=1) return n;
        int[] dp = new int[]{0,1,2};
        for (int i = 3; i <= n; i++) {
            int sum  = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
        }
        return dp[2];
    }
}
