class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites){
        ArrayList<Integer> graph[]=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] p: prerequisites){
            graph[p[1]].add(p[0]);
        }
        boolean vis[]=new boolean[numCourses];
        boolean recStack[]=new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            if(dfs(graph,i,vis,recStack)){
                //cyle found ->dependent on each other 
                return false;
            }
        }
        return true;

    }

    private boolean dfs(ArrayList<Integer> graph[],int curr,boolean vis[],boolean recStack[]){
        if(recStack[curr]){
            return true; //cycle found
        }
        if(vis[curr]){
            return false;
        }
        vis[curr]=true;
        recStack[curr]=true;
        for(int neighbour : graph[curr]){
            if(dfs(graph,neighbour,vis,recStack)){
                return true;
            }
        }
        recStack[curr]=false; // backtrack
        return false;
    }
}