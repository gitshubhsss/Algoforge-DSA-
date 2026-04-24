import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Questions {
    // leetcode 743 ============================= dryrun pending

    class Solution743 {

        public static ArrayList<int[]>[] makeGraph(int N, int[][] edges) {

            @SuppressWarnings("unchecked")
            ArrayList<int[]>[] graph = new ArrayList[N + 1]; // 1-indexed

            for (int i = 0; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                graph[u].add(new int[] { v, w });
            }

            return graph;
        }

        public int networkDelayTime(int[][] times, int n, int k) {
            ArrayList<int[]>[] graph = makeGraph(n, times);

            int[] dis = new int[n + 1];
            Arrays.fill(dis, (int) (1e8));

            // {vtx, wsf};
            PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {
                return a[1] - b[1];
            });

            dis[k] = 0;
            pq.add(new int[] { k, 0 });

            while (pq.size() > 0) {
                int[] top = pq.remove();

                int u = top[0];
                int wsf = top[1];

                if (dis[u] < wsf)
                    continue;

                for (int[] edge : graph[u]) {
                    int v = edge[0];
                    int wt = edge[1];

                    if (dis[v] > dis[u] + wt) {
                        dis[v] = dis[u] + wt;
                        pq.add(new int[] { v, dis[v] });
                    }
                }
            }

            int minTime = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) { // 1-indexed
                int d = dis[i];
                if (d == (int) (1e8))
                    return -1;
                minTime = Math.max(minTime, d);
            }

            return minTime;
        }

    }

    // Leetcode: 1928. Minimum Cost to Reach Destination
    // pending
    class Solution1928 {

        class Pair {
            int vtx;
            int timeSoFar;
            int feesSoFar;

            public Pair(int vtx, int timeSoFar, int feesSoFar) {
                this.vtx = vtx;
                this.timeSoFar = timeSoFar;
                this.feesSoFar = feesSoFar;
            }
        }

        public static ArrayList<int[]>[] makeGraph(int N, int[][] edges) {

            @SuppressWarnings("unchecked")
            ArrayList<int[]>[] graph = new ArrayList[N + 1]; // 1-indexed

            for (int i = 0; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                int v = edge[0];
                int etime = edge[1];
                int fees = edge[2];

                graph[v].add(new int[] { v, etime, fees });
            }

            return graph;
        }

        public int minCost(int maxTime, int[][] edges, int[] passingFees) {

            PriorityQueue<Pair> pq = new PriorityQueue<Pair>((Pair a, Pair b) -> {

                if (a.feesSoFar == b.feesSoFar) {
                    return a.timeSoFar - b.timeSoFar;
                }
                return a.feesSoFar - b.feesSoFar;
            });

            int n = passingFees.length;

            int[] timeCost = new int[n];
            int[] feesCost = new int[n];

            Arrays.fill(timeCost, (int) (1e8));
            Arrays.fill(feesCost, (int) (1e8));

            pq.add(new Pair(0, 0, passingFees[0]));
            timeCost[0] = 0;
            feesCost[0] = passingFees[0];

            ArrayList<int[]>[] graph = makeGraph(n, edges);

            while (pq.size() > 0) {

                Pair top = pq.remove();

                int vtx = top.vtx;
                int feesSoFar = top.feesSoFar;
                int timeSoFar = top.timeSoFar;

                if (feesCost[vtx] < feesSoFar) {
                    continue;
                }

                for (int[] edge : graph[vtx]) {
                    int nbr = edge[0];
                    int edgeTime = edge[1];
                    int travellingFees = passingFees[nbr];

                    if (timeSoFar + edgeTime <= maxTime) {

                    }

                }
            }

            return -1;
        }
    }

    // Leetcode: 1631. Path With Minimum Effort

    class Solution1631 {
        public int minimumEffortPath(int[][] heights) {
            int n = heights.length;
            int m = heights[0].length;

            int[][] dis = new int[n][m];
            int dirs[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

            for (int[] d : dis) {
                Arrays.fill(d, (int) (1e8));
            }

            PriorityQueue<int[]> pq = new PriorityQueue<int[]>((int[] a, int[] b) -> {
                return a[0] - b[0];
            });

            dis[0][0] = 0;

            while (pq.size() > 0) {
                int[] top = pq.remove();

                int vtx = top[0];
                int maxAbsSofar = top[1];

                int i = vtx / m;
                int j = vtx % m;

                if (i == n - 1 && j == m - 1)
                    return maxAbsSofar;

                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];

                    if (x >= 0 && x < n && y >= 0 && y < m) {
                        int edgeWeight = Math.abs(heights[i][j] - heights[x][y]);

                        if (dis[x][y] > Math.max(maxAbsSofar, edgeWeight)) {
                            dis[x][y] = Math.max(maxAbsSofar, edgeWeight);
                            pq.add(new int[] { x * m + y, dis[x][y] });
                        }
                    }
                }

            }

            return dis[n - 1][m - 1];
        }
    }

    // leetcode 1976. Number of Ways to Arrive at Destination
    class Solution1976 {
        public int countPaths(int n, int[][] roads) {
            int[] dis = new int[n];
            int[] paths = new int[n];

            Arrays.fill(dis, Integer.MAX_VALUE);
            Arrays.fill(paths, 0);

            dis[0] = 0;
            paths[0] = 1;

            return -1;

        }

    }

    // 778. Swim in Rising Water
    class Solution778 {
        public int swimInWater(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;

            boolean vis[][] = new boolean[n][n];

            int dirs[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

            PriorityQueue<int[]> pq = new PriorityQueue<int[]>((int[] a, int[] b) -> {
                return a[1] - b[1];
            });

            pq.add(new int[] { 0, grid[0][0] });

            vis[0][0] = true;

            while (pq.size() > 0) {
                int[] top = pq.remove();
                int vtx = top[0];
                int maxSofar = top[1];

                int row = vtx / n;
                int col = vtx % n;

                // reached to destination
                if (row == n - 1 && col == m - 1) {
                    return maxSofar;
                }

                for (int[] dir : dirs) {
                    int x = dir[0] + row;
                    int y = dir[1] + col;
                    if (x >= 0 && y >= 0 && x < n && y < n && vis[x][y] == false) {
                        vis[x][y] = true;
                        int cost = Math.max(maxSofar, grid[x][y]);
                        pq.add(new int[] { x * n + y, cost });
                    }
                }
            }

            return -1;
        }
    }

}