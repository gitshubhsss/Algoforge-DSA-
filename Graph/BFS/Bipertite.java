class Bipertite {

  class Solution {

    public static boolean checkIfOddCycle(int[][] graph, int[] vis, int src) {
      int color = 0;
      LinkedList<Integer> que = new LinkedList<>();
      que.addLast(src);

      while (que.size() > 0) {
        int size = que.size();

        while (size-- > 0) {
          int vtx = que.removeFirst();
          if (vis[vtx] != -1 && vis[vtx] != color) {
            return true;
          }
          vis[vtx] = color;

          for (int nbr : graph[vtx]) {
            if (vis[nbr] == -1) {
              que.addLast(nbr);
            }
          }
        }

        color = (color + 1) % 2;
      }
      return false;
    }

    public boolean isBipartite(int[][] graph) {
      int N = graph.length;

      int color = 0;
      int vis[] = new int[N];

      Arrays.fill(vis, -1);

      for (int i = 0; i < N; i++) {
        if (vis[i] == -1) {
          if (checkIfOddCycle(graph, vis, i)) {
            return false;
          }
        }
      }

      return true;
    }
  }


  class Solution {

    public boolean possibleBipartition(int n, int[][] dislikes) {}
  }
}
