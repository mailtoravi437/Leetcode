class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        
        
        for(int interval[] : intervals){
            if(res.isEmpty() || res.get(res.size()-1)[1]<interval[0]){
                res.add(interval);
            }
            else{
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1],interval[1]);
            }
        }
        
        int ans[][] = new int[res.size()][2];
        
        for(int i=0;i<res.size();i++){
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }
        
        return ans;
    }
}