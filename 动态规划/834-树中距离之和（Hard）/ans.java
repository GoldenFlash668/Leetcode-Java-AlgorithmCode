class Solution {
    int[] dp;
    int[] ans;
    int[] sz;
    List<List<Integer>> graph;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        ans = new int[N];
        sz = new int[N];
        dp = new int[N];
        graph = new ArrayList<List<Integer>>();
        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int[] edge:edges){
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return ans;    
    }
    public void dfs(int u, int f){
        sz[u] = 1;
        dp[u] = 0;
        for(int v :graph.get(u)){
            if(v == f){
                continue;
            }
            dfs(v, u);
            dp[u] += dp[v] + sz[v];
            sz[u] += sz[v]; 
        }
    }
    public void dfs2(int u, int f){
        ans[u] = dp[u];
        for(int v: graph.get(u)){
            if(v == f){
                continue;
            }
            int x1 = dp[u], y1 = dp[v];
            int x2 = sz[u], y2 = sz[v];
            dp[u] -= dp[v] + sz[v];
            sz[u] -= sz[v];
            dp[v] += dp[u] + sz[u];
            sz[v] += sz[u];
            dfs2(v, u);
            dp[u] = x1;
            dp[v] = y1;
            sz[u] = x2;
            sz[v] = y2;
        }
    }
}