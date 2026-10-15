package code;
public class p125 {
    public static void main(String s){
        /*
        Valid Palindromes
        */
        char string[] = s.toCharArray();
        int left = 0, right = string.length-1;
        while(left<right){

          if(Character.isLetterOrDigit(string[right]) && Character.isLetterOrDigit(string[left])){
                if (Character.toLowerCase(string[right]) == Character.toLowerCase(string[left])){
                    right--;
                    left++;
                }
                else{
                  //return false;
                }
          }
                else if(!Character.isLetterOrDigit(string[right])){
                  right--;
                }
                else if(!Character.isLetterOrDigit(string[left])){
                  left++;
                }
                
        }
        // return true;
      }
      }
    

