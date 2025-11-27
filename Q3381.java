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
//the above solving of the question was my approach and it solved the 653/661 test cases.
import java.util.Arrays;

class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 1; i <= n; i++) prefix[i] = prefix[i - 1] + nums[i - 1];

        // min prefix sum seen for each remainder class (index % k)
        long[] minPref = new long[k];
        Arrays.fill(minPref, Long.MAX_VALUE / 4);
        minPref[0] = 0L; // prefix[0] has remainder 0

        long ans = Long.MIN_VALUE;
        for (int r = 1; r <= n; r++) {
            int mod = r % k;
            // possible candidate: prefix[r] - smallest earlier prefix with same mod
            if (minPref[mod] != Long.MAX_VALUE / 4) {
                ans = Math.max(ans, prefix[r] - minPref[mod]);
            }
            // update min prefix for this remainder with current prefix[r]
            if (prefix[r] < minPref[mod]) minPref[mod] = prefix[r];
        }

        return ans;
    }
}
//this is the solution which is provided by chatgpt
