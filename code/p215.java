package code;
public class p215 {
    public static void main(String[] args){
       
      
       int[] nums = {3,2,1,5,6,4};
       int k = 2;
       int result =  findKthLargest(nums,k);
       
       System.out.println("Result : " + result);
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> a-b);

        for(int num: nums){
            heap.offer(num);
            if(heap.size() > k){
              heap.poll();
            }
        }

        return heap.poll();

    }

}
