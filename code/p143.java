package code;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class p143 {
    public void reorderList(ListNode head) {

        ListNode cur = head;
        ListNode next = new ListNode();
        ListNode end = new ListNode();
        ListNode endPrev = new ListNode();
        
        if(head!= null && head.next != null ){
            endPrev = cur;
            end = endPrev.next;
        }

        while(cur != end){
            endPrev = cur;
            end = endPrev.next;
            while(end!= null && end.next!= null){
                endPrev = end;
                end = end.next;
            }
            if(cur.next!=null){
                next = cur.next;
                end.next = cur.next;
                cur.next = end;
                endPrev.next = null;
                cur = next;
                
            }
        }
        

        
    }
}
