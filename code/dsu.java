package code;
public class dsu {
  int n;
   int[] parent;
   
   public dsu(int n ){
       this.n = n;
       parent = new int[n];

       for(int i=0;i<n;i++) parent[i] = -1;

   }

   public void union(int u, int v){

      rootU = find(u);
      rootV = find(v);

      if(rootU != rootV){

         if(parent[rootU] > parent[rootV]){
              parent[rootV] += parent[rootU];
              parent[rootU] = rootV;
         }
         else{
              parent[rootU] += parent[rootV];
              parent[rootV] = rootU;
         }
      }

   }

   public int find(int u){
       if(parent[u] < 0) return u;
       parent[u] = find(parent[u]);\
       return parent[u];
   }
}
