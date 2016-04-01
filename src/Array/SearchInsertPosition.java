package Array;

public class SearchInsertPosition {
	public static void main(String[] args) {
		System.out.println(searchInsert(new int[] { 1 }, 0));
	}

	public static int searchInsert(int[] nums, int target) {
		if (nums.length == 0)
			return 0;
		for (int i = 0; i < nums.length; i++) {
			if (target <= nums[i]) {
				return i;
			}
		}
		return nums.length;
	}
}
