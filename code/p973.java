package code;
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
    PriorityQueue<int[]> heap = new PriorityQueue<>(
    (a,b) -> Integer.compare( ( b[0]*b[0] + b[1]*b[1]) , (a[0]*a[0] + a[1]*a[1])));

    for(int[] cur : points){
        heap.offer(cur);
        if(heap.size() > k){
            heap.poll();
        }
    }    

    int result[][] = new int[k][2];
    for(int i=k-1;i>=0;i--){
        result[i] = heap.poll();
    }
    
    return result;
        
    }
}