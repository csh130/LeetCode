package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static void main(String[] args) {
		System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			// 跳过与之前同样的数字, 少一次循环.
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int res = 0 - nums[i];
				// 从两端开始往中间靠
				int j = i + 1, k = nums.length - 1;
				while (k > j) {
					if (nums[j] + nums[k] > res)
						k--;
					else if (nums[j] + nums[k] < res)
						j++;
					else if (nums[j] + nums[k] == res) {
						result.add(Arrays.asList(nums[i], nums[j], nums[k]));
						while (j < k && nums[j] == nums[j + 1])
							j++;
						while (j < k && nums[k] == nums[k - 1])
							k--;
						if (j < nums.length - 1) {
							j++;
							k--;
						} else
							break;
					}
				}
			}

		}
		return result;
	}
}
