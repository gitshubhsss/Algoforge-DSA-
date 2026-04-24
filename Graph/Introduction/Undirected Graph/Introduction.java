import java.util.ArrayList;
import java.util.PriorityQueue;

class Edge {

  int u;
  int v;
  int w;

  public Edge(int u, int v, int w) {
    this.u = u;
    this.v = v;
    this.w = w;
  }

  @Override
  public String toString() {
    return "(" + u + "->" + v + " :" + w + ")";
  }
}

class Pair implements Comparable<Pair> {
  String psf;
  int wsf;

  public Pair(String psf, int wsf) {
    this.psf = psf;
    this.wsf = wsf;
  }

  @Override
  public int compareTo(Pair other) {
    return this.wsf - other.wsf;
  }
}

public class Introduction {

  public static void addEdge(ArrayList<Edge> graph[], int u, int v, int w) {
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

  // Function to check the path
  public static boolean hasPath(int src, int des, ArrayList<Edge>[] graph, boolean vis[]) {
    if (src == des) {
      return true;
    }
    vis[src] = true;

    for (Edge e : graph[src]) {
      int nbr = e.v;
      if (vis[nbr] == false) {
        if (hasPath(nbr, des, graph, vis)) {
          return true;
        }
      }
    }

    return false;

  }

  // Function to print all the paths
  public static void printAllPaths(int src, int des, ArrayList<Edge>[] graph, boolean[] vis, String psf) {
    if (src == des) {
      System.out.println(psf);
      return;
    }

    vis[src] = true;

    for (Edge e : graph[src]) {
      int nbr = e.v;
      if (vis[nbr] == false) {
        printAllPaths(nbr, des, graph, vis, psf + nbr);
      }
    }

    vis[src] = false;
  }

  // Find path with minimum weight between source and destination

  static int shortestPathWeight = Integer.MAX_VALUE;
  static int longestPathWeight = Integer.MIN_VALUE;
  static String longestPath = "";
  static String shortestPath = "";

  static PriorityQueue<Pair> pq = new PriorityQueue<>();

  public static void findMinandMaxWeightPath(int src, int des, ArrayList<Edge>[] graph, boolean[] vis, int wsf,
      String psf, int k) {

    if (src == des) {
      if (wsf < shortestPathWeight) {
        shortestPathWeight = wsf;
        shortestPath = psf;
      }
      if (wsf > longestPathWeight) {
        longestPathWeight = wsf;
        longestPath = psf;
      }

      pq.add(new Pair(psf, wsf));

      if (pq.size() > k) {
        pq.remove();
      }

      return;

    }

    vis[src] = true;

    for (Edge e : graph[src]) {
      int nbr = e.v;
      int wt = e.w;
      if (vis[nbr] == false) {
        findMinandMaxWeightPath(nbr, des, graph, vis, wsf + wt, psf + nbr, k);
      }
    }

    vis[src] = false;

  }

  /// Geeks for geeks Connected Components in an Undirected Graph
  class Solution {

    public static void addEdge(ArrayList<Integer>[] graph, int u, int v) {
      graph[u].add(v);
      graph[v].add(u);
    }

    public static void dfs(int src, boolean[] vis, ArrayList<Integer>[] graph, ArrayList<Integer> curComponents) {

      vis[src] = true;

      curComponents.add(src);

      for (int vtx : graph[src]) {
        if (vis[vtx] == false) {
          dfs(vtx, vis, graph, curComponents);
        }
      }
    }

    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {

      @SuppressWarnings("unchecked")
      ArrayList<Integer>[] graph = new ArrayList[V];

      for (int i = 0; i < V; i++) {
        graph[i] = new ArrayList<>();
      }

      for (int[] edge : edges) {
        int u = edge[0];
        int v = edge[1];

        addEdge(graph, u, v);
      }

      boolean[] vis = new boolean[V];
      ArrayList<ArrayList<Integer>> allComponents = new ArrayList<>();

      for (int i = 0; i < V; i++) {
        ArrayList<Integer> curComponents = new ArrayList<>();
        if (vis[i] == false) {
          dfs(i, vis, graph, curComponents);
          allComponents.add(curComponents);
        }
      }

      return allComponents;

    }
  }

  // Function to check if their is any edge
  public static boolean checkIfEdge(int src, int osrc, ArrayList<Edge>[] graph) {

    for (Edge e : graph[src]) {
      if (e.v == osrc) {
        return true;
      }
    }

    return false;
  }

  public static void printHamiltonianPath(int src, int osrc, int noOfEdges, ArrayList<Edge>[] graph, boolean[] vis,
      String psf, int N) {

    if (noOfEdges == N - 1) {

      // Print hamiltonian path
      System.out.println("Hamiltonian path is " + psf);

      // Print hamiltonian cycle
      if (checkIfEdge(src, osrc, graph)) {
        System.out.println("Hamiltonian cycle path is " + psf);
      }
    }

    vis[src] = true;

    for (Edge e : graph[src]) {

      int nbr = e.v;
      if (vis[nbr] == false) {
        printHamiltonianPath(nbr, osrc, noOfEdges + 1, graph, vis, psf + nbr, N);
      }
    }

    vis[src] = false;

  }

  // Geeks for geeks Hamiltonian Path

  class Solution2 {

    public static void addEdge(ArrayList<Integer>[] graph, int u, int v) {
      graph[u].add(v);
      graph[v].add(u);
    }

    boolean check(int n, int m, ArrayList<ArrayList<Integer>> edges) {

      @SuppressWarnings("unchecked")
      ArrayList<Integer>[] graph = new ArrayList[n + 1];

      for (int i = 0; i <= n; i++) {
        graph[i] = new ArrayList<>();
      }

      for (ArrayList<Integer> edge : edges) {
        int u = edge.get(0);
        int v = edge.get(1);

        addEdge(graph, u, v);
      }

      boolean vis[] = new boolean[n + 1];

      for (int i = 1; i <= n; i++) {
        if (vis[i] == false) {
          if (traverse_dfs(i, 1, graph, vis, n)) {
            return true;
          }
        }
      }

      return false;

    }

    boolean traverse_dfs(int src, int edgesVisited, ArrayList<Integer>[] graph, boolean[] vis, int N) {

      // base case
      if (edgesVisited == N) {
        return true;
      }

      vis[src] = true;

      for (int nbr : graph[src]) {
        if (vis[nbr] == false) {

          if (traverse_dfs(nbr, edgesVisited + 1, graph, vis, N)) {
            return true;
          }
        }
      }

      vis[src] = false;

      return false;

    }

  }

  public static void main(String[] args) {
    // int N = 6;

    // @SuppressWarnings("unchecked")
    // ArrayList<Edge>[] graph = new ArrayList[N];

    // // initialize the arraylist
    // for (int i = 0; i < N; i++) {
    // graph[i] = new ArrayList<>();
    // }

    // addEdge(graph, 0, 1, 1);
    // addEdge(graph, 1, 2, 2);
    // addEdge(graph, 1, 4, 80);
    // addEdge(graph, 1, 3, 3);
    // addEdge(graph, 2, 4, 25);
    // addEdge(graph, 3, 4, 20);
    // addEdge(graph, 4, 5, 13);
    // addEdge(graph, 4, 6, 15);
    // addEdge(graph, 5, 7, 4);
    // addEdge(graph, 6, 7, 3);

    // addEdge(graph, 0, 1, 0);
    // addEdge(graph, 0, 2, 0);
    // addEdge(graph, 1, 3, 0);
    // addEdge(graph, 2, 3, 0);
    // addEdge(graph, 2, 4, 0);
    // addEdge(graph, 4, 5, 0);
    // addEdge(graph, 3, 5, 0);

    // displayGraph(graph, N);

    // System.out.println(hasPath(0, 4, graph, vis));

    // printAllPaths(0, 7, graph, vis, "" + 0);
    // findMinandMaxWeightPath(0, 4, graph, vis, 0, "" + 0, 2);
    // System.out.println(shortestPathWeight);
    // System.out.println(longestPathWeight);
    // System.out.println(shortestPath);
    // System.out.println(longestPath);
    // System.out.println("kth largest is " + pq.poll().wsf);

    // printHamiltonianPath(0, 0, 0, graph, vis, "" + 0, N);

  }
}
