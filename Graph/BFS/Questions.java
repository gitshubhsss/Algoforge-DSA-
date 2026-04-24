import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Questions {

  // Leetcode : 994. Rotting Oranges BFS With direction
  class Solution994 {

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
            que.add(row * m + col); // converted to 1d array
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

          // move in all 4 directions

          for (int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];

            if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1) {
              que.addLast(x * m + y); // converting to one d
              grid[x][y] = 2;
              freshOranges--;
            }
          }
        }

        time++;
      }
      return freshOranges == 0 ? time - 1 : -1;// look at the example to you will get to know
    }
  }

  // Leetcode 1162. As Far from Land as Possible
  class Solution1162 {

    public int maxDistance(int[][] grid) {
      int n = grid.length;
      int m = grid[0].length;

      LinkedList<Integer> que = new LinkedList<>();

      for (int row = 0; row < n; row++) {
        for (int col = 0; col < m; col++) {
          if (grid[row][col] == 1) {
            // convert to 1 d array and insert in the que
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

  // Leetcode : 542. 01 Matrix
  class Solution542 {

    public int[][] updateMatrix(int[][] mat) {
      int n = mat.length;
      int m = mat[0].length;

      LinkedList<Integer> que = new LinkedList<>();

      /// making the result array
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

  // Leetcode : 1091. Shortest Path in Binary Matrix bfs
  class Solution1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {

      int n = grid.length;
      int m = grid[0].length;

      // source and destination par 1 hai to -1 return karo
      if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
        return -1;
      }

      LinkedList<Integer> que = new LinkedList<>();
      que.add(0);
      grid[0][0] = 1;

      int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 }, { -1, -1 } };
      int dis = 1;
      while (que.size() > 0) {

        int size = que.size();

        while (size-- > 0) {
          int cell = que.removeFirst();
          int row = cell / n;
          int col = cell % n;

          if (row == n - 1 && col == n - 1)
            return dis;

          for (int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];

            if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0) {
              grid[x][y] = 2;
              que.add(x * n + y);

              if (x == n - 1 && y == n - 1) {
                return dis + 1;
              } // destination reached

            }
          }
        }
        dis++;

      }
      return -1;

    }
  }

  // 934. Shortest Bridge dfs+bfs
  class Solution934 {

    public static void dfs_wooh(int row, int col, int n, int m, int[][] grid) {
      grid[row][col] = 2;
      int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

      for (int[] dir : dirs) {
        int nRow = row + dir[0];
        int nCol = col + dir[1];

        if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1) {
          dfs_wooh(nRow, nCol, n, m, grid);
        }
      }

    }

    public int shortestBridge(int[][] grid) {
      int n = grid.length;
      int m = grid[0].length;

      LinkedList<Integer> que = new LinkedList<>();

      int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

      boolean isFound = false;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (grid[i][j] == 1) {
            isFound = true;
            dfs_wooh(i, j, n, m, grid);
            break;
          }
        }
        if (isFound) {
          break;
        }
      }

      // insert the fist island in the que
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (grid[i][j] == 2) {
            que.add(i * m + j);
          }
        }
      }

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

            if (x >= 0 && x < n && y >= 0 && y < m) {

              if (grid[x][y] == 1) {
                return dis;// reach to the first point of the second island
              }

              if (grid[x][y] == 0) {
                que.add(x * m + y);
                grid[x][y] = 2;
              }

            }
          }

        }
        dis++;
      }
      return dis - 1;
    }
  }

  // Leetcode : 329. Longest Increasing Path in a Matrix
  class Solution329 {
    public int longestIncreasingPath(int[][] matrix) {

      int n = matrix.length;
      int m = matrix[0].length;

      LinkedList<Integer> que = new LinkedList<>();

      int indegree[][] = new int[n][m];

      int dirs[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          int smallerNbrElements = 0;

          for (int dir[] : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x < n && x >= 0 && y >= 0 && y < m && matrix[i][j] > matrix[x][y]) {
              smallerNbrElements++;
            }
          }

          indegree[i][j] = smallerNbrElements;
          if (smallerNbrElements == 0) {
            que.add(i * m + j);
          }
        }
      }

      int length = 1;

      while (que.size() > 0) {
        int size = que.size();
        while (size-- > 0) {

          int cell = que.removeFirst();
          int i = cell / m;
          int j = cell % m;

          for (int dir[] : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x < n && x >= 0 && y >= 0 && y < m && matrix[i][j] < matrix[x][y]) {
              indegree[x][y]--;
              if (indegree[x][y] == 0) {
                que.add(x * m + y);
              }
            }
          }

        }
        length++;
      }
      return length - 1;
    }
  }

  // Leetcode : 207. Course Schedule Using kahnsAlgorithm topological sort
  class Solution207 {

    public static boolean topological_traverse_using_kahns(ArrayList<Integer>[] graph, int N) {

      int[] indegree = new int[N];

      for (int u = 0; u < N; u++) {
        for (int v : graph[u]) {
          indegree[v]++;
        }
      }

      ArrayList<Integer> topologicalOrder = new ArrayList<Integer>();

      LinkedList<Integer> que = new LinkedList<Integer>();

      for (int i = 0; i < N; i++) {
        if (indegree[i] == 0) {
          que.add(i);
        }
      }

      while (que.size() > 0) {

        int size = que.size();

        while (size-- > 0) {
          int v = que.removeFirst();
          topologicalOrder.add(v);

          for (int ver : graph[v]) {
            indegree[ver]--;
            if (indegree[ver] == 0) {
              que.add(ver);
            }
          }
        }

      }

      return topologicalOrder.size() != N ? false : true;

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

      int N = numCourses;

      // make the graph
      ArrayList<Integer>[] graph = new ArrayList[N];

      for (int i = 0; i < N; i++) {
        graph[i] = new ArrayList<>();
      }

      for (int[] edge : prerequisites) {
        int u = edge[0];
        int v = edge[1];
        graph[u].add(v);
      }

      return topological_traverse_using_kahns(graph, N);
    }
  }

  // 210. Course Schedule II USING Kahns algorithm
  class Solution210 {

    public static void addEdge(int u, int v, ArrayList<Integer>[] graph) {
      graph[u].add(v);
    }

    public static ArrayList<Integer> topo_traverse(ArrayList<Integer>[] graph, int N) {

      int[] indegree = new int[N];

      ArrayList<Integer> topologicalOrder = new ArrayList<Integer>();
      LinkedList<Integer> que = new LinkedList<>();

      for (int u = 0; u < N; u++) {
        for (int v : graph[u]) {
          indegree[v]++;
        }
      }

      for (int i = 0; i < N; i++) {
        if (indegree[i] == 0) {
          que.add(i);
        }
      }

      while (que.size() > 0) {
        int vtx = que.removeFirst();
        topologicalOrder.add(vtx);

        for (int v : graph[vtx]) {
          indegree[v]--;
          if (indegree[v] == 0) {
            que.add(v);
          }
        }
      }
      Collections.reverse(topologicalOrder);

      return topologicalOrder;

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
      int N = numCourses;
      // base case jaisa bola gaya hai waisa
      if (prerequisites.length == 0 && N == 1) {
        return new int[] { 0 };
      }

      // prepare for the graph
      ArrayList<Integer>[] graph = new ArrayList[N];

      for (int i = 0; i < N; i++) {
        graph[i] = new ArrayList<>();
      }

      for (int[] edge : prerequisites) {
        int u = edge[0];
        int v = edge[1];
        addEdge(u, v, graph);
      }

      ArrayList<Integer> order = topo_traverse(graph, N);

      if (order.isEmpty() || order.size() != N) {
        return new int[] {};
      }

      // convert arrayList to array

      int[] ans = order.stream().mapToInt(Integer::intValue).toArray();

      return ans;

    }
  }

  public static void main(String[] args) {
  }
}
