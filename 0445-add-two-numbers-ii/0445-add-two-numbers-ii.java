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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = listToStack(l1);
        Stack<ListNode> s2 = listToStack(l2);
        
        return addToNum(s1,s2);
    }
    
    public ListNode addToNum(Stack<ListNode> s1,Stack<ListNode> s2){
        Stack<ListNode> s3 = new Stack<>();
        int carry = 0;
        
        while(!s1.isEmpty() && !s2.isEmpty()){
            int firstNum = s1.pop().val;
            int secondNum = s2.pop().val;
            
            int sum = carry+firstNum+secondNum;
            s3.push(new ListNode(sum%10));
            carry = sum/10;
        }
        
        while(!s1.isEmpty()){
            int firstNum = s1.pop().val;
            int sum = carry+firstNum;
            s3.push(new ListNode(sum%10));
            
            carry = sum/10;
        }
        
        while(!s2.isEmpty()){
            int secondNum = s2.pop().val;
            int sum = carry+secondNum;
            s3.push(new ListNode(sum%10));
            
            carry = sum/10;
        }
        
        if(carry>0){
            s3.push(new ListNode(carry));
        }
        
        ListNode head = null;
        ListNode temp = head;
        
        while(!s3.isEmpty()){
            ListNode node = s3.pop();
            if(head==null){
                head = node;
                temp = head;
            }
            else{
                temp.next = node;
                temp = temp.next;
            }
        }
        
        return head;
    }
    
    public Stack<ListNode> listToStack(ListNode head){
        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;
        while(temp!=null){
            st.push(temp);
            temp = temp.next;
        }
        
        return st;
    }
}