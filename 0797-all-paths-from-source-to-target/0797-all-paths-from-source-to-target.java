class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        ans.add(0);
        sol(0,res,ans,graph);
        return res;
    }
    
    public void sol(int idx,List<List<Integer>> res,List<Integer> ans,int graph[][]){
        if(idx==graph.length-1){
            res.add(new ArrayList<>(ans));
            return;
        }
        
        for(int x : graph[idx]){
            ans.add(x);
            sol(x,res,ans,graph);
            ans.remove(ans.size()-1);
        }
    }
}