package code;
public class p11{
  public static void main(String [] args){
    /*
    Container with most water
    */ 
    int h[] = {1,2,3,4};
     int left = 0, right = h.length-1, maxArea = 0;
     while(left<right){
        int curArea = Math.min(h[left],h[right])*(right-left);
        if(h[left]<h[right]) left++;
        else right--;
        if(curArea>maxArea) maxArea = curArea;
     }
    // return maxArea;
  }
}