public class Questions {

  // Leetcode : 994. Rotting Oranges
  class Solution {

    public int orangesRotting(int[][] grid) {
      int n = grid.length;
      int m = grid[0].length;

      LinkedList<Integer> que = new LinkedList<>();

      int freshOranges = 0;

      for (int row = 0; row < n; row++) {
        for (int col = 0; col < m; col++) {
          if (grid[row][col] == 1) {
            freshOranges++;
          } else if (grid[row][col] == 2) {
            que.add(row * m + col); //converted to 1d array
          }
        }
      }

      if (freshOranges == 0) {
        return 0;
      }

      int time = 0;

      int dirs[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
      while (que.size() > 0) {
        int size = que.size();
        while (size-- > 0) {
          int cell = que.removeFirst();

          int row = cell / m;
          int col = cell % m;

          //move in all 4 directions

          for (int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];

            if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1) {
              que.addLast(x * m + y); //converting to one d
              grid[x][y] = 2;
              freshOranges--;
            }
          }
        }

        time++;
      }
      return freshOranges == 0 ? time - 1 : -1;
    }
  }

  // Leetcode 1162 : https://leetcode.com/problems/as-far-from-land-as-possible/description/
  class Solution {

    public int maxDistance(int[][] grid) {
      int n = grid.length;
      int m = grid[0].length;

      LinkedList<Integer> que = new LinkedList<>();

      for (int row = 0; row < n; row++) {
        for (int col = 0; col < m; col++) {
          if (grid[row][col] == 1) {
            //convert to 1 d array and insert in the que
            que.add(row * m + col);
          }
        }
      }

      if ((que.size() == 0) || (que.size() == m * n)) {
        return -1;
      }

      int dirs[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

      int dis = 0;

      while (que.size() > 0) {
        int size = que.size();

        while (size-- > 0) {
          int cell = que.removeFirst();

          int row = cell / m;
          int col = cell % m;

          for (int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];

            if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 0) {
              que.add(x * m + y);
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

  // Leetcode : 329. Longest Increasing Path in a Matrix
//incomplete code
 class Solution {
    public int longestIncreasingPath(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int indegree[][] = new int[n][m];

        int dirs[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int smallerNbrElements = 0;

                for (int dir[] : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];

                    if (x < n && x >= 0 && y < m && y > n && matrix[i][j] > matrix[x][y]) {
                        smallerNbrElements++;
                    }
                }

                indegree[i][j] = smallerNbrElements;
                if (smallerNbrElements == 0) {
                    que.add(i * m + j);
                }
            }
        }

        int length=1;

        while(que.size()>0){
            int size=que.size();
            while(size -->0){

                int cell=que.removeFirst();
                int i=cell/m;
                int j=cell%m;

                  for (int dir[] : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];

                    if (x < n && x >= 0 && y < m && y > n && matrix[i][j] > matrix[x][y]) {
                       
                       indegree[x][y]--;
                       if(indegree[x][y]==0){
                        que.
                       }
                    }
                }



            }
        }
    }
}


///

  public static void main(String[] args) {}
}
