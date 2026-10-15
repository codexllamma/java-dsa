package code;
/*
Ok well lets see what we have here. Basically we have to merge accounts on the basis of an equivalence relation. Whenever you encounter
an equivalence relation we use disjoint sets for that. Now firstly basic implementation of a disjoint set. Now what exactly are we
treating as nodes or vertices for disjoint sets it is basically their are layers to this problem. We first need to discover the 
edges then we need to process the edges and finally we need to construct the output. 
Alright now to discover the edges we use a 
hashmap in which we store email -> index simply because email is the unique identifier as well as the basis of the equivalence 
relation on the nodes. Then if an email appears that has already appeared in a previous account we know that so we perform union to 
unionise those two accounts and bring it into one set, this is why we store indices because we can acess all the information via indices.

Now once we have performed the union we will have different nodes basically we will have parent array to know which ones are unique and
which one are same as the others. Then we create a list of treesets. Now what exactly are treesets, they are basically hashsets
but with lexographical order storing or sorted order storing along with avoiding duplicates. 
HashSet has o(1) lookup, TreeSet has O(log n) lookup. It is implemented in the backend using a red black tree. 

Finally we take the names of the root node from the accounts array store it all in result and return result.
A really good problem that taught me a lot of things.

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


public class p721{
   public static void main(String[]args){
     String[][] arr = {
      {"John","johnsmith@mail.com","john_newyork@mail.com"},
      {"John","johnsmith@mail.com","john00@mail.com"},
      {"Mary","mary@mail.com"},
      {"John","johnnybravo@mail.com"}
   };
 
      List<List<String>> accounts = new ArrayList<>();
      for(String[] account: arr) accounts.add(Arrays.asList(account));

      List<List<String>> result = accountsMerge(accounts);


   }

   public static List<List<String>> accountsMerge(List<List<String>> accounts) {
      int n = accounts.size();

      DSU dsu = new DSU(n);

      HashMap<String, Integer> map = new HashMap<>();

      for(int i=0;i<n;i++){
         for(int j=1;j<accounts.get(i).size();j++){
            String email =  accounts.get(i).get(j);
            if(map.containsKey(email)){
                 dsu.union(i, map.get(email));
                 continue;
            }
            map.put(email, i);

         }
      }

      for(int x: dsu.parent) System.out.print("\t" + x);

      /*
      1       -2      -1      -1
      johnnybravo@mail.com -> 3
      johnsmith@mail.com -> 0
      john00@mail.com -> 1
      john_newyork@mail.com -> 0
      mary@mail.com -> 2
       
      */

      List<TreeSet<String>> emails = new ArrayList<>();

      for(int i=0;i<n;i++) emails.add(new TreeSet<>());

      for(int i=0;i<n;i++){
          int root = dsu.find(i);
          for(int j=1;j<accounts.get(i).size();j++){
            String email = accounts.get(i).get(j);   
            emails.get(root).add(email);
          }

      }

      List<List<String>> result = new ArrayList<>();


      for(int i=0;i<emails.size();i++){
          if(!emails.get(i).isEmpty()){
            List<String> merged =  new ArrayList<>();
            merged.add(accounts.get(i).get(0));
             for(String email: emails.get(i)){
                merged.add(email);
             }
             result.add(merged);
          }
      }

      System.out.println(result);

      
      return result;
   }

}
