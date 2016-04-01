package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorElement2 {
	public static void main(String[] args) {

		System.out.println(majorityElement3(new int[] { 4, 2, 1, 1 }));
	}

	// My solution, not efficient enough;
	public static List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		// if the length less than 2, return them avoid duplicate
		if (nums.length <= 2) {
			for (int i = 0; i < nums.length; i++) {
				if (!res.contains(nums[i]))
					res.add(nums[i]);
			}
			return res;
		}
		int count = 1;
		Arrays.sort(nums);
		// count the number appearance times
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				count++;
			} else {
				count = 1;
			}
			// if appear more than three times, add it to the result and set the
			// count to 1;
			if (count > nums.length / 3 && !res.contains(nums[i]))
				res.add(nums[i]);

		}
		return res;
	}

	// n/3, so there can be 2 numbers in the result;
	public List<Integer> majorityElement2(int[] nums) {
		if (nums == null || nums.length == 0)
			return new ArrayList<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] == number1)
				count1++;
			else if (nums[i] == number2)
				count2++;
			else if (count1 == 0) {
				number1 = nums[i];
				count1 = 1;
			} else if (count2 == 0) {
				number2 = nums[i];
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] == number1)
				count1++;
			else if (nums[i] == number2)
				count2++;
		}
		if (count1 > len / 3)
			result.add(number1);
		if (count2 > len / 3)
			result.add(number2);
		return result;
	}

	// My solution
	public static List<Integer> majorityElement3(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums.length == 1) {
			res.add(nums[0]);
			return res;
		}
		if (nums.length == 2) {
			for (int i : nums) {
				if (nums[1] != nums[0]) {
					res.add(nums[1]);
					res.add(nums[0]);
					return res;
				} else {
					res.add(nums[0]);
					return res;
				}
			}
		}
		Arrays.sort(nums);
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			while (i < nums.length && nums[i] == nums[i - 1]) {
				count++;
				i++;
			}
			if (count > nums.length / 3)
				res.add(nums[i - 1]);
			count = 1;
		}
		return res;

	}
}
