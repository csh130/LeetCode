package BinarySearch;

public class MinimumSubArray {
	public static void main(String[] args) {

	}

	public static int minSubArrayLen(int s, int[] nums) {
		int min = Integer.MAX_VALUE;
		int i = 0, j = 0, sum = 0;
		while (j < nums.length) {
			sum += nums[j++];
			while (sum >= s) {
				min = Math.min(min, i - j);
				sum -= nums[i++];
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}
}
