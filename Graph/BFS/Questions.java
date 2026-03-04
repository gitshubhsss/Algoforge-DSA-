public class Questions {

  // Leetcode 1162 : https://leetcode.com/problems/as-far-from-land-as-possible/description/
  class Solution {

    public int maxDistance(int[][] grid) {
      int n = grid.length;
      int m = grid[0].length;

      int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

      LinkedList<Integer> que = new LinkedList<>();

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (grid[i][j] == 1) {
            que.addLast(i * m + j); // converted to 1d
          }
        }
      }

      if (que.size() == n * m || que.size() == 0) {
        return -1;
      }

      int dis = 0;

      while (que.size() > 0) {
        int size = que.size();

        while (size-- > 0) {
          int cell = que.removeFirst();

          int i = cell / m;
          int j = cell % m;

          for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 0) {
              que.addLast(x * m + y);
              grid[x][y] = 2;
            }
          }
        }
        dis++;
      }

      return dis - 1;
    }
  }

  //Leetcode : 542. 01 Matrix ========================================================

  class Solution {

    public int[][] updateMatrix(int[][] mat) {
      int n = mat.length;
      int m = mat[0].length;

      LinkedList<Integer> que = new LinkedList<>();

      ///making the result array
      int res[][] = new int[n][m];

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (mat[i][j] == 0) {
            que.addLast(i * m + j); // converted to 1d
          }
        }
      }

      int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

      int dis = 0;

      while (que.size() > 0) {
        int size = que.size();

        while (size-- > 0) {
          int cell = que.removeFirst();

          int i = cell / m;
          int j = cell % m;

          for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x >= 0 && y >= 0 && x < n && y < m && mat[x][y] == 1) {
              que.addLast(x * m + y);
              res[x][y] = dis + 1;
              mat[x][y] = 0;
            }
          }
        }

        dis++;
      }

      return res;
    }
  }

  //Leetcode :  1091. Shortest Path in Binary Matrix
  // Code pending
  public int shortestPathBinaryMatrix(int[][] grid) {}

  //Code lint wala bhi pending hai

  //

  public static void main(String[] args) {}
}
