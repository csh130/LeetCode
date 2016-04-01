package BinarySearch;

public class SearchARange {
	public static void main(String[] args) {
		SearchARange s = new SearchARange();
		int[] r = s.searchRange3(new int[] { 1, 2, 3, 3, 4, 4, 4, 4, 5, 6 }, 4);

		System.out.println(r[0] + "," + r[1]);
	}

	public int[] searchRange(int[] A, int target) {
		int start = firstGreaterEqual(A, target);
		if (start == A.length || A[start] != target) {
			return new int[] { -1, -1 };
		}
		return new int[] { start, firstGreaterEqual(A, target + 1) - 1 };
	}

	// find the first number that is greater than or equal to target.
	// could return A.length if target is greater than A[A.length-1].
	// actually this is the same as lower_bound in C++ STL.
	private static int firstGreaterEqual(int[] A, int target) {
		int low = 0, high = A.length;
		while (low < high) {
			int mid = low + ((high - low) >> 1);
			// low <= mid < high
			if (A[mid] < target) {
				low = mid + 1;
			} else {
				// should not be mid-1 when A[mid]==target.
				// could be mid even if A[mid]>target because mid<high.
				high = mid;
			}
		}
		return low;
	}

	/**
	 * 自己的思路: 先用binary search 找出start的index, 如果不存在 直接返回-1,-1 . 找到start 以后,
	 * 在start后面做循环 向后寻找.
	 * */
	public int[] searchRange2(int[] nums, int target) {
		int[] result = new int[2];
		int start = 0, end = nums.length - 1;
		if (target < nums[0] && target > nums[nums.length - 1])
			return new int[] { -1, -1 };

		while (start < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] < target)
				start = mid + 1;
			else
				end = mid;
		}
		// if not find the target
		if (nums[start] != target)
			return new int[] { -1, -1 };
		result[0] = start;

		while (start < nums.length) {
			if (nums[start] == target)
				start++;
			else
				break;
		}
		result[1] = start - 1;

		return result;
	}

	public static int[] searchRange3(int[] nums, int target) {
		int[] result = new int[2];
		if (nums[0] > target || nums[nums.length - 1] < target
				|| nums.length == 0) {
			return new int[] { -1, -1 };
		}
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			}else{
				
			}
		}
		result[0] = left;
		result[1] = right;
		return result;
	}
}
