package BitMunipulation;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * For example, given input 43261596 (represented in binary as
 * 00000010100101000001111010011100), return 964176192 (represented in binary as
 * 00111001011110000010100101000000).
 * */
public class ReverseBits {
	public static void main(String[] args) {
		System.out.println(5 & 7 & 6);
		System.out.println(reverseBits(11));
		System.out.println(reverseBits2(11));
	}

	public static int reverseBits(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			// get the last digit (0 or 1) of n using '& 1'
			result += n & 1;
			n >>>= 1; // CATCH: must do unsigned shift
			if (i < 31) // CATCH: for last digit, don't shift! Run for 31 times
						// then stop;
				result <<= 1;
		}
		return result;
	}

	public static int reverseBits2(int n) {
		int result = 0;
		for (int i = 31; i >= 0; i--) {
			// get the last digit (0 or 1) of n using '& 1'
			result += ((n & 1) << i);
			n >>>= 1; // CATCH: must do unsigned shift
		}
		return result;
	}
}
