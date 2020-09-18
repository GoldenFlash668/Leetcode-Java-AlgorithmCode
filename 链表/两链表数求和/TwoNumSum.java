/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /*总结：感觉大体思路比较正确，就是步骤太繁琐，比起标准答案复杂了太多太多*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode num = l3;
        int sum,x,y = 0;
        while (l1!=null && l2!=null){
            sum = l1.val + l2.val + y;
            x = sum%10;
            y = sum/10;
            num.next = new ListNode(x);
            num = num.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1!=null){
            x = l1.val;
            if(y==1){
                x = x+1;
                if (x==10){
                    x=0;
                    y=1;
                }
                else {
                    y=0;
                }
            }
            num.next = new ListNode(x);
            num = num.next;
            l1 = l1.next;
        }
        while (l2!=null){
            x = l2.val;
            if(y==1){
                x = x+1;
                if (x==10){
                    x=0;
                    y=1;
                }
                else {
                    y=0;
                }
            }
            num.next = new ListNode(x);
            num = num.next;
            l2 = l2.next;
        }
        if(y!=0){
            num.next = new ListNode(y);
            num = num.next;
        }
    return l3.next;
    }
}