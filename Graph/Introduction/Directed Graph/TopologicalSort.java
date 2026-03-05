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

  public static boolean topo_dfs_isCycle(
    int src,
    ArrayList<Edge>[] graph,
    ArrayList<Integer> topologicalOrder,
    int[] vis
  ) {
    vis[src] = 1;

    for (Edge e : graph[src]) {
      int nbr = e.v;
      if (vis[nbr] == 1) {
        //means their is cycle
        System.out.println("Cycle found");
        return true;
      } else if (vis[nbr] == 2) {
        continue;
      } else {
        topo_dfs_isCycle(nbr, graph, topologicalOrder, vis);
      }
    }
    vis[src] = 2;
    topologicalOrder.add(src);

    return false;
  }

  public static ArrayList<Integer> findTopologicalOrder_generic(
    ArrayList<Edge>[] graph,
    int N
  ) {
    int vis[] = new int[N];

    ArrayList<Integer> topologicalOrder = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      if (vis[i] == 0) {
        if (topo_dfs_isCycle(i, graph, topologicalOrder, vis)) {
          return new ArrayList<>();
        }
      }
    }
    return topologicalOrder;
  }

  ///Problems on topological sort ===================================================================================

  // Leetcode : 207. Course Schedule
  class Solution {

    public static boolean topo_dfs_isCycle(
      int src,
      ArrayList<Edge>[] graph,
      int vis[]
    ) {
      vis[src] = 1;

      for (Edge e : graph[src]) {
        int nbr = e.v;

        if (vis[nbr] == 1) {
          return true;
        } else if (vis[nbr] == 2) {
          continue;
        } else {
          if (topo_dfs_isCycle(nbr, graph, vis)) {
            return true;
          }
        }
      }

      vis[src] = 2;

      return false;
    }

    public static void addEdge(int u, int v, ArrayList<Edge>[] graph) {
      graph[u].add(new Edge(u, v));
    }

    public static void makeGraph(
      ArrayList<Edge>[] graph,
      int[][] prerequisites
    ) {
      for (int[] prerequisit : prerequisites) {
        int u = prerequisit[0];
        int v = prerequisit[1];
        addEdge(u, v, graph);
      }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
      int N = numCourses;

      ArrayList<Edge>[] graph = new ArrayList[N];

      //initialize the graph
      for (int i = 0; i < N; i++) {
        graph[i] = new ArrayList<>();
      }

      makeGraph(graph, prerequisites);

      int vis[] = new int[N];

      for (int i = 0; i < N; i++) {
        if (vis[i] == 0) {
          if (topo_dfs_isCycle(i, graph, vis) == true) {
            return false;
          }
        }
      }

      return true;
    }
  }

  //Leetcode : 210 Course schedule ||

  class Solution {

    public static void addEdge(int u, int v, ArrayList<Edge> graph[]) {
      graph[u].add(new Edge(u, v));
    }

    public static void makeGraph(
      ArrayList<Edge> graph[],
      int[][] prerequisites
    ) {
      for (int[] prerequisit : prerequisites) {
        int u = prerequisit[0];
        int v = prerequisit[1];

        addEdge(u, v, graph);
      }
    }

    public static boolean topo_dfs(
      int src,
      ArrayList<Edge> graph[],
      int vis[],
      ArrayList<Integer> topoOrder
    ) {
      vis[src] = 1;

      for (Edge e : graph[src]) {
        int nbr = e.v;

        if (vis[nbr] == 1) {
          return true;
        } else if (vis[nbr] == 2) {
          continue;
        } else {
          if (topo_dfs(nbr, graph, vis, topoOrder)) {
            return true;
          }
        }
      }

      topoOrder.add(src);
      vis[src] = 2;

      return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
      int N = numCourses;

      ArrayList<Edge>[] graph = new ArrayList[N];

      //Initialize the graph

      for (int i = 0; i < N; i++) {
        graph[i] = new ArrayList<>();
      }

      ArrayList<Integer> topologicalOrder = new ArrayList<>();

      int vis[] = new int[N];

      makeGraph(graph, prerequisites);

      for (int i = 0; i < N; i++) {
        if (vis[i] == 0) {
          if (topo_dfs(i, graph, vis, topologicalOrder)) {
            return new int[] {};
          }
        }
      }

      int ans[] = new int[topologicalOrder.size()];

      for (int i = 0; i < topologicalOrder.size(); i++) {
        ans[i] = topologicalOrder.get(i);
      }

      return ans;
    }
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
    addEdge(2, 9, graph); //cycle edge
    addEdge(11, 9, graph);
    addEdge(9, 11, graph); //cycle edge
    addEdge(11, 10, graph);
    addEdge(7, 11, graph);
    addEdge(7, 8, graph);
    addEdge(8, 9, graph);
    addEdge(3, 8, graph);
    addEdge(3, 10, graph);

    // System.out.println(findTopologicalOrder(graph, N));

    System.out.println(findTopologicalOrder_generic(graph, N));

    //displayGraph(graph);
  }
}
