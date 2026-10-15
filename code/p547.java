package code;
/*
Well the problem basically asks for number of disjoint sets to be specific, the weighted union operation handles transitivity closure 
for you. If you draw the isConnected matrxi for any given input you will notice that it is asymmetric matrix and you dont need to use
a diagonal elements, also you dont need to scan the last row as well, so you do for(i=0; i<n-1) for (j=i+1;j<n) simple easy avoids
redundant calls, also you dont need to implement and change the function signature again and again, you can ignore a returned value in
java while still performing the operations in that function something to keep in mind for later.
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

public class p547{
   
   public static void main(String[]args){

      int[][] isConnected = {{1,1,0,0,0},{1,1,1,0,0},{0,1,1,0,0},{0,0,0,1,1},{0,0,0,1,1}};

      int result = findCircleNum(isConnected);

      System.out.println("Result: " + result);

   }


   public static int findCircleNum(int[][] isConnected) {
        
      int n = isConnected.length;
      DSU dsu = new DSU(n);

      for(int i=0;i<n-1;i++){
         for(int j=i+1;j<n;j++){
            if(isConnected[i][j] == 1){
               dsu.union(i,j);
            }
         }
      }

      int count = 0;
      for(int i=0;i<n;i++){
         if(dsu.parent[i] < 0) count++;
      }

      return count;
   }

}


