package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 80. Remove Duplicates from Sorted Array II My Submissions Question Total
 * Medium Follow up for"Remove Duplicates": What if duplicates are allowed at
 * most twice?
 * 
 * For example, Given sorted array nums = [1,1,1,2,2,3], Your function should
 * return length = 5, with the first five elements of nums being 1, 1, 2, 2 and
 * 3. It doesn't matter what you leave beyond the new length.
 * */
public class RemoveDuplicateFromArray2 {
	public int removeDuplicates(int[] nums) {
		if (nums.length <= 2)
			return nums == null ? 0 : nums.length;
		int count = 1, start = 1, newLen = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[start++] = nums[i];
				newLen++;
				count = 1;
			} else {
				if (count < 2) {
					nums[start++] = nums[i];
					count++;
					newLen++;
				}
			}
		}
		return newLen;
	}

	// Concise solution
	public int removeDuplicates2(int[] nums) {
		List<Integer> t = (ArrayList) Arrays.asList(nums);
		int i = 0;
		for (int n : nums)
			if (i < 2 || n > nums[i - 2])
				nums[i++] = n;
		return i;
	}
}
