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
    public ListNode reverseList(ListNode head) {
      
        ListNode temp=head;
        ListNode curr=null;
       
        while(temp!=null){
head=head.next;
temp.next=curr;
curr=temp;
temp=head;
        }
        return curr;
    }

}