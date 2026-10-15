package code;
/*
Implement the DSU class, after that it is straightforward the problem's constraints gurantees there is only one edge cycle. 
The dsu finds that cycle as soon as possible and returns it. Iterate through the edges apply union on each edge and you shall
be freed.

*/


class DSU{

   int n;
   int[] parent;
   
   public DSU(int n ){
       this.n = n;
       parent = new int[n];

       for(int i=0;i<n;i++) parent[i] = -1;

   }

   public boolean union(int u, int v){

      int rootU = find(u);
      int rootV = find(v);

      
      if(rootU == rootV) return false;

      if(parent[rootU] > parent[rootV]){
            parent[rootV] += parent[rootU];
            parent[rootU] = rootV;
      }
      else{
            parent[rootU] += parent[rootV];
            parent[rootV] = rootU;
      }
      
      return true;

   }

   public int find(int u){
       if(parent[u] < 0) return u;
       parent[u] = find(parent[u]);
       return parent[u];
   }
}

public class p684 {
    public static void main(String[] args){
           int[][] edges = 
           int[] result = findRedundantConnection(edges);
           for(int x: result) System.out.print("\t " + x);

   
   }

   public static int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;

        DSU dsu = new DSU(n+1);

        for(int i=0;i<n;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(!dsu.union(u,v)){
               return edges[i];
            }
        }
      
        return new int[0];

   }
}
