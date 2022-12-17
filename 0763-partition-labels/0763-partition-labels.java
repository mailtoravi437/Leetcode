class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        HashMap<Character,Integer> hmap = new HashMap<>();
        
        for(int i=0;i<n;i++){
            hmap.put(s.charAt(i),i);
        }
        
        List<Integer> res = new ArrayList<>();
        
        int start = -1;
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max,hmap.get(s.charAt(i)));
            if(max==i){
                res.add(max-start);
                start = max;
            }
        }
        
        return res;
        
    }
}