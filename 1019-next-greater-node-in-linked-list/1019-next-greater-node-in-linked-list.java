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
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> res = new ArrayList<>();
        while(head!=null){
            res.add(head.val);
            head = head.next;
        }
        
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[res.size()];
        for(int i=0;i<res.size();i++){
            while(!st.isEmpty() && res.get(st.peek())<res.get(i)){
                ans[st.pop()] = res.get(i);
            }
            
            st.push(i);
        }
        
        return ans;
    }
}