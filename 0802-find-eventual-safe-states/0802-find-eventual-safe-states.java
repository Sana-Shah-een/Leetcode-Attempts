class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length; //count the length(vertices)of graph

        boolean vis[]=new boolean[n];
        boolean path[]=new boolean[n];
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!dfs(graph,i,vis,path)){
                list.add(i);
            }
        }
        return list;
    }
    private static boolean dfs(int[][] graph,int curr,boolean vis[],boolean path[]){
        if(path[curr]){
            return true;
        }
        if(vis[curr]){
            return false;
        }
        vis[curr]=true;
        path[curr]=true;

        for(int neigh : graph[curr]){
            if(dfs(graph,neigh,vis,path)){
                return true; //cycle
            }
        }
        path[curr]=false; //backtrack
        return false; 
    }
}