package code;

import java.util.PriorityQueue;

/*

*/

public class p1046 {
  public static void main(String[] args){
       
      
       int[] stones = {2,7,4,1,8,1};
       int result = lastStoneWeight(stones);
       System.out.println("Result : " + result);
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b-a);
        for(int x: stones){
            heap.offer(x);
        }
        
        while(heap.size() > 1){
            int x = heap.poll();
            int y = heap.poll();

            if(! (Math.abs(x-y) == 0)){
                heap.offer(Math.abs(x-y));
            }
        }

        if(heap.size() == 0 ) return 0;
        return heap.poll();
    }
}
