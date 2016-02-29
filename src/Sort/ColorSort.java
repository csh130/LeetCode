package Sort;

import java.util.Collections;

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * 
 * */
public class ColorSort {

	public void sortColors(int[] nums) {
		int x = 0;
		int y = 0;
		int z = 0;
		for (int i : nums) {
			switch (i) {
			case 0:
				x++;
				break;
			case 1:
				y++;
				break;
			case 2:
				z++;
				break;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (i < x)
				nums[i] = 0;
			else if (i < x + y)
				nums[i] = 1;
			else
				nums[i] = 2;
		}

	}

	public void onePass(int[] nums) {
		int zero = 0;
		int two = nums.length - 1;

		for (int i = 0; i < nums.length; i++) {
			while (nums[i] == 0) {
				swap(nums[i], nums[zero]);
				zero++;
			}
			while (nums[i] == 2) {
				swap(nums[i], nums[two]);
				two--;
			}
		}

	}

	private void swap(int i, int j) {
		int temp = i;
		i = j;
		j = temp;

	}

}
