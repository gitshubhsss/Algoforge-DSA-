import java.util.ArrayList;

class Pair implements Comparable<Pair> {

  int wsf;
  String psf;

  Pair(int wsf, String psf) {
    this.wsf = wsf;
    this.psf = psf;
  }

  @override
  public int compareTo(Pair other) {
    return this.wsf - other.wsf; //Min heap based on weight
  }
}

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

public class Introduction {

  static String longestPath = "";
  static int longestPathWt = Integer.MIN_VALUE;
  static String shortestPath = "";
  static int shortestPathWt = Integer.MAX_VALUE;

  ///Function to traverse all the paths

  public static void traverseAllPaths(
    int src,
    int des,
    ArrayList<Edge>[] graph,
    boolean vis[],
    String psf,
    int wsf,
    int k
  ) {
    if (src == des) {
      if (wsf > longestPathWt) {
        longestPathWt = swf;
        longestPath = psf;
      }

      if (wsf < shortestPathWt) {
        shortestPathWt = wsf;
        shortestPath = psf;
      }
      PriorityQueue<Pair> pq = new PriorityQueue<>();

      pq.add(new Pair(wsf, psf));

      while (pq.size() > k) {
        pq.remove();
      }

      return;
    }

    vis[src] = true;

    for (Edge e : graph[src]) {
      int nbr = e.v;
      int wt = e.w;

      if (vis[nbr] == false) {
        traverseAllPaths(nbr, des, graph, vis, psf + "->" + nbr, wsf + wt, k);
      }
    }

    vis[src] = false;
  }

  ///print all paths from src to des
  public static void printAllPaths(
    int src,
    int des,
    boolean vis[],
    ArrayList<Edge> graph[],
    String psf
  ) {
    if (src == des) {
      System.out.println(psf);
      // return;
    }

    vis[src] = true;

    for (Edge e : graph[src]) {
      int nbr = e.v;
      if (vis[nbr] == false) {
        printAllPaths(nbr, des, vis, graph, psf + "->" + nbr);
      }
    }

    vis[src] = false;
  }

  public static boolean hasPath(
    int src,
    int des,
    boolean[] vis,
    ArrayList<Edge> graph[]
  ) {
    if (src == des) {
      return true;
    }
    vis[src] = true;

    boolean visited = false;

    for (Edge e : graph[src]) {
      int nbr = e.v;
      if (vis[nbr] == false) {
        visited = visited || hasPath(nbr, des, vis, graph);
      }
    }

    return visited;
  }

  public static void addEdge(int u, int v, int w, ArrayList<Edge> graph[]) {
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

  public static void main(String[] args) {
    int N = 7;

    @SuppressWarnings("unchecked")
    ArrayList<Edge>[] graph = new ArrayList[N];

    //initialize the arrayList
    for (int i = 0; i < N; i++) {
      graph[i] = new ArrayList<>();
    }

    addEdge(0, 1, 2, graph);
    addEdge(1, 2, 5, graph);
    addEdge(1, 4, 3, graph);
    addEdge(3, 4, 4, graph);
    addEdge(3, 5, 7, graph);
    addEdge(3, 6, 9, graph);
    addEdge(5, 6, 8, graph);

    // displayGraph(graph);

    boolean vis[] = new boolean[N];

    // System.out.println(hasPath(0, 3, vis, graph));

    printAllPaths(0, 6, vis, graph, 0 + "");
  }
}
