package DynamicProgramming;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * */
public class MaxRob {

	public class MySolution {
		public int rob(int[] nums) {
			int d[] = new int[nums.length];
			int len = nums.length;
			if (len == 0)
				return 0;
			if (len == 1)
				return nums[0];
			if (len == 2)
				return Math.max(nums[0], nums[1]);
			if (len == 3)
				return Math.max(nums[1], nums[0] + nums[2]);
			d[0] = Math.max(nums[0], nums[1]);
			d[1] = Math.max(nums[0], nums[1]);
			d[2] = Math.max(nums[1], nums[0] + nums[2]);

			for (int i = 3; i < len; i++) {
				d[i] = Math.max(d[i - 2], d[i - 3]) + nums[i];
			}
			return Math.max(d[len - 1], d[len - 2]);
		}
	}

	public int rob(int[] num) {
		int rob = 0; // max monney can get if rob current house
		int notrob = 0; // max money can get if not rob current house
		for (int i = 0; i < num.length; i++) {
			int currob = notrob + num[i]; // if rob current value, previous
											// house must not be robbed
			notrob = Math.max(notrob, rob); // if not rob ith house, take the
											// max value of robbed (i-1)th house
											// and not rob (i-1)th house
			rob = currob;
		}
		return Math.max(rob, notrob);
	}

	// Simple solution o(1)
	public class Solution {
		public int rob(int[] nums) {
			int current = 0, last = 0, last2 = 0, last3 = 0;
			for (int n : nums) {
				current = n + Math.max(last2, last3);
				last3 = last2;
				last2 = last;
				last = current;
			}
			return Math.max(last, last2);
		}
	}

	public static int rob2(int[] nums) {
		int ifRobbedPrevious = 0; // max monney can get if rob current house
		int ifDidntRobPrevious = 0; // max money can get if not rob current
									// house

		// We go through all the values, we maintain two counts, 1) if we rob
		// this cell, 2) if we didn't rob this cell
		for (int i = 0; i < nums.length; i++) {
			// If we rob current cell, previous cell shouldn't be robbed. So,
			// add the current value to previous one.
			int currRobbed = ifDidntRobPrevious + nums[i];

			// If we don't rob current cell, then the count should be max of the
			// previous cell robbed and not robbed
			int currNotRobbed = Math.max(ifDidntRobPrevious, ifRobbedPrevious);

			// Update values for the next round
			ifDidntRobPrevious = currNotRobbed;
			ifRobbedPrevious = currRobbed;
		}

		return Math.max(ifRobbedPrevious, ifDidntRobPrevious);
	}
}
