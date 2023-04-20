package io.chone.algorithm.dp;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/unique-paths/
 */
public class UniquePaths {

    public static void main(String[] args) {
        new UniquePaths().uniquePaths(3, 7);
        new UniquePaths().uniquePaths(3, 2);
    }

    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        print(dp);
        return dp[m - 1][n - 1];
    }

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%5d ", arr[i][j]);
            }
            System.out.println();
        }
    }
}
