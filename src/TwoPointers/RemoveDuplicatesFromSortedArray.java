package TwoPointers;

public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[] { 1, 1, 1, 2, 3, 3 }));

	}

	public static int removeDuplicates(int[] nums) {
		int count = 1, index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				nums[index++] = nums[i];
				continue;
			}
			if (nums[i] == nums[i - 1] && count < 2) {
				nums[index++] = nums[i];
				count++;
			} else if (nums[i] != nums[i - 1]) {
				nums[index++] = nums[i];
				count = 1;
			}
		}
		return nums.length <= 1 ? nums.length : index--;
	}

	// Because it is sorted array, simply by comparing number
	public int removeDuplicates2(int[] nums) {
		int i = 0;
		for (int n : nums)
			if (i < 2 || n > nums[i - 2])
				nums[i++] = n;
		return i;
	}
}
