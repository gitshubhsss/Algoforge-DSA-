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

public class Introduction {

  public static void BFS_1(int src, ArrayList<Edge>[] graph, int N) {
    boolean vis[] = new boolean[N];

    LinkedList<Integer> que = new LinkedList<>();
    que.add(src);

    int level = 0;
    boolean isCycle = false;

    while (que.size() > 0) {
      System.out.print("Nodes at distance " + level + "->");

      int size = que.size();

      while (size-- > 0) {
        int vtx = que.removeFirst();

        if (vis[vtx] == true) {
          isCycle = true;
          continue;
        }

        System.out.print(vtx + ", ");
        vis[vtx] = true;

        for (Edge e : graph[vtx]) {
          int nbr = e.v;
          if (vis[nbr] == false) {
            que.add(nbr);
          }
        }
      }

      level++;
      System.out.println();
    }

    if (isCycle) {
      System.out.println("Their is the cycle in this graph");
    }
  }

  // Construction utils
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
    addEdge(3, 4, 4, graph);
    addEdge(3, 5, 7, graph);
    addEdge(3, 6, 9, graph);
    addEdge(5, 6, 8, graph);
    BFS_1(0, graph, N);
    // displayGraph(graph);
  }
}
