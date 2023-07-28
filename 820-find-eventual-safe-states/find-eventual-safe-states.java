class Solution {
    public boolean dfs(int node, int[] visited, int[] pathVis, int[] check, List<List<Integer>> adj){
        visited[node]=1;
        pathVis[node]=1;
        check[node]=0;

        for(int it : adj.get(node)){
            if(visited[it]==0){
                if(dfs(it, visited, pathVis, check, adj)){
                    return true;
                }
            }

            else if(pathVis[it]==1){
                return true;
            }
        }

        pathVis[node]=0;
        check[node] = 1;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<V;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }

        int[] visited = new int[V];
        int[] pathVis = new int[V];
        int[] check = new int[V];

        for(int i=0;i<V;i++){
            if(visited[i]==0){
                dfs(i, visited, pathVis, check, adj);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0; i<V;i++){
            if(check[i]==1){
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }
}