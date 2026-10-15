package code;
import java.util.ArrayDeque;
import java.util.Deque;


/*
The monotonic stack approach eh. We store the indices of the temperatures we couldnt resolve directly and then we run that on later.
by popping and checking.
*/
public class p739 {
   public static void main(String[] args){
         int[] temperatures = {73,74,75,71,69,72,76,73};
         int[] result = dailyTemperatures(temperatures);

         for(int x: result) System.out.print("\t" + x);

     }
          public static int[] dailyTemperatures(int[] temperatures) {
               int n = temperatures.length;
               int result[] = new int[n];

               Deque<Integer> stack = new ArrayDeque<>();

               for(int i=0;i<n;i++){
                  while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                     int ansIndex = stack.pollFirst();
                     result[ansIndex] = i - ansIndex;
                  }
                  
                  stack.offerFirst(i);
               }
               return result;
          }
     }
/* 
int n = temperatures.length;
          int[] result = new int[n];
          int maxIndex = n-1;
          for(int i= n-2;i>=0;i--){
               if(temperatures[i] < temperatures[i+1]){
                    result[i] = 1;
                    
               }
               else{
                  for(int j = i;j <= maxIndex;j++){
                      if(temperatures[i] < temperatures[j]){
                          result[i] = j-i;
                          break;
                      } 
                  }
               }
               if(temperatures[maxIndex] <= temperatures[i]) maxIndex = i;

          }
          return result;

*/

}
