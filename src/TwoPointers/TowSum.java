package TwoPointers;

import java.util.HashMap;
import java.util.Map;

/***
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 */
public class TowSum {
	public static void main(String[] args) {

		System.out.println(twoSum(new int[] { 3, 2, 4 }, 6));
	}

	public static int[] twoSum(int[] nums, int target) {
		int result[] = new int[2];
		// 利用hashmap的 key 唯一性, 把数组的数存进去, 去查找target-nums[i] 存不存在
		Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (hash.containsKey(target - nums[i])) {
				result[0] = i + 1; // 返回的index都要加1
				result[1] = hash.get(target - nums[i]);
			} else {
				hash.put(nums[i], i + 1); 
			}

		}
		return result;

	}
}
