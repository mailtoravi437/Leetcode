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
        
        while(queue.size()>0){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String str = queue.poll();
                char ch[] = str.toCharArray();
                for(int j=0;j<str.length();j++){
                    char tmp = str.charAt(j);
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
                    ch[j] = tmp;
                }
            }
            count+=1;
        }
        
        return 0;
    }
}