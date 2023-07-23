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
    public ListNode rotateRight(ListNode head, int k) {

       if(head==null || head.next==null || k==0){
           return head;
       }

       ListNode curr = head;
       int len=1;
       while(curr.next!=null){
           curr=curr.next;
           len++;
       }

       curr.next=head;
       k=len-k%len;

       while(k>0){
           curr=curr.next;
           k--;
       }

       head = curr.next;
       curr.next=null;

       return head;

    }
}