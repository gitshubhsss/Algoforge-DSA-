import java.util.ArrayList;

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

public class Construction {

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

  public static void main(String[] args) {
    int N = 8;

    @SuppressWarnings("unchecked")
    ArrayList<Edge>[] graph = new ArrayList[N];

    // initialize the arraylist

    for (int i = 0; i < N; i++) {
      graph[i] = new ArrayList<>();
      System.out.println(graph[i]);
    }

    addEdge(graph, 0, 1, 1);
    addEdge(graph, 1, 2, 2);
    addEdge(graph, 1, 3, 3);
    addEdge(graph, 2, 4, 25);
    addEdge(graph, 4, 5, 13);
    addEdge(graph, 4, 6, 15);
    addEdge(graph, 5, 7, 4);
    addEdge(graph, 6, 7, 3);

    displayGraph(graph, N);
  }
}
