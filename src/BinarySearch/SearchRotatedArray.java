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

	// My solution
	public int search2(int[] nums, int target) {
		if (nums.length == 0)
			return 0;
		int left = 0, right = nums.length - 1;
		if (target < nums[left] && target > nums[right])
			return -1; // target not exist in this array
		// move the right index to left
		while (target >= nums[right] && target >= nums[left]) {
			if (target == nums[right] || target == nums[left])
				return target == nums[right] ? right : left;
			right--;
			if (right < 0)
				return -1;
		}
		// move the left index to right
		while (target <= nums[right] && target <= nums[left]) {
			if (target == nums[right] || target == nums[left])
				return target == nums[right] ? right : left;
			left++;
			if (left >= nums.length)
				return -1;
		}

		// conduct binary search between two pointers
		if (target <= nums[right] && target >= nums[left]) {
			while (left <= right) {
				// binary search betwwen left and right;
				int mid = (right - left) / 2 + left;
				if (target == nums[mid])
					return mid;
				else if (target > nums[mid])
					left = mid + 1;
				else
					right = mid - 1;
			}
		}
		return -1;
	}

}
