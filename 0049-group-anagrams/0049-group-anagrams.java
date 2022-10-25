class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hmap = new HashMap<>();
        
        for(int i=0;i<strs.length;i++){
            String str = strs[i];
            char ch[] = str.toCharArray();
            Arrays.sort(ch);
            
            String str1 = String.valueOf(ch);
            
            if(hmap.containsKey(str1)){
                hmap.get(str1).add(str);
            }
            else{
                hmap.put(str1,new ArrayList<>());
                hmap.get(str1).add(str);
            }
        }
        
        return new ArrayList<>(hmap.values());
    }
}