package code;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/*
This is a classic monotonic stack application, we use it in problems where we do not have any idea how to get the answer because the 
answer can only be answered by the checking of a future element. SO we store it in a stack why to preserve the chronologicacl order
in which they arrived. And also to preserve the monotonic nature when elemtns are popped or pushed. 
We basically find the next greater element for all the elements in the superset array and then nums1 is a subset so we perform a lookup
and get the final answer.
*/

public class p496 {
   public static void main(String[] args) {
  int[] nums1 = {4,1,2};
    int[] nums2 =  {1,3,4,2};
         
    int[] result = nextGreaterElement(nums1, nums2);
         
    for(int x: result) System.out.print("\t" + x);
   }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0;i<nums2.length;i++){
           map.put(nums2[i], -1);
           while(!stack.isEmpty() && (nums2[i] > stack.peek())){
               int selected = stack.pollFirst();
               map.put(selected, nums2[i]);
           }
           stack.offerFirst(nums2[i]);
        }

        map.forEach((key, value) -> System.out.println(key + "->" + value));
      
        int[] result = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
           result[i] = map.get(nums1[i]);
        }

        return result;
    } 
}
