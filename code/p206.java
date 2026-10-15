package code;
/*

Pay close attention to initialisation of the pointers, understandable since it was kinda hazy.
*/


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class p206{
      public static void main(String[] args){

      }

      public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null){
         return head;
        }
        if(head.next.next == null){
            ListNode current = head.next;
            current.next = head;
            head.next = null;
            return current;
        }

        
        ListNode prev = null;
        ListNode current = head;
        

        while( current!= null ){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        
        return prev;
    }


    
}
