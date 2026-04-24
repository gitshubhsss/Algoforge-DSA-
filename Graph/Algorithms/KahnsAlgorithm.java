import java.util.ArrayList;
import java.util.LinkedList;

class Edge {
    int u;
    int v;

    public Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }

    @Override
    public String toString() {
        return u + " -> " + v;
    }

}

public class KahnsAlgorithm {

    /// Kahns alogorithm
    public static ArrayList<Integer> traverseTopolocalOrder(ArrayList<Edge>[] graph, int N) {

        int[] indegree = new int[N];

        // calculate the indegree
        for (int i = 0; i < N; i++) {
            for (Edge e : graph[i]) {
                int v = e.v;
                indegree[v]++;
            }
        }

        LinkedList<Integer> que = new LinkedList<>();

        ArrayList<Integer> topologicalOrder = new ArrayList<>();

        // insert the indgree having 0 incoming edges
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                que.add(i);
            }
        }

        while (que.size() > 0) {

            int u = que.removeFirst();
            topologicalOrder.add(u);

            for (Edge e : graph[u]) {
                int v = e.v;

                indegree[v]--;

                if (indegree[v] == 0) {
                    que.add(v);
                }
            }
        }
        if (topologicalOrder.size() != N) {
            System.out.println("No topological order . Cycle is there in the graph");
            return new ArrayList<>();
        }

        return topologicalOrder;

    }

    public static void addEdge(int u, int v, ArrayList<Edge>[] graph) {
        graph[u].add(new Edge(u, v));
    }

    public static void main(String[] args) {
        int N = 12;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        addEdge(5, 11, graph);
        addEdge(11, 2, graph);
        addEdge(11, 9, graph);
        addEdge(11, 10, graph);
        addEdge(7, 8, graph);
        addEdge(7, 11, graph);
        addEdge(8, 9, graph);
        addEdge(3, 8, graph);
        addEdge(3, 10, graph);

        // for detecting the cycle
        // addEdge(2, 9, graph);
        // addEdge(9, 11, graph);

        System.out.println(traverseTopolocalOrder(graph, N));

    }
}
