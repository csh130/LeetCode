package Array;

/**
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * */
public class PlusOne {
	public int[] plusOne(int[] digits) {

		int n = digits.length;
		// put the pointer to the end
		for (int i = n - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}

			digits[i] = 0;
		}

		// if the array size is changed. add the 1 to the first element, and set
		// 0 afterwards
		int[] newNumber = new int[n + 1];
		newNumber[0] = 1;

		return newNumber;
	}
}
