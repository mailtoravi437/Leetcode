class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> l = new ArrayList<>();
        HashMap<Character,String> hmap = buildMap();
        if(digits.length()==0){
            return l;
        }
        
        solve(digits,0,hmap,l,"");
        return l;
    }
    
    public void solve(String digits,int index,HashMap<Character,String> hmap,List<String> l,String ans){
        if(index==digits.length()){
            l.add(ans);
            return;
        }
        
        String letters = hmap.get(digits.charAt(index));
        
        for(int i=0;i<letters.length();i++){
            String newans = ans + letters.charAt(i);
            solve(digits,index+1,hmap,l,newans);
        }
    }
    
    public HashMap<Character,String> buildMap(){
        HashMap<Character,String> hmap = new HashMap<>();
        hmap.put('2',"abc");
        hmap.put('3',"def");
        hmap.put('4',"ghi");
        hmap.put('5',"jkl");
        hmap.put('6',"mno");
        hmap.put('7',"pqrs");
        hmap.put('8',"tuv");
        hmap.put('9',"wxyz");
        
        return hmap;
    }
}