class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, tempSum = 0, sum = 0;
        for(int i = 0; i < gas.length; i++) {
            tempSum += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if(tempSum < 0) {
                start = i + 1;
                tempSum = 0;
            }
        }
        return (sum < 0) ? -1 : start;
    }
}