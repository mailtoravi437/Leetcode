class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> repeated = new HashSet<>();
        HashSet<String> seen = new HashSet<>();
        for(int i=0;i+9<s.length();i++){
            String ten = s.substring(i,i+10);
            if(!seen.add(ten)){
                repeated.add(ten);
            }
        }
        
        return new ArrayList<>(repeated);
    }
}