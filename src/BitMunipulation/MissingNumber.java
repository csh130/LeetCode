package BitMunipulation;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find
 * the one that is missing from the array.
 * 
 * For example, Given nums = [0, 1, 3] return 2.
 * 
 * Note: Your algorithm should run in linear runtime complexity. Could you
 * implement it using only constant extra space complexity?
 * 
 * Credits:
 * */
public class MissingNumber {
	public static void main(String[] args) {

		System.out.println(missingNumber2(new int[] {0, 1, 2, 3 ,5}));
	}

	public static int missingNumber(int[] nums) {
		int res = nums.length;
		for (int i = 0; i < nums.length; i++) {
			System.out.println("i ^ nums[i]" + (i ^ nums[i]));
			res ^= (i ^ nums[i]);
			System.out.println(res);
		}
		return res;
	}

	// n *(n+1) /2 is the sum of all number, decreased by each number appear, the last one is the one missiong
	public static int missingNumber2(int[] nums) {
		int sum = nums.length;
		for (int i = 0; i < nums.length; i++) {
			sum += i;
			sum -= nums[i];
		}
		return sum;
	}

}
