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

public class Construction {

  public static void addEdge(int u, int v, int w, ArrayList<Edge>[] graph) {
    graph[u].add(new Edge(u, v, w));
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

    displayGraph(graph);
  }
}
