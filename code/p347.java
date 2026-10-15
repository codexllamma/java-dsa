package code;
public class 347{
      public int[] topKFrequent(int[] nums, int k) {
        
        
        //This is the baseline solution which gives us o(n log n);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x:nums){
            map.put(x, map.getOrDefault(x,0)+1);
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b) -> b.getValue() - a.getValue());

        int result[] = new int[k];
        for(int i=0;i<k;i++){
            result[i] = list.get(i).getKey();
        }
        return result;
         
        //This is the min heap solution which gives us o(n log k) tc;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
           heap.offer(entry.getValue(), entry.getKey());

           if(heap.size()>k){
            heap.poll();
           }
        }

        int result[] =new int[k];
        for(int i=0;i<k;i++){
          result[i] = heap.poll()[1];
        }
        return result;
        

        //Now to get a o(n) time complexity we implement bucket sort. Basically we index based on frequencies.
        // buckets[0] contains numbers in the array with frequency 0, buckets[1] contains numbers with frequency 1 and so on
        // this gives us natural ordering via indexes. and then we just take the top k elements.

        //bucket creation logic
        List<Integer> [] bucket = new List[nums.length-1];
        for(int key: map.keySet()){
           int frequency = map.get(key);
           if(buckets[frequency] == null){ 
              bucket[frequency] = new ArrayList<>();
           }
           bucket[frequency].add(key);
        }
        
        //bucket retrieval logic
        int result[] = new int[k];
        int counter = 0;
        for(int pos= buckets.length-1; pos >=0 && counter < k; pos--){
            if(bucket[pos] != null){
               for(int num : bucket[pos]){
                 result[counter++] = num;
                 if(counter == k) break;
               }
            }
        }
        return result;

}
}