package code;
/*
The problem boils down to cycle detection because if there exists a cycle that makes it impossible to take all courses, 
because if there are no prerequisites any course can be taken if there are prequiisites they must be transitive in nature or branched
never cyclic. 
Firstly we create an adjacency list, basically it stores edge vertices relationship, keep it simple you can do two representations
either the index represents incoming edges or outgoing edges(because reversing all the edges preserves cycles) either way if there are multiple incoming you will add it in a list with that
index and if the vertex itself is an incoming for many add them to each and every list. Sort of like a many to may relationship mapping
Then we create two ararys one for seeing which vertices are already visited another one to see which vertices are on the recursion 
stack, if you are visiting an element which is on the recursion stack it is a cycle recurse false and backpropagate that shit.
Make sure that the dfs call owns the marking of the visited and recStack arrays. For each vertex check if the neighbor is worth doing dfs
if already visited skip that if visted and on recursion stack as well return false else go ahead and do dfs.

Below the first implemenation you will see an implemenation of 3 state course schedule not many changes just instead of two arrays, 
we utilise a single array with three states , 0 -> not visited, 1-> visiting and on recursion stack , 2-> visited and not on recursion stack

This reduces space overhead and well is also a valid and cleaner solution.
*/

public class p207{
  
  public static void main(String[] args){
       
        int[][] prereq = {{0,1}, {1,2}, {1,3}, {2,4}};
        // ,{4,2} for cycle
        int numCourses = 5;
        boolean result = canFinish(numCourses, prereq);
  
        System.out.println("Result: " + result);
          
       }
  
      
       public static boolean canFinish(int numCourses, int[][] prerequisites){
            List<List<Integer>> list = new ArrayList<>();
            
            for(int i=0;i<numCourses;i++) list.add(i, new ArrayList<>());
  
            for(int i=0;i<prerequisites.length;i++){
                list.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
  
            int[] visited = new int[numCourses];
            int[] recStack = new int[numCourses];
  
            for(int i=0;i<numCourses;i++){
                if(!(visited[i] == 1)){
                   if(!dfs(i, visited, recStack, list)) return false;
                }
            }
  
            return true;
  
  
       }
  
       public static boolean dfs(int index, int[] visited, int[] recStack, List<List<Integer>> list){
           visited[index] = 1;
           recStack[index] = 1;
           
           for(int i=0;i<list.get(index).size();i++){
              int neighbor = list.get(index).get(i);
              if(visited[neighbor] == 1 && recStack[neighbor] == 1) return false;
              if(visited[neighbor] == 1) continue;
              if(!dfs(neighbor, visited, recStack, list)) return false;
           }
  
           recStack[index] = 0;
           return true;
  
       }
       
}

/*
public static boolean canFinish(int numCourses, int[][] prerequisites){
          List<List<Integer>> list = new ArrayList<>();
          
          for(int i=0;i<numCourses;i++) list.add(i, new ArrayList<>());

          for(int i=0;i<prerequisites.length;i++){
              list.get(prerequisites[i][1]).add(prerequisites[i][0]);
          }

          int[] visited = new int[numCourses];

          for(int i=0;i<numCourses;i++){
              if(!(visited[i] == 2)){
                 if(!dfs(i, visited ,list)) return false;
              }
          }

          return true;


     }

     public static boolean dfs(int index, int[] visited, List<List<Integer>> list){
         visited[index] = 1;
         
         for(int i=0;i<list.get(index).size();i++){
            int neighbor = list.get(index).get(i);
            if(visited[neighbor] == 1) return false;
            if(visited[neighbor] == 2) continue;
            if(!dfs(neighbor, visited, list)) return false;
         }

         visited[index] = 2;
         return true;

     }
*/