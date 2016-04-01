package Array;

public class SortColors {
	public static void main(String[] args) {
		sortColors(new int[] { 2, 1 });
	}

	// one pass solution
	public static void sortColors(int[] nums) {
		int left = 0, right = nums.length - 1;
		int temp = 0;
		// loop until right
		for (int i = 0; i <= right; i++) {
			if (nums[i] == 0)
				swap(nums, left++, i);
			if (nums[i] == 2)
				swap(nums, right--, i--); // i--, after swap, loop from last
											// index. check

		}
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;

	}
}
