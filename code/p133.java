package code;
/*
Utilising a helper function to create clones. The flow is simple we store the original node and its clone right after creating it.
The order matters, if you do not store it before you start recursing the neighbors of the original node you will go into an infinte 
recursive loop. There are two base cases one is for early return which is if you find that the hashmap has the clone meaning
the node has been visited before you return the clone itself. And if you are visiting a new one then iterate through the neighbors run
dfs there as well and add it to the neighbors list. Starting with an empty neighbor list is important instead of storing the neighbors
of the original as this leads to storing the original objects instead of creating a deep copy. 

*/

import java.util.*;


// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


public class p133{
     public static void main(String[] args){
          
        
     }

     public static Node cloneGraph(Node node) {
         if(node == null) {
            return null;
         }

         HashMap<Node , Node> visited = new HashMap<>();
         
         return dfs(node, visited);
     }

     public static Node dfs(Node node, HashMap<Node, Node> visited){
         

        if(visited.containsKey(node)){
            return visited.get(node);
        }

        Node clone = new Node(node.val, new ArrayList<Node>());

        visited.put(node, clone);

        for(Node neighbor: node.neighbors){
            clone.neighbors.add(dfs(neighbor, visited));
        }

        return clone;
     }
     
 
}



 
