class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        
        HashMap<Character,String> hmap = new HashMap<>();
        hmap.put('2',"abc");
        hmap.put('3',"def");
        hmap.put('4',"ghi");
        hmap.put('5',"jkl");
        hmap.put('6',"mno");
        hmap.put('7',"pqrs");
        hmap.put('8',"tuv");
        hmap.put('9',"wxyz");
        
        StringBuilder sb = new StringBuilder();
        sol(0,digits,hmap,sb,res);
        return res;
    }
    
    public void sol(int idx,String digits,HashMap<Character,String> hmap,StringBuilder sb,List<String> res){
        if(idx==digits.length()){
            res.add(sb.toString());
            return;
        }
        
        String curr = hmap.get(digits.charAt(idx));
        for(int k=0;k<curr.length();k++){
            sb.append(curr.charAt(k));
            sol(idx+1,digits,hmap,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}