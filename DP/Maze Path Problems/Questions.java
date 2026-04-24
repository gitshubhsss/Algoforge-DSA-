public class Questions {

    public static int getTotalMazePath_rec(int row, int col, int n, int m) {

        if (row == n - 1 && col == m - 1) {
            return 1;
        }

        int totalWays = 0;

        if (col + 1 < m)
            totalWays += getTotalMazePath_rec(row, col + 1, n, m);
        if (row + 1 < n)
            totalWays += getTotalMazePath_rec(row + 1, col, n, m);
        if (row + 1 < n && col + 1 < m)
            totalWays += getTotalMazePath_rec(row + 1, col + 1, n, m);

        return totalWays;

    }

    public static int getTotalMazePath_memo(int row, int col, int n, int m, int[][] dp) {

        if (row > n || col > m) {
            return 0;
        }

        if (row == n - 1 && col == m - 1) {
            return dp[row][col] = 1;
        }

        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int totalWays = 0;

        if (col + 1 < m)
            totalWays += getTotalMazePath_memo(row, col + 1, n, m, dp);
        if (row + 1 < n)
            totalWays += getTotalMazePath_memo(row + 1, col, n, m, dp);
        if (row + 1 < n && col + 1 < m)
            totalWays += getTotalMazePath_memo(row + 1, col + 1, n, m, dp);

        return dp[row][col] = totalWays;

    }

    public static int getTotalMazePath_tab(int n, int m, int[][] dp) {
        for (int row = n - 1; row >= 0; row--) {
            for (int col = m - 1; col >= 0; col--) {

                if (row == n - 1 && col == m - 1) {
                    dp[row][col] = 1;
                    continue;
                }

                int totalWays = 0;

                if (col + 1 < m)
                    totalWays += dp[row][col + 1];
                if (row + 1 < n)
                    totalWays += dp[row + 1][col];
                if (row + 1 < n && col + 1 < m)
                    totalWays += dp[row + 1][col + 1];

                dp[row][col] = totalWays;
            }
        }

        return dp[0][0];
    }

    public static int getTotalMazePath(int row, int col, int n, int m) {

        // return getTotalMazePath_rec(0, 0, n, m);

        int[][] dp = new int[n][m];
        // getTotalMazePath_memo(0, 0, n, m, dp);
        getTotalMazePath_tab(n, m, dp);

        return dp[0][0];

    }

    // Get all maze paths with jumps allowed

    public static int totalMazePathWithJumps_rec(int row, int col, int dr, int dc) {

        if (row > dr || col > dc) {
            return 0;
        }
        if (row == dr && col == dc) {
            return 1;
        }

        int totalWays = 0;

        // Horizontal jumps
        for (int jump = 1; jump <= dr - row; jump++) {
            totalWays += totalMazePathWithJumps_rec(row + jump, col, dr, dc);
        }

        // vertical jumps
        for (int jump = 1; jump <= dc - col; jump++) {
            totalWays += totalMazePathWithJumps_rec(row, col + jump, dr, dc);
        }

        for (int jump = 1; jump <= Math.min(dc - col, dr - row); jump++) {
            totalWays += totalMazePathWithJumps_rec(row + jump, col + jump, dr, dc);
        }

        return totalWays;
    }

    public static int totalMazePathWithJumps_memo(int row, int col, int dr, int dc, int[][] dp) {

        if (row > dr || col > dc) {
            return 0;
        }

        if (row == dr && col == dc) {
            return dp[row][col] = 1;
        }

        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int totalWays = 0;

        // Horizontal jumps
        for (int jump = 1; jump <= dr - row; jump++) {
            totalWays += totalMazePathWithJumps_memo(row + jump, col, dr, dc, dp);
        }

        // vertical jumps
        for (int jump = 1; jump <= dc - col; jump++) {
            totalWays += totalMazePathWithJumps_memo(row, col + jump, dr, dc, dp);
        }

        for (int jump = 1; jump <= Math.min(dc - col, dr - row); jump++) {
            totalWays += totalMazePathWithJumps_memo(row + jump, col + jump, dr, dc, dp);
        }

        return dp[row][col] = totalWays;
    }

    public static int totalMazePathWithJumps_tab(int n, int m, int[][] dp) {

        for (int row = n - 1; row >= 0; row--) {
            for (int col = m - 1; col >= 0; col--) {

                if (row == n - 1 && col == m - 1) {
                    dp[row][col] = 1;
                    continue;
                }

                int totalWays = 0;

                // Horizontal jumps
                for (int jump = 1; jump < n - row; jump++) {
                    totalWays += dp[row + jump][col];
                }

                // vertical jumps
                for (int jump = 1; jump < m - col; jump++) {
                    totalWays += dp[row][col + jump];
                }

                for (int jump = 1; jump < Math.min(m - col, n - row); jump++) {
                    totalWays += dp[row + jump][col + jump];
                }

                dp[row][col] = totalWays;
            }
        }

        return dp[0][0];
    }

    public static int totalMazePathWithJumps(int n, int m) {

        int dr = n - 1;
        int dc = m - 1;

        int[][] dp = new int[n][m];

        // return totalMazePathWithJumps_rec(0, 0, dr, dc);
        // totalMazePathWithJumps_memo(0, 0, dr, dc, dp);
        return totalMazePathWithJumps_tab(n, m, dp);

    }

    // Leetcode : 64 https://leetcode.com/problems/minimum-path-sum/
    public static int minPathSum_rec(int row, int col, int n, int m, int[][] grid) {

        if (row < 0 || row >= n || col < 0 || col >= m) {
            return Integer.MAX_VALUE;
        }

        if (row == n - 1 && col == m - 1) {
            return grid[row][col];
        }

        int diagonalPath = minPathSum_rec(row, col + 1, n, m, grid);

        int verticalPath = minPathSum_rec(row + 1, col, n, m, grid);

        return grid[row][col] + Math.min(diagonalPath, verticalPath);

    }

    public static int minPathSum_memo(int row, int col, int n, int m, int[][] grid, int[][] dp) {

        if (row < 0 || row >= n || col < 0 || col >= m) {
            return Integer.MAX_VALUE;
        }

        if (row == n - 1 && col == m - 1) {
            return dp[row][col] = grid[row][col];
        }

        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int diagonalPath = minPathSum_memo(row, col + 1, n, m, grid, dp);

        int verticalPath = minPathSum_memo(row + 1, col, n, m, grid, dp);

        return dp[row][col] = grid[row][col] + Math.min(diagonalPath, verticalPath);

    }

    public static int minPathSum_tab(int n, int m, int[][] grid, int[][] dp) {

        for (int row = n - 1; row >= 0; row--) {
            for (int col = m - 1; col >= 0; col--) {

                if (row == n - 1 && col == m - 1) {
                    dp[row][col] = grid[row][col];
                    continue;
                }

                int minPath = Integer.MAX_VALUE;

                if (col + 1 < m) {
                    minPath = Math.min(minPath, dp[row][col + 1]);
                }

                if (row + 1 < n) {
                    minPath = Math.min(minPath, dp[row + 1][col]); // minPathSum_memo(row + 1, col, n, m, grid, dp);)
                }

                dp[row][col] = minPath + grid[row][col];
            }
        }

        return dp[0][0];

    }

    public static int minPathSum(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        // return minPathSum_rec(0, 0, n, m, grid);

        minPathSum_memo(0, 0, n, m, grid, dp);
        return dp[0][0];
    }

    // https://www.geeksforgeeks.org/problems/gold-mine-problem2608/1
    public static int maxGold_rec(int row, int col, int n, int m, int[][] mat) {

        if (col == m - 1) {
            return mat[row][col];
        }

        int maxGold = 0;

        if (row - 1 >= 0 && col + 1 < m) {
            maxGold = Math.max(maxGold, maxGold_rec(row - 1, col + 1, n, m, mat));
        }

        if (col + 1 < m) {
            maxGold = Math.max(maxGold, maxGold_rec(row, col + 1, n, m, mat));
        }

        if (row + 1 < n && col + 1 < m) {
            maxGold = Math.max(maxGold, maxGold_rec(row + 1, col + 1, n, m, mat));
        }

        return mat[row][col] + maxGold;

    }

    public static int maxGold_memo(int row, int col, int n, int m, int[][] mat, int[][] dp) {

        if (col == m - 1) {
            return dp[row][col] = mat[row][col];
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int maxGold = 0;

        if (row - 1 >= 0 && col + 1 < m) {
            maxGold = Math.max(maxGold, maxGold_memo(row - 1, col + 1, n, m, mat, dp));
        }

        if (col + 1 < m) {
            maxGold = Math.max(maxGold, maxGold_memo(row, col + 1, n, m, mat, dp));
        }

        if (row + 1 < n && col + 1 < m) {
            maxGold = Math.max(maxGold, maxGold_memo(row + 1, col + 1, n, m, mat, dp));
        }

        return dp[row][col] = mat[row][col] + maxGold;

    }

    public static int maxGold_tab(int n, int m, int[][] mat) {

        int[][] dp = new int[n][m];
        for (int col = m - 1; col >= 0; col--) {
            for (int row = 0; row < n; row++) {

                if (col == m - 1) {
                    dp[row][col] = mat[row][col];
                    continue;
                }

                int maxGold = 0;

                if (row - 1 >= 0 && col + 1 < m) {
                    maxGold = Math.max(maxGold, dp[row - 1][col + 1]);// maxGold_memo(row - 1, col + 1, n, m, mat, dp));
                }

                if (col + 1 < m) {
                    maxGold = Math.max(maxGold, dp[row][col + 1]);// maxGold_memo(row, col + 1, n, m, mat, dp));
                }

                if (row + 1 < n && col + 1 < m) {
                    maxGold = Math.max(maxGold, dp[row + 1][col + 1]);// maxGold_memo(row + 1, col + 1, n, m, mat, dp));
                }

                dp[row][col] = mat[row][col] + maxGold;
            }
        }

        int maxPossibleGold = 0;

        for (int row = 0; row < n; row++) {
            maxPossibleGold = Math.max(maxPossibleGold, dp[row][0]);
        }

        return maxPossibleGold;

    }

    public static void main(String[] args) {

        int n = 2;
        int m = 3;

        System.out.println(totalMazePathWithJumps(n, m));
    }
}