import java.util.*;

class Pair implements Comparable<Pair> {

  int wsf;
  String psf;

  Pair(int wsf, String psf) {
    this.wsf = wsf;
    this.psf = psf;
  }

  @Override
  public int compareTo(Pair other) {
    return this.wsf - other.wsf; // Min Heap based on weight
  }
}

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

public class Introduction {

  ///Lec 1 : problems ======================================================================================================
  static String longestPath = "";
  static int longestPathWt = Integer.MIN_VALUE;
  static String shortestPath = "";
  static int shortestPathWt = Integer.MAX_VALUE;

  public static void traverseAllPaths(
    int src,
    int dec,
    ArrayList<Edge>[] graph,
    boolean vis[],
    String psf,
    int wsf,
    int k
  ) {
    if (src == dec) {
      if (wsf > longestPathWt) {
        longestPathWt = wsf;
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
        traverseAllPaths(nbr, dec, graph, vis, psf + nbr, wsf + wt, k);
      }
    }

    vis[src] = false;
  }

  public static void printAllPaths(
    int src,
    int dec,
    ArrayList<Edge>[] graph,
    boolean vis[],
    String asf
  ) {
    if (src == dec) {
      System.out.println(asf);
      return;
    }

    vis[src] = true;

    for (Edge e : graph[src]) {
      int nbr = e.v;

      if (vis[nbr] == false) {
        printAllPaths(nbr, dec, graph, vis, asf + nbr);
      }
    }

    ///To visit all the paths
    vis[src] = false;
  }

  public static void AllPaths(
    int src,
    int dec,
    ArrayList<Edge>[] graph,
    int N
  ) {
    //create the boolean array
    boolean vis[] = new boolean[N];
    printAllPaths(src, dec, graph, vis, "" + src);
  }

  public static boolean hasPath(
    int src,
    int dec,
    ArrayList<Edge>[] graph,
    boolean vis[],
    int N
  ) {
    if (src == dec) {
      return true;
    }
    vis[src] = true;

    boolean isVisited = false;

    for (Edge e : graph[src]) {
      int nbr = e.v;
      if (vis[nbr] == false) {
        isVisited = isVisited || hasPath(nbr, dec, graph, vis, N);
      }
    }

    return isVisited;
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

  public static void main(String[] args) {
    int N = 7;

    int arr[] = new int[N];

    @SuppressWarnings("unchecked")
    ArrayList<Edge> graph[] = new ArrayList[N]; //where  ArrayList<Edge> is a data type ,graph is variable name,

    //initailize the arrayList

    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    addEdge(0, 1, 2, graph); // 0---2w----1
    addEdge(1, 2, 5, graph);
    addEdge(1, 4, 3, graph);
    addEdge(4, 5, 10, graph);

    addEdge(3, 4, 4, graph);
    addEdge(3, 5, 7, graph);
    addEdge(3, 6, 9, graph);
    addEdge(5, 6, 8, graph);

    //displayGraph(graph);

    boolean vis[] = new boolean[N];

    //  System.out.println(hasPath(0, 6, graph, vis, N));

    //  AllPaths(0, 5, graph, N);

    traverseAllPaths(0, 5, graph, vis, "0", 2, 2);

    System.out.println("Longest path " + longestPath);
    System.out.println("longestPath Weight" + longestPathWt);
    System.out.println("shortest Path" + shortestPath);
    System.out.println("shortest Path Weight" + shortestPathWt);
  }
}
