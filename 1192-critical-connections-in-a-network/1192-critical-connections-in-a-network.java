class Solution {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer>[] graph;
    int[] disc, low;
    int time = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        // build graph
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> e : connections) {
            int u = e.get(0), v = e.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }

        disc = new int[n];
        low = new int[n];

        // DFS
        dfs(0, -1);

        return res;
    }

    void dfs(int u, int parent) {
        disc[u] = low[u] = ++time;

        for (int v : graph[u]) {

            if (v == parent) continue;

            if (disc[v] == 0) { // not visited
                dfs(v, u);

                low[u] = Math.min(low[u], low[v]);

                // bridge condition
                if (low[v] > disc[u]) {
                    res.add(Arrays.asList(u, v));
                }

            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}