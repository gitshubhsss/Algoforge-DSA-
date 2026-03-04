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
