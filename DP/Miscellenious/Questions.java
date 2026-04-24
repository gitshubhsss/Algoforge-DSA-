package DP.Miscellenious;

import java.util.Arrays;

public class Questions {

    // Leetcode 198. House Robber
    class Solution198 {

        public int rob(int[] nums) {

            int n = nums.length;
            int[] inc = new int[n];
            int[] exe = new int[n];

            inc[0] = nums[0];
            exe[0] = 0;

            for (int i = 1; i < n; i++) {

                inc[i] = nums[i] + exe[i - 1];
                exe[i] = Math.max(inc[i - 1], exe[i - 1]);

            }

            return Math.max(inc[n - 1], exe[n - 1]);
        }

        /// O(1) spacce

        public int rob2(int[] nums) {

            int n = nums.length;
            int inc = nums[0];
            int exe = 0;

            for (int i = 1; i < n; i++) {

                int prev = inc;

                inc = nums[i] + exe;

                exe = Math.max(prev, exe);

            }

            return Math.max(exe, inc);
        }

    }

    /// Leetcode 213. House Robber II;
    class Solution213 {

        public int maxRobHouse(int[] nums, int si, int ei) {

            if (si >= nums.length) {
                return 0;
            }
            int n = nums.length;
            int inc = nums[0];
            int exe = 0;

            for (int i = si + 1; i <= ei; i++) {

                int prev = inc;

                inc = nums[i] + exe;

                exe = Math.max(prev, exe);

            }

            return Math.max(exe, inc);
        }

        public int rob(int[] nums) {
            int n = nums.length;
            int includding0 = maxRobHouse(nums, 0, n - 2);
            int excluding0 = maxRobHouse(nums, 1, n - 1);

            return Math.max(includding0, excluding0);
        }

    }

    // 1277. Count Square Submatrices with All Ones

    class Solution1277 {
        public int countSquares(int[][] matrix) {

            int n = matrix.length;
            int m = matrix[0].length;

            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    if (i >= 1 && j >= 1 && matrix[i][j] == 1) {
                        int squareLength = Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]);
                        matrix[i][j] = squareLength + 1;
                    }
                    count += matrix[i][j];

                }
            }

            return count;
        }
    }

    // 221. Maximal Square
    class Solution221 {
        public int maximalSquare(char[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;

            int[][] dp = new int[n][m];

            int maxLength = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dp[i][j] = matrix[i][j] - '0';
                    if (i >= 1 && j >= 1 && dp[i][j] == 1) {
                        int squareLength = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                        dp[i][j] = squareLength + 1;
                    }

                    maxLength = Math.max(dp[i][j] * dp[i][j], maxLength);// since we are finding the square

                }
            }

            return maxLength;
        }
    }

    // 1504. Count Submatrices With All Ones
    class Solution1504 {
        public int numSubmat(int[][] mat) {
            int n = mat.length;
            int m = mat[0].length;

            int[] height = new int[m];

            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (mat[i][j] == 0) {
                        height[j] = 0;
                        continue;
                    }
                    height[j]++;

                    int minHeight = n;

                    for (int k = j; k >= 0; k--) {
                        minHeight = Math.min(height[k], minHeight);
                        count += minHeight;
                    }
                }
            }

            return count;
        }
    }

    // 1463. Cherry Pickup II
    class Solution1463 {

        public int cherryPickup_memo(int row, int c1, int c2, int[][] grid, int n, int m, int[][][] dp) {

            int currentCherries = 0;
            if (c1 == c2) {
                currentCherries = grid[row][c1];
            } else {
                currentCherries = grid[row][c1] + grid[row][c2];
            }

            int nextCherries = 0;
            for (int nextC1 = c1 - 1; nextC1 <= c1 + 1; nextC1++) {
                for (int nextC2 = c2 - 1; nextC2 <= c2 + 1; nextC2++) {
                    if (row + 1 < n && nextC1 >= 0 && nextC2 >= 0 && nextC1 < m && nextC2 < m) {
                        nextCherries = Math.max(nextCherries,
                                cherryPickup_memo(row + 1, nextC1, nextC2, grid, n, m, dp));
                    }
                }

            }
            return dp[row][c1][c2] = currentCherries + nextCherries;

        }

        public int cherryPickup(int[][] grid) {

            int n = grid.length;
            int m = grid[0].length;

            int[][][] dp = new int[n][m][m];

            for (int[][] a : dp) {
                for (int[] b : a) {
                    Arrays.fill(b, -1);
                }
            }

            return -1;
        }

    }

    
}
