class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int count = 1;
        Set<String> hset = new HashSet<>(wordList);
        if(!hset.contains(endWord)){
            return 0;
        }
        
        if(beginWord.equals(endWord)){
            return 1;
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String temp = queue.poll();
                char ch[] = temp.toCharArray();
                
                for(int j=0;j<ch.length;j++){
                    char temp1 = ch[j];
                    
                    for(char c='a';c<='z';c++){
                        ch[j] = c;
                        String newWord = String.valueOf(ch);
                        if(hset.contains(newWord)){
                            if(newWord.equals(endWord)){
                                return count+1;
                            }
                            
                            queue.add(newWord);
                            hset.remove(newWord);
                        }
                    }
                    
                    ch[j] = temp1;
                }
            }
            count+=1;
        }
        
        return 0;
    }
}