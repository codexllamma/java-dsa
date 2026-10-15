package code;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class p621 {
  public static void main(String[] args){
         
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        int result = leastInterval(tasks,n);
        System.out.println("Result: " + result);
    }

    public static int leastInterval(char[] tasks, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        
        for(char x: tasks){
            int numIndex = x - 'A';
            map.put(numIndex, map.getOrDefault(numIndex, 0) + 1);
        }

        map.forEach((key,value) -> System.out.println(key + " -> " + value ));
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            heap.offer(new int[] {entry.getKey(), entry.getValue()});
        }
        
        Deque<int[]> queue = new ArrayDeque<>();
        List<Character> sequence = new ArrayList<>();
        int curTime = 0, completed = 0;
        

        while(completed != tasks.length){
            
            while(!queue.isEmpty() && queue.peek()[2] == curTime){
                int[] selected = queue.pollFirst();
                heap.offer(new int[] {selected[0], selected[1]});
                
            }

            if(heap.isEmpty()){
                sequence.add(' ');
            }
            else{
                int[] selected = heap.poll();
                sequence.add((char)(selected[0] + 'A'));
                if(selected[1] != 1){
                   queue.offerLast(new int[] {selected[0], selected[1] - 1, curTime + n + 1});
                }
                completed++;
            }
                curTime++;
             
            System.out.println("Current Time: " + curTime);
            for(int[] ele: queue){
                System.out.println("Task: " + (ele[0] + 'A') + " Remaining Frequencies: " + ele[1] + " Available At: " + ele[2]);
            }
            
        }
        
        for(char c: sequence){
            if(c == ' '){
                System.out.print("Idle ->");
            } 
            else{
                System.out.print(c + " -> ");
            }

        }
        return curTime;
        
    } 
}
