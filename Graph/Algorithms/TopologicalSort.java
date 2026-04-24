import java.util.ArrayList;
import java.util.Collections;

class Edge {
    int u;
    int v;
    int w;

    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public String toString() {
        return "" + u + " ->" + v + "";
    }

}

public class TopologicalSort {

    public static void addEdge(ArrayList<Edge>[] graph, int u, int v) {
        graph[u].add(new Edge(u, v, 2));
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

    public static boolean topo_dfs_isCycle(int src, ArrayList<Edge>[] graph, ArrayList<Integer> topologicalOrder,
            int[] vis) {

        vis[src] = 1;

        for (Edge e : graph[src]) {
            int nbr = e.v;

            if (vis[nbr] == 1) {
                System.out.println("Cycle found.......");
                return true;
            }

            if (vis[nbr] == 0) {
                if (topo_dfs_isCycle(nbr, graph, topologicalOrder, vis)) {
                    return true;
                }
            } else if (vis[nbr] == 2) {
                continue;
            }
        }

        vis[src] = 2;

        topologicalOrder.add(src);
        return false;

    }

    // detect the cycle
    public static ArrayList<Integer> topologicalTraverse_generic(ArrayList<Edge>[] graph, int N) {

        ArrayList<Integer> topologicalOrder = new ArrayList<>();
        int[] vis = new int[N];

        for (int i = 0; i < N; i++) {
            if (vis[i] == 0) {
                if (topo_dfs_isCycle(i, graph, topologicalOrder, vis)) {
                    return new ArrayList<>();
                }
            }
        }

        Collections.reverse(topologicalOrder);
        return topologicalOrder;

    }

    // Does not detect the cycle
    public static void topologicalTraverse(int src, ArrayList<Edge>[] graph, boolean[] vis,
            ArrayList<Integer> topologicalArray) {

        for (Edge e : graph[src]) {
            int nbr = e.v;
            if (vis[nbr] == false) {
                topologicalTraverse(nbr, graph, vis, topologicalArray);
            }
        }

        topologicalArray.add(src);
        vis[src] = true;
    }

    public static void main(String[] args) {

        int N = 12;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        addEdge(graph, 5, 11);
        addEdge(graph, 11, 2);
        addEdge(graph, 11, 9);
        addEdge(graph, 11, 10);
        // addEdge(graph, 2, 9);//
        // addEdge(graph, 9, 11);//
        addEdge(graph, 8, 9);
        addEdge(graph, 3, 8);
        addEdge(graph, 3, 10);
        addEdge(graph, 7, 8);
        addEdge(graph, 7, 11);

        // boolean[] vis = new boolean[N];

        // ArrayList<Integer> topologicalArray = new ArrayList<>();

        // for (int i = 0; i < N; i++) {
        // if (vis[i] == false) {
        // topologicalTraverse(i, graph, vis, topologicalArray);
        // }
        // }

        // Collections.reverse(topologicalArray);

        System.out.println(topologicalTraverse_generic(graph, N));

        // displayGraph(graph, N);

    }
}
