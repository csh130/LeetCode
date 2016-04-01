package BitMunipulation;

import java.util.Arrays;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * */
public class MajorElement {
	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	// Another solution
	public int majorityElement2(int[] nums) {
		int count = 0, majorEle = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == majorEle) {
				count++;
			} else if (count == 0) {
				majorEle = nums[i];
			} else
				count--;

		}
		return majorEle;
	}
}
