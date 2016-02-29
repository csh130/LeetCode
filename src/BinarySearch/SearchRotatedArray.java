package BinarySearch;

public class SearchRotatedArray {
	public int search(int[] nums, int target) {
		if (nums.length == 0 || nums == null)
			return -1;
		if (nums.length == 1) {
			if (nums[0] != target)
				return -1;
			else
				return 0;
		}
		int N = nums.length;
		int start = 0, end = N - 2;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] > nums[mid + 1]) {
				if (target < nums[mid])
					end = mid;
				else {
					if (target == nums[mid])
						return mid;
					else
						return -1;

				}
			} else {
				if (target < nums[mid])
					end = mid;
				else
					start = mid + 1;
			}

		}
		return start;
	}
}
