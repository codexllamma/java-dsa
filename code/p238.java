package code;
public class p238 {
  public static void main(String[] args){
      /*
      Product of array except self. For each elemnt we need to find the product of the right side and product of the left side
      and multipl them and find the final answer. So we perform two passes one to calculate the left pass product and then another
      pass to calculate the right side product.Two passes are required so that the time complexity comes out to be O(n).\
      Also in the problem it explicitly states that do not use division, it is not just done to improve handling of zeroes in this 
      Zeroes naturally propagate through mulitlicaiotn but division may cause issues.
      */
    int nums[] =  {1,2,3,4};
    int result[] = new int[nums.length];
      int leftProduct = 1;
      for(int i = 0;i<nums.length;i++){
         result[i] = leftProduct;
         leftProduct *= nums[i];

      }
      for(int x : result) System.out.println("\t"+x);
      int rightProduct = 1;
      for(int i=nums.length-1;i>=0;i--){
         result[i] *= rightProduct;
         rightProduct *= nums[i];
      }
      for(int x : result) System.out.println("\t"+x);
  }
}
