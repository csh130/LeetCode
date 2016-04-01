package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static void main(String[] args) {
		System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length < 1)
			return res;
		// must sort first
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			// improve the efficiency, remove duplicate
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			int target = -nums[i];
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				if (nums[left] + nums[right] > target) {
					right--;
				} else if (nums[left] + nums[right] < target) {
					left++;
				} else {
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));
					// remove duplicate in inner loop;
					while (left < nums.length - 1
							&& nums[left] == nums[left + 1])
						left++;
					while (right < nums.length - 1
							&& nums[right] == nums[right - 1])
						right--;
					right--;
					left++;
				}
			}

		}
		return res;
	}
}
