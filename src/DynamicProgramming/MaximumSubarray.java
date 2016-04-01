package DynamicProgramming;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray
 * [4,−1,2,1] has the largest sum = 6.
 * */
public class MaximumSubarray {
	public MaximumSubarray() {
		// TODO Auto-generated constructor stub
	}

	public int maxSubArray(int[] nums) {
		int max = nums[0];
		int maxEnd = nums[0];
		for (int i = 1; i < nums.length; i++) {
			// 如果加上nums[i] 比nums[i]大, 更新maxEnd ,如果 maxEnd 加上 nums[i]比 nums[i]小,
			// 就让 maxEnd 等于 nums[i]
			maxEnd = Math.max(maxEnd + nums[i], nums[i]);
			// 存最大值
			max = Math.max(max, maxEnd);

		}
		return max;
	}

	// My solution
	public int maxSubArray2(int[] nums) {
		int cur = 0, max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			// more efficient way
			cur = nums[i] < cur + nums[i] ? cur + nums[i] : nums[i];
			max = Math.max(cur, max);
		}
		return nums.length == 0 ? 0 : max;
	}

}
