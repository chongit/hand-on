package io.chone.algorithm.dp;

import static io.chone.algorithm.dp.UniquePaths.print;

public class UniquePathsII {

    public static void main(String[] args) {
        //new UniquePathsII().uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        //new UniquePathsII().uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        //new UniquePathsII().uniquePathsWithObstacles(new int[][]{{0,1},{0,0}});
        new UniquePathsII().uniquePathsWithObstacles(new int[][]{{1,0}});
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
//                if (obstacleGrid[i][j]==1){
//                    dp[i][j] = 0;
//                    continue;
//                }
                if ((i == 0 || j == 0)&&obstacleGrid[i][j] == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
                //dp[i][j] = Math.min(obstacleGrid[i - 1][j], dp[i - 1][j]) + Math.min(obstacleGrid[i][j - 1], dp[i][j - 1]);

            }
        }
        print(dp);
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
