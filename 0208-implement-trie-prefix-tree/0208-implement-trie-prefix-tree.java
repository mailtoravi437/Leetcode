class Trie {
    class Node{
        Node child[];
        boolean isEnd;
        Node(){
            child = new Node[26];
        }
    }
    
    Node root;

    public Trie() {
        root = new Node(); 
    }
    
    public void insert(String word) {
        Node curr = root;
        int level;
        int length = word.length();
        int index;
        
        for(level=0;level<length;level++){
            index = word.charAt(level)-'a';
            if(curr.child[index]==null){
                curr.child[index] = new Node();
            }
            
            curr = curr.child[index];
        }
        
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        int level;
        int length = word.length();
        int index;
        for(level=0;level<length;level++){
            index = word.charAt(level)-'a';
            if(curr.child[index]==null){
                return false;
            }
            
            curr = curr.child[index];
        }
        
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
         Node curr = root;
        int level;
        int length = prefix.length();
        int index;
        for(level=0;level<length;level++){
            index = prefix.charAt(level)-'a';
            if(curr.child[index]==null){
                return false;
            }
            
            curr = curr.child[index];
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */