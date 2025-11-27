//3381. Maximum Subarray Sum With Length Divisible by K
class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long ans = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            long sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                int length = j - i + 1;

                if (length % k == 0) {
                    ans = Math.max(ans, sum);
                }
            }
        }

        return ans;
    }
}
