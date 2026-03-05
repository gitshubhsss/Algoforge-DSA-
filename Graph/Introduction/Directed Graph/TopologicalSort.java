import java.util.ArrayList;
import java.util.Collections;

class Edge {

  int u;
  int v;

  public Edge(int u, int v) {
    this.u = u;
    this.v = v;
  }

  public String toString() {
    return "(" + this.u + " --> " + this.v + ")";
  }
}

class TopologicalSort {

  public static void addEdge(int u, int v, ArrayList<Edge>[] graph) {
    graph[u].add(new Edge(u, v));
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

  public static void topo_dfs(
    int u,
    ArrayList<Edge>[] graph,
    ArrayList<Integer> topologicalOrder,
    boolean[] vis
  ) {
    vis[u] = true;

    for (Edge e : graph[u]) {
      int nbr = e.v;

      if (vis[nbr] == false) {
        topo_dfs(nbr, graph, topologicalOrder, vis);
      }
    }

    topologicalOrder.add(u);
  }

  public static ArrayList<Integer> findTopologicalOrder(
    ArrayList<Edge>[] graph,
    int N
  ) {
    boolean vis[] = new boolean[N];

    ArrayList<Integer> topologicalOrder = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      if (vis[i] == false) {
        topo_dfs(i, graph, topologicalOrder, vis);
      }
    }

    Collections.reverse(topologicalOrder);

    return topologicalOrder;
  }

  public static void main(String[] args) {
    int N = 12;

    int arr[] = new int[N];

    @SuppressWarnings("unchecked")
    ArrayList<Edge> graph[] = new ArrayList[N]; //where  ArrayList<Edge> is a data type ,graph is variable name,

    //initailize the arrayList
    for (int i = 0; i < N; i++) {
      graph[i] = new ArrayList<>();
    }

    addEdge(5, 11, graph); // 0---2w----1
    addEdge(11, 2, graph);
    addEdge(11, 9, graph);
    addEdge(11, 10, graph);
    addEdge(7, 11, graph);
    addEdge(7, 8, graph);
    addEdge(8, 9, graph);
    addEdge(3, 8, graph);
    addEdge(3, 10, graph);

    System.out.println(findTopologicalOrder(graph, N));

    //displayGraph(graph);
  }
}
