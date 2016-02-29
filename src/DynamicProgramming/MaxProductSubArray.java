package DynamicProgramming;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * 
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has
 * the largest product = 6.
 * 
 * */
public class MaxProductSubArray {
	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] { -4, -3 }));
	}

	public static int maxProduct(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		//分大于0 小于0的情况 讨论,.存max min value
		int cur_max = nums[0];
		int cur_min = nums[0];
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] >= 0) {
				// 如果数>=0
				cur_min = Math.min(nums[i], cur_min * nums[i]);
				cur_max = Math.max(nums[i], cur_max * nums[i]);
			} else {
				// 如果小于0. 最小值  用当前最大值 乘以这个数字
				int tempMax = cur_max;
				cur_max = Math.max(nums[i], cur_min * nums[i]);
				cur_min = Math.min(nums[i], tempMax * nums[i]);
			}

			max = Math.max(max, cur_max);
		}
		return max;
	}
}
