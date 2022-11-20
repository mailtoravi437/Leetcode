/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> hmap = new HashMap<>();
        Node p = head;
        while(p!=null){
            hmap.put(p,new Node(p.val));
            p = p.next;
        }
        
        Node q = head;
        while(q!=null){
            hmap.get(q).next = hmap.get(q.next);
            hmap.get(q).random = hmap.get(q.random);
            q = q.next;
        }
        
        return hmap.get(head);
    }
}