import java.util.*;

class Edge {

  int u;
  int v;
  int w;

  public Edge(int u, int v, int w) {
    this.u = u;
    this.v = v;
    this.w = w;
  }

  public String toString() {
    return "(" + this.u + " --> " + this.v + " : " + this.w + ")";
  }
}

public class Questions {

  public static void addEdge(int u, int v, int w, ArrayList<Edge> graph[]) {
    graph[u].add(new Edge(u, v, w));
    graph[v].add(new Edge(v, u, w));
  }

  public static void displayGraph(ArrayList<Edge> graph[], int N) {
    for (int i = 0; i < N; i++) {
      System.out.print("Edges coming out from " + i + " : ");
      for (Edge e : graph[i]) {
        System.out.print(e + ",");
      }
      System.out.println();
    }
  }

  /// 200. Number of Islands
  class Solution200 {

    public static void dfs_wooh(int row, int col, int n, int m, char[][] grid) {
      grid[row][col] = '2';

      int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

      for (int[] dir : dirs) {
        int nRow = row + dir[0];
        int nCol = col + dir[1];

        if (nRow >= 0 && nRow < n && nCol < m && nCol >= 0 && grid[nRow][nCol] == '1') {
          dfs_wooh(nRow, nCol, n, m, grid);
        }
      }
    }

    public int numIslands(char[][] grid) {

      int n = grid.length;

      int m = grid[0].length;

      int components = 0;

      for (int row = 0; row < n; row++) {
        for (int col = 0; col < m; col++) {
          if (grid[row][col] == '1') {
            dfs_wooh(row, col, n, m, grid);
            components++;
          }
        }
      }

      return components;
    }
  }

  // 695. Max Area of Island
  class Solution695 {

    // function to return no of ones
    public static int dfs_wooh(int row, int col, int n, int m, int[][] grid) {
      grid[row][col] = 2;

      int totalArea = 1;

      int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

      for (int[] dir : dirs) {

        int nRow = row + dir[0];
        int nCol = col + dir[1];

        if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1) {
          totalArea = totalArea + dfs_wooh(nRow, nCol, n, m, grid);
        }
      }

      return totalArea;

    }

    public int maxAreaOfIsland(int[][] grid) {

      int n = grid.length;
      int m = grid[0].length;

      int maxArea = 0;

      for (int row = 0; row < n; row++) {
        for (int col = 0; col < m; col++) {
          if (grid[row][col] == 1) {
            int area = dfs_wooh(row, col, n, m, grid);
            maxArea = Math.max(maxArea, area);
          }
        }
      }

      return maxArea;
    }
  }

  // 130. Surrounded Regions
  class Solution130 {

    public static void convertToHash(int row, int col, int n, int m, char[][] board) {
      board[row][col] = '#';

      int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

      for (int[] dir : dirs) {

        int nRow = row + dir[0];
        int nCol = col + dir[1];

        if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && board[nRow][nCol] == 'O') {
          convertToHash(nRow, nCol, n, m, board);
        }
      }
    }

    public void solve(char[][] board) {
      int n = board.length;
      int m = board[0].length;

      // convert the sider boundaries to #
      for (int row = 0; row < n; row++) {
        for (int col = 0; col < m; col++) {
          // skip the boundaries
          if (row == 0 || row == n - 1 || col == 0 || col == m - 1) {
            if (board[row][col] == 'O') {
              convertToHash(row, col, n, m, board);
            }
          }
        }
      }

      for (int row = 0; row < n; row++) {
        for (int col = 0; col < m; col++) {
          if (board[row][col] == 'O') {
            board[row][col] = 'X';
          } else if (board[row][col] == '#') {
            board[row][col] = 'O';
          }
        }
      }

    }
  }

  // 463. Island Perimeter
  class Solution463 {
    public int islandPerimeter(int[][] grid) {

      int n = grid.length;
      int m = grid[0].length;

      int totalPerimeter = 0;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {

          if (grid[i][j] == 1) {
            int initialPerimeter = 4;

            int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

            for (int[] dir : dirs) {
              int nRow = i + dir[0];
              int nCol = j + dir[1];
              if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1) {
                initialPerimeter--;
              }
            }

            totalPerimeter += initialPerimeter;
          }

        }

      }

      return totalPerimeter;
    }
  }

  // 547. Number of Provinces
  class Solution547 {

    public static void dfs_wooh(int src, ArrayList<Integer>[] graph, boolean[] vis) {

      vis[src] = true;

      for (int nbr : graph[src]) {
        if (vis[nbr] == false) {
          dfs_wooh(nbr, graph, vis);
        }
      }
    }

    public static void addEdge(int u, int v, ArrayList<Integer>[] graph) {
      graph[u].add(v);
      graph[v].add(u);
    }

    public int findCircleNum(int[][] isConnected) {

      int n = isConnected.length;
      int m = isConnected[0].length;

      int provience = 0;

      @SuppressWarnings("unchecked")
      ArrayList<Integer>[] graph = new ArrayList[n];

      for (int i = 0; i < n; i++) {
        graph[i] = new ArrayList<>();
      }

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (isConnected[i][j] == 1 && i != j) {
            addEdge(i, j, graph);
          }
        }
      }

      boolean[] vis = new boolean[n];

      for (int i = 0; i < n; i++) {
        if (vis[i] == false) {
          dfs_wooh(i, graph, vis);
          provience++;
        }
      }

      return provience;

    }
  }

  // 207. Course Schedule topological sort

  class Solution207 {

    public static void addEdge(int u, int v, ArrayList<Integer>[] graph) {
      graph[u].add(v);
    }

    public static boolean topo_dfs_isCycle(int src, ArrayList<Integer>[] graph, int[] vis) {
      vis[src] = 1;

      for (int nbr : graph[src]) {
        if (vis[nbr] == 1) {
          return true;// their is a cycle
        } else if (vis[nbr] == 0) {
          if (topo_dfs_isCycle(nbr, graph, vis)) {
            return true;
          }
        } else if (vis[nbr] == 2) {
          continue;
        }
      }

      vis[src] = 2;
      return false;
    }

    public static boolean topological_traverse(ArrayList<Integer>[] graph, int N) {
      int[] vis = new int[N];

      for (int i = 0; i < N; i++) {
        if (vis[i] == 0) {
          if (topo_dfs_isCycle(i, graph, vis)) {
            return false;
          }
        }
      }

      return true;

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
        addEdge(u, v, graph);
      }

      return topological_traverse(graph, N);
    }
  }

  // 210. Course Schedule II topological sort
  class Solution210 {

    public static void addEdge(int u, int v, ArrayList<Integer>[] graph) {
      graph[u].add(v);
    }

    public static boolean topo_dfs_isCycle(int src, ArrayList<Integer>[] graph, ArrayList<Integer> topologicalOrder,
        int[] vis) {
      vis[src] = 1;
      for (int nbr : graph[src]) {
        if (vis[nbr] == 1) {
          return true;// cycle found
        } else if (vis[nbr] == 0) {
          if (topo_dfs_isCycle(nbr, graph, topologicalOrder, vis)) {
            return true;
          }
        } else if (vis[nbr] == 2) {
          continue;
        }
      }
      vis[src] = 2;
      topologicalOrder.add(src);
      return false;
    }

    public static ArrayList<Integer> topo_traverse(ArrayList<Integer>[] graph, int N) {
      int[] vis = new int[N];

      ArrayList<Integer> topologicalOrder = new ArrayList<>();

      for (int i = 0; i < N; i++) {
        if (vis[i] == 0) {
          if (topo_dfs_isCycle(i, graph, topologicalOrder, vis)) {
            return new ArrayList<>();
          }
        }
      }

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

      if (order.isEmpty()) {
        return new int[] {};
      }

      // convert arrayList to array
      int[] ans = order.stream().mapToInt(Integer::intValue).toArray();

      return ans;

    }
  }

  // 802. Find Eventual Safe States

  class Solution802 {

    public static boolean topo_dfs(int src, int[][] graph, int[] vis) {
      vis[src] = 1;
      for (int nbr : graph[src]) {
        if (vis[nbr] == 1) {
          return true; // do not add it as its a cycle
        }
        if (vis[nbr] == 0) {
          if (topo_dfs(nbr, graph, vis)) {
            return true;
          }
        } else if (vis[nbr] == 2) {

          continue;
        }
      }
      vis[src] = 2;
      return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

      int N = graph.length;
      int[] vis = new int[N];

      ArrayList<Integer> safeNodes = new ArrayList<Integer>();

      for (int i = 0; i < N; i++) {
        if (vis[i] == 0) {
          topo_dfs(i, graph, vis);
        }
      }

      for (int i = 0; i < N; i++) {
        if (vis[i] == 2) {
          safeNodes.add(i);
        }
      }

      return safeNodes;

    }
  }

  // Leetcode : 1905. Count Sub Islands Pending
  class Solution1905 {

    public static boolean isSubIsland(int i, int j, int[][] A, int[][] B, int n, int m) {

      boolean isSubIsaland = false;

      if (A[i][j] == 0) {
        isSubIsaland = false;
      }
      int dirs[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

      for (int[] dir : dirs) {
        int x = i + dir[0];
        int y = j + dir[1];

        if (x >= 0 && x < n && y >= 0 && y < m && B[x][y] == 1) {
          isSubIsaland = isSubIsland(x, y, A, B, n, m) && isSubIsaland;
        }
      }

      return isSubIsaland;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {

      int n = grid1.length;
      int m = grid1[0].length;

      int count = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (isSubIsland(i, j, grid1, grid2, n, m)) {
            count++;
          }
        }
      }

      return count;
    }
  }

  // count distict islands
  // (https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1)

  class Solution {

    public static void dfs_fillshape(int i, int j, int sr, int sc, int n, int m, ArrayList<String> shape,
        int[][] grid) {
      grid[i][j] = 0;
      shape.add("(" + (sr - i) + "," + (sc - j) + ")");
      int dirs[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

      for (int[] dir : dirs) {
        int x = i + dir[0];
        int y = j + dir[1];
        if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1) {
          dfs_fillshape(x, y, sr, sc, n, m, shape, grid);
        }
      }
    }

    int countDistinctIslands(int[][] grid) {
      // Your Code here

      int n = grid.length;
      int m = grid[0].length;
      HashSet<ArrayList<String>> set = new HashSet<>();

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (grid[i][j] == 1) {
            ArrayList<String> shape = new ArrayList<>();
            dfs_fillshape(i, j, i, j, n, m, shape, grid);
            set.add(shape);
          }
        }
      }

      return set.size();

    }
  }

  public static void main(String[] args) {
    int N = 8;

    int arr[] = new int[N];

    @SuppressWarnings("unchecked")
    ArrayList<Edge> graph[] = new ArrayList[N]; // where ArrayList<Edge> is a data type ,graph is variable name,

    // initailize the arrayList

    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    addEdge(0, 1, 0, graph);
    addEdge(0, 2, 0, graph);
    addEdge(1, 3, 0, graph);
    addEdge(2, 3, 0, graph);
    addEdge(2, 4, 0, graph);
    // addEdge(4, 5, 0, graph);
    addEdge(3, 5, 0, graph);
    addEdge(5, 7, 0, graph);
    addEdge(4, 6, 0, graph);
    addEdge(6, 7, 0, graph);

    displayGraph(graph, N);

  }

}
