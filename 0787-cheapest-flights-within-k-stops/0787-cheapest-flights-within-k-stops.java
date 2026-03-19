class Solution {
    static class Pair{
        int node;
        int cost;
        public Pair(int n,int c){
            this.node=n;
            this.cost=c;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // graph
        ArrayList<Pair> graph[]=new ArrayList[n];        
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int[] f:flights){
            graph[f[0]].add(new Pair(f[1],f[2]));
        }
        int[] dist=new int[n];
        for(int i=0;i<n;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        int stops=0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,0));
        while(!q.isEmpty() && stops<=k){
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair curr = q.poll();
                int u=curr.node;
                int cost=curr.cost;
                for(int j=0;j<graph[u].size();j++){
                    Pair neigh=graph[u].get(j);
                    int v=neigh.node;
                    int wt=neigh.cost;
                    if(cost+wt<dist[v]){
                        dist[v]=cost+wt;
                        q.add(new Pair(v,dist[v]));
                    }
                }
            }
            stops++;
        }
        if(dist[dst]==Integer.MAX_VALUE){
            return -1;
        }else{
            return dist[dst];
        }
    }
}