package Array;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * */
public class SingleNumber {
	// use bit manipulation
	public class Solution {
		public int singleNumber(int[] nums) {
			int result = 0;
			for (int i = 0; i < nums.length; i++) {
				//  n1=n2, n1^=n2, n1=0  if n1!=n2, n1^=n2 n1=n1;
				result ^= nums[i];
			}
			return result;
		}
	}
}
