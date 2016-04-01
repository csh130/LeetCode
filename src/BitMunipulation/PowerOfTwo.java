package BitMunipulation;

/**
 * Given an integer, write a function to determine if it is a power of two.
 * */
public class PowerOfTwo {
	public boolean isPowerOfTwo(int n) {
		// less than 0, return false directly;
		if (n <= 0)
			return false;
		// the power of 2 only have 1 bit in binary number; so n& (n-1) must be 0;
		return (n & (n - 1)) == 0;
	}
}
