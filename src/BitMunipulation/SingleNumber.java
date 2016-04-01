package BitMunipulation;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * */
public class SingleNumber {
	public static void main(String[] args) {

		System.out.println(singleNumber(new int[] { 1, 2, 3, 2, 1 }));
	}

	public static int singleNumber(int[] nums) {
		// 0 ^ n =n ; n ^ n=0
		int result = 0;
		for (int i : nums) {
			result ^= i;
			System.out.println(result);
		}
		return result;
	}
}
