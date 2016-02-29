package BinarySearch;

/**
 * # 35 Given a sorted array and a target value, return the index if the target
 * is found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples. [1,3,5,6], 5 → 2 [1,3,5,6], 2 → 1 [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0*
 */

public class SearchInsertPosition {
	/**
	 * 用中间数来查找, 每次减半, 如果left 指针不等于右边指针 就接着循环
	 * */
	public int searchInsert(int[] nums, int target) {
		int l = 0, r = 0;
		int median = (l + r) / 2;
		while (l <= r) {
			if (nums[median] == target)
				return median;
			else if (nums[median] < target) {
				l = median + 1;

			} else if (nums[median] > target) {
				r = median - 1;
				
			}
		}
		return l;
	}
}
