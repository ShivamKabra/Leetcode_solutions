class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] arr = new int[numCourses];

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        int m = prerequisites.length;

        for(int i=0;i<m;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.remove();
            topo.add(node);

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        if(topo.size()!=numCourses){
            return new int[0];
        }
        // HashSet<Integer> hashset = new HashSet<>();
        // for(int ele : topo){
        //     if(hashset.contains(ele)){
        //         return arr;
        //     }
        //     hashset.add(ele);
        // }
        
        for(int i=0;i<topo.size();i++){
            arr[i]=topo.get(topo.size()-i-1);
        }

        return arr;
    }
}