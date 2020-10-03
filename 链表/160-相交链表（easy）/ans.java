public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        ListNode lA,lB;
        while(headA != headB){
            if(headA != null){
                headA = headA.next;
            }else{
                headA = pB;
            }
            if(headB != null){
                headB = headB.next;
            }
            else{
                headB = pA;
            }
        }
        return headA;
    }
}