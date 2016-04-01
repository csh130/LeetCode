package TwoPointers;

/**
 * 209. Minimum Size Subarray Sum Given an array of n positive integers and a
 * positive integer s, find the minimal length of a subarray of which the sum ≥
 * s. If there isn't one, return 0 instead. For example, given the array
 * [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the
 * problem constraint.
 * */
public class MinimumSizeSubArray {
	public static void main(String[] args) {

	}

	public static int minSubArrayLen(int s, int[] nums) {
		// use two pointer, since the array all are positive integer,
		int left = 0, right = 0, min = Integer.MAX_VALUE, sum = 0;
		while (right < nums.length) {
			sum += nums[right++];
			while (sum >= s) {
				sum -= nums[left++];
				min = Math.min(min, right - left + 1);

			}

		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}
}
