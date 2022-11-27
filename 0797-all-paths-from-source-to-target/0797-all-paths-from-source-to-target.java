class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        
        res.add(0);
        sol(0,ans,res,graph);
        return ans;
    }
    
    public void sol(int idx,List<List<Integer>> ans,List<Integer> res,int graph[][]){
        if(idx==graph.length-1){
            ans.add(new ArrayList<>(res));
            return;
        }
        
        for(int x : graph[idx]){
            res.add(x);
            sol(x,ans,res,graph);
            res.remove(res.size()-1);
        }
    }
}