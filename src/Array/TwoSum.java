package Array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static void main(String[] args) {
		System.out.println(twoSum(new int[] { 3, 2, 4 }, 6));
		System.out.println(2%4);
		System.out.println(4%3);
		
	}

	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i]))
				map.put(nums[i], i);
			int res = target - nums[i];
			if (map.containsKey(res) && map.get(res)!=i) {
				result[0] = i;
				result[1] = map.get(res);
				return result;
			}

		}
		return result;
	}
}
