package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * difference between i and j is at most k.
 * */

public class ContainsDuplicate219 {
	public static void main(String[] args) {
		ContainsDuplicate219 c = new ContainsDuplicate219();
		System.out.println(c.containsNearbyDuplicate(
				new int[] { 1, 2, 3, 4, 2 }, 3));
	}

	/*
	 * ????????????array run time error?? ??????????????
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			Integer old = map.put(nums[i], i);
			if (old != null && i - old <= k)
				return true;
		}
		return false;
	}

	public class Solution {
		public boolean containsNearbyDuplicate(int[] nums, int k) {
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < nums.length; i++) {
				if (map.containsKey(nums[i])) {
					if (i - map.get(nums[i]) <= k)
						return true;
				}
				map.put(nums[i], i);
			}
			return false;
		}
	}

}
