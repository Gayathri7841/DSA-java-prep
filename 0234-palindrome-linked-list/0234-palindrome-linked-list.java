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
    public boolean isPalindrome(ListNode head) {
      if(head == null || head.next == null) return true;
       ListNode slow=head;
       ListNode fast=head;
       while(fast.next!=null&&fast.next.next!=null){
        slow=slow.next;
        fast=fast.next.next;
       }
       ListNode newhead=slow.next;
       slow.next=null;
       ListNode prev=null;
       ListNode current=newhead;
       while(current!=null){
        ListNode next=current.next;
        current.next=prev;
        prev=current;
        current=next;
       }
       newhead=prev;
       ListNode temp1=newhead;
      ListNode temp=head;
       while(temp!=null&&temp1!=null){
        if(temp.val!=temp1.val){
            return false;
        }
        temp=temp.next;
        temp1=temp1.next;
       }
       return true;
    }
}