package BinarySearch;

public class Peak {
	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[] { 1, 2, 3, 4, 5 }));
	}

	// 用二分查找, num[-1] num[N+1]都是负无穷, 如果nums[mid]< nums[mid+1] end =mid, 向右边开始找,
	// else 从左边开始找, 不要用mid-1, 会导致溢出,
	public static int findPeakElement(int[] nums) {
		int left = 0;
		int end = nums.length - 1;
		if (nums.length == 2) {
			if (nums[0] > nums[1])
				return 0;
			else
				return 1;

		}
		if (nums.length == 1)
			return 0;
		while (left <= end) {
			int mid = left + (end - left) / 2;
			if (mid == 1 || mid == nums.length - 1) {
				if (nums[0] > nums[1])
					return 0;
				if (nums[nums.length - 1] > nums[nums.length - 2])
					return nums.length - 1;
			}
			if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
				return mid;
			} else if (nums[mid] < nums[mid - 1]) {
				end = mid;
			} else if (nums[mid] > nums[mid - 1]) {
				left = mid + 1;
			}

		}

		return 0;
	}

	public int findPeakElement2(int[] num) {
		int n = num.length;
		if (n <= 1)
			return 0;
		// handle the first and last element in num[]
		if (num[0] > num[1])
			return 0;
		if (num[n - 1] > num[n - 2])
			return n - 1;
		int left = 1, right = n - 2;
		while (left < right) {
			int mid = (left + right) >> 1;
			if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) {
				return mid;
			} else if (num[mid] > num[mid + 1]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}
