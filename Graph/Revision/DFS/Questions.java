import java.util.ArrayList;

class Edge {

  int u;
  int v;
  int w;

  Edge(int u, int v, int w) {
    this.u = u;
    this.v = v;
    this.w = w;
  }

  public String toString() {
    return "(" + this.u + " --> " + this.v + " : " + this.w + ")";
  }
}

public class Questions {

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

  public static boolean checkIfCycle(
    int src,
    int osrc,
    ArrayList<Edge>[] graph
  ) {
    for (Edge e : graph[src]) {
      int nbr = e.v;
      if (nbr == osrc) {
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
      if (checkIfCycle(src, osrc, graph)) {
        System.out.println("Hamiltonian cycle is " + psf);
      } else {
        System.out.println("Hamiltonion path is " + psf);
      }
    }
    vis[src] = true;

    for (Edge e : graph[src]) {
      int nbr = e.v;

      if (vis[nbr] == false) {
        traverseDFS(nbr, osrc, edgesVisited + 1, graph, N, vis, psf + nbr);
      }
    }

    vis[src] = false;
  }

  public static void printAllHamiltonianPathAndCycle(
    int src,
    ArrayList<Edge> graph[],
    int N
  ) {
    int osrc = src;
    boolean vis[] = new boolean[N];

    traverseDFS(src, osrc, 0, graph, N, vis, src + "");
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
    addEdge(4, 5, 0, graph);
    addEdge(3, 5, 0, graph);
    addEdge(5, 7, 0, graph);
    addEdge(4, 6, 0, graph);
    addEdge(6, 7, 0, graph);

    //   displayGraph(graph);
    printAllHamiltonianPathAndCycle(0, graph, N);
  }
}
