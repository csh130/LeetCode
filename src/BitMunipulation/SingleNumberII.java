package BitMunipulation;

/**
 * Given an array of integers, every element appears three times except for one.
 * Find that single one. Note: Your algorithm should have a linear runtime
 * complexity. Could you implement it without using extra memory?
 * 
 * Subscribe to see which companies asked this question
 * */
public class SingleNumberII {
	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] { 1, 1, 1, 2 }));
	}

	public static int singleNumber(int[] nums) {
		//store the bit number of every element in array
		int[] bit = new int[32];
		int result = 0;
		for (int n : nums) {
			//store 32 bits of the number into the array
			for (int i = 0; i < 32; i++) {
				bit[i] += (n & 1);
				n >>>= 1;
			}
		}

		// if the number appears 3 times, the that bit mod 3 =0, else is 1;
		for (int i = 0; i < 32; i++) {
			bit[i] = bit[i] % 3 == 0 ? 0 : 1;
			// calculate the result , transform bit number into int
			// bit[i] shift to the left i times, means 2^n
			result += (bit[i]<<i);

		}
		return result;
	}
}
