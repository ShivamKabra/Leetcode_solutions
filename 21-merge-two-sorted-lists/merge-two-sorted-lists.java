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
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
         ListNode t1=list1, t2=list2;
         ListNode head=null, tail=null;
         if(t1==null){
             return t2;
         }
         if(t2==null){
             return t1;
         }
         if(t1.val<=t2.val){
             head=t1;
             tail=t1;
             t1=t1.next;
         }else{
             head=t2;
             tail=t2;
             t2=t2.next;
         }

         while(t1!=null && t2!=null){
             if(t1.val<=t2.val){
                 tail.next=t1;
                 tail=t1;
                 t1=t1.next;
             }else{
                 tail.next=t2;
                 tail=t2;
                 t2=t2.next;
             }
         }

         if(t1!=null){
             tail.next=t1;
             tail=t1;
             //tail.next=null;
         }else{
             tail.next=t2;
             tail=t2;
             //tail.next=null;
         }
         return head;
    }
}