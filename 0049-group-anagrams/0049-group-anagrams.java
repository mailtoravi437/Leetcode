class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hmap = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String str = strs[i];
            char ch[] = str.toCharArray();
            Arrays.sort(ch);
            String ans = String.valueOf(ch);
            
            if(hmap.containsKey(ans)){
                hmap.get(ans).add(str);
            }
            else{
                hmap.put(ans,new ArrayList<String>());
                hmap.get(ans).add(str);
            }
        }
        
        return new ArrayList<>(hmap.values());
    }
}