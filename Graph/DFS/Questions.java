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

  // Connected Components in an Undirected Graph  https://www.geeksforgeeks.org/problems/connected-components-in-an-undirected-graph/1
  class Solution {

    public static void addEdge(int u, int v, ArrayList<Integer>[] graph) {
      graph[u].add(v);
      graph[v].add(u);
    }

    public static ArrayList<Integer>[] makeGraph(int V, int[][] edges) {
      @SuppressWarnings("unchecked")
      ArrayList<Integer> graph[] = new ArrayList[V];

      //initialize the graph
      for (int i = 0; i < V; i++) {
        graph[i] = new ArrayList<>();
      }

      for (int[] edge : edges) {
        int u = edge[0];
        int v = edge[1];

        addEdge(u, v, graph);
      }
      return graph;
    }

    public static void dfs(
      int src,
      ArrayList<Integer>[] graph,
      boolean[] vis,
      ArrayList<Integer> currComponents
    ) {
      vis[src] = true;

      currComponents.add(src);

      for (int nbr : graph[src]) {
        if (vis[nbr] == false) {
          dfs(nbr, graph, vis, currComponents);
        }
      }
    }

    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
      ArrayList<Integer> graph[] = makeGraph(V, edges);

      boolean vis[] = new boolean[V];

      ArrayList<ArrayList<Integer>> allComponents = new ArrayList<>();

      for (int i = 0; i < V; i++) {
        if (vis[i] == false) {
          ArrayList<Integer> currComponent = new ArrayList<>();
          dfs(i, graph, vis, currComponent);
          allComponents.add(currComponent);
        }
      }

      return allComponents;
    }
  }

  public static void addEdge(int u, int v, int w, ArrayList<Edge>[] graph) {
    graph[u].add(new Edge(u, v, w));
    graph[v].add(new Edge(v, u, w));
  }

  public static void displayGraph(ArrayList<Edge>[] graph) {
    for (int i = 0; i < graph.length; i++) {
      System.out.print(i + " ");
      ArrayList<Edge> edges = graph[i];

      for (Edge edge : edges) {
        System.out.print(edge + ",");
      }
      System.out.println();
    }
  }

  public static boolean checkIfEdge(int src, int des, ArrayList<Edge>[] graph) {
    for (Edge e : graph[src]) {
      int nbr = e.v;
      if (nbr == des) {
        return true;
      }
    }

    return false;
  }

  public static void traverseDFS(
    int src,
    int osrc,
    int edgesVisited,
    ArrayList<Edge>[] graph,
    int N,
    boolean vis[],
    String psf
  ) {
    if (edgesVisited == N - 1) {
      //we have visited all the nodes
      if (checkIfEdge(osrc, src, graph)) {
        System.out.println("Hamiltonian cycle is " + psf);
      } else {
        System.out.println("Hamiltonian path is " + psf);
      }
    }

    vis[src] = true;

    for (Edge e : graph[src]) {
      int nbr = e.v;
      if (vis[nbr] == false) {
        traverseDFS(
          nbr,
          osrc,
          edgesVisited + 1,
          graph,
          N,
          vis,
          psf + "->" + nbr
        );
      }
    }

    vis[src] = false;
  }

  public static void printAllHamiltonianPathAndCycle(
    int src,
    ArrayList<Edge>[] graph,
    int N
  ) {
    boolean vis[] = new boolean[N];

    //passing the original sourch also,edgesVisited=0
    traverseDFS(src, src, 0, graph, N, vis, "" + src);
  }

  /*
  
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]

  */
  class Solution {

    public static void dfs(
      int row,
      int col,
      int n,
      int m,
      boolean vis[][],
      char[][] grid
    ) {
      if (row > grid.length || col > grid[0].length) {
        return;
      }

      vis[row][col] = true;
      //this are the 4 directions we are going to have
      int dirs[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

      for (int dir[] : dirs) {
        int newR = row + dir[0];
        int newC = col + dir[1];
        if (
          newR >= 0 &&
          newC >= 0 &&
          newR < n &&
          newC < m &&
          grid[newR][newC] == '1' &&
          vis[newR][newC] == false
        ) {
          dfs(newR, newC, n, m, vis, grid);
        }
      }
    }

    public int numIslands(char[][] grid) {
      int n = grid.length;
      int m = grid[0].length;

      boolean vis[][] = new boolean[n][m];

      int components = 0;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (grid[i][j] == '1' && vis[i][j] == false) {
            dfs(i, j, n, m, vis, grid);
            components++;
          }
        }
      }

      return components;
    }
  }

  ///Leetcode 695. Max Area of Island with extra space

  class Solution {

    public static void dfs(
      int row,
      int col,
      int m,
      int n,
      int[][] grid,
      boolean[][] vis,
      int max[]
    ) {
      vis[row][col] = true;
      max[0] = max[0] + 1;

      int dirs[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

      for (int[] dir : dirs) {
        int nRow = row + dir[0];
        int nCol = col + dir[1];

        if (
          nRow >= 0 &&
          nCol >= 0 &&
          nRow < n &&
          nCol < m &&
          grid[nRow][nCol] == 1 &&
          vis[nRow][nCol] == false
        ) {
          dfs(nRow, nCol, m, n, grid, vis, max);
        }
      }
    }

    public int maxAreaOfIsland(int[][] grid) {
      int n = grid.length;
      int m = grid[0].length;

      boolean vis[][] = new boolean[n][m];
      int max[] = new int[1];
      int maxArea = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (grid[i][j] == 1 && vis[i][j] == false) {
            dfs(i, j, m, n, grid, vis, max);
            maxArea = Math.max(maxArea, max[0]);
            max[0] = 0;
          }
        }
      }
      return maxArea;
    }
  }

  ///Leetcode 695. Max Area of Island without  extra space without boolean array

  class Solution {

    public static int dfs(int row, int col, int n, int m, int[][] grid) {
      grid[row][col] = 2;

      int dirs[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

      int totalArea = 0;

      for (int dir[] : dirs) {
        int nRow = row + dir[0];
        int nCol = col + dir[1];

        if (
          nRow >= 0 &&
          nCol >= 0 &&
          nRow < n &&
          nCol < m &&
          grid[nRow][nCol] == 1
        ) {
          totalArea = totalArea + dfs(nRow, nCol, n, m, grid);
        }
      }
      return totalArea + 1;
    }

    public int maxAreaOfIsland(int[][] grid) {
      int n = grid.length;
      int m = grid[0].length;
      int maxArea = 0;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (grid[i][j] == 1) {
            int area = dfs(i, j, n, m, grid);
            maxArea = Math.max(maxArea, area);
          }
        }
      }
      return maxArea;
    }
  }

  public static void main(String[] args) {
    int N = 8;

    int arr[] = new int[N];

    @SuppressWarnings("unchecked")
    ArrayList<Edge> graph[] = new ArrayList[N]; //where  ArrayList<Edge> is a data type ,graph is variable name,

    //initailize the arrayList

    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    addEdge(0, 1, 0, graph);
    addEdge(0, 2, 0, graph);
    addEdge(1, 3, 0, graph);
    addEdge(2, 3, 0, graph);
    addEdge(2, 4, 0, graph);
    //  addEdge(4, 5, 0, graph);
    addEdge(3, 5, 0, graph);
    addEdge(5, 7, 0, graph);
    addEdge(4, 6, 0, graph);
    addEdge(6, 7, 0, graph);

    //displayGraph(graph);
    printAllHamiltonianPathAndCycle(0, graph, N);
  }
}
