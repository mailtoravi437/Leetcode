class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = 0;
        int extraFuel = 0;
        int requiredFuel = 0;
        
        for(int i=0;i<n;i++){
            extraFuel += gas[i]-cost[i];
            
            if(extraFuel<0){
                requiredFuel += extraFuel;
                start = i+1;
                extraFuel = 0;
            }
        }
        
        return extraFuel+requiredFuel>=0?start:-1;
            
    }
}