class Solution {
    public boolean dfs(int node, int col, int[] colour, ArrayList<ArrayList<Integer>> adj){
        colour[node] = col;

        for(int adjacent : adj.get(node)){
            if(colour[adjacent]==-1){
                if(dfs(adjacent, 1-col, colour, adj)==false){
                    return false;
                }
            }else if(colour[adjacent]==col){
                return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<graph.length;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0;j<graph[i].length;j++){
                temp.add(graph[i][j]);
            }
            adj.add(temp);
        }
        int n = graph.length;
        int[] colour = new int[graph.length];
        for(int i=0;i<n;i++){
            colour[i]=-1;
        }

        for(int i=0;i<n;i++){
            if(colour[i]==-1){
                if(dfs(i, 0, colour, adj)==false){
                    return false;
                }
            }
        }

        return true;
    }
}