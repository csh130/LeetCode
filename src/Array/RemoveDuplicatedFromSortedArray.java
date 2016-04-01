package Array;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * For example, Given input array nums = [1,1,2],
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively. It doesn't matter what you leave beyond the new
 * length.
 * 
 * 
 * */
public class RemoveDuplicatedFromSortedArray {
	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[] { 1, 2 }));
	}

	// use two pointer
	public static int removeDuplicates(int[] nums) {
		if (nums.length <= 1)
			return nums.length;
		int j = 0;
		for (int i = 1; i < nums.length; i++) {
			while (i < nums.length - 1 && nums[i] == nums[j])
				i++;
			if (nums[i] != nums[j]) {
				// ++j, watch up
				nums[++j] = nums[i];

			}
		}
		// return length j+1 rather than j.
		return j + 1;

	}
}
