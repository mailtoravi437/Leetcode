class Solution {
        int res = 0;

    public int countMaxOrSubsets(int[] nums) {
         int mOR = 0;
        for (int i = 0; i < nums.length; ++i)
            mOR |= nums[i];
        // mOR is now the maximum bitwise OR.
        maxSubset(nums, 0, 0, mOR);
        return res;
    }
    private void maxSubset(int[] arr, int i, int curOr, int maxOr) {
        if (i == arr.length) {
            if (curOr == maxOr)
                ++res;
            return;
        }
        maxSubset(arr, i + 1, curOr | arr[i], maxOr); // include it
        maxSubset(arr, i + 1, curOr, maxOr); // skip it
    }
}