package Array;

import java.awt.List;
import java.util.Arrays;

/**
 * 
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list
 * */
/*
 * Notes: ??????string ??????integer ????long?????? ??????????????????????
 */

public class PlusOne66 {
	public static void main(String[] args) {
		PlusOne66 p = new PlusOne66();
		System.out.println(Arrays.toString(p.plusOne2(new int[] { 5, 6, 2, 0, 0,
				4, 6, 2, 4, 9 })));
		System.out.println(Arrays.toString(p.plusOne2(new int[] { 9, 9 })));
		System.out.println(Arrays.toString(p.plusOne2(new int[] { 1, 2, 9 })));
	}

	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i] = 1 + digits[i];

			if (digits[i] == 10)
				digits[i] = 0;
			else
				return digits;
		}

		// don't forget over flow case
		int[] newdigit = new int[digits.length + 1];
		newdigit[0] = 1;
		for (int i = 1; i < newdigit.length; i++) {
			newdigit[i] = digits[i - 1];
		}
		return newdigit;
	}

	public int[] plusOne2(int[] digits) {
		if (digits == null)
			return null;
		int len = digits.length;
		digits[len - 1]++;
		if (digits[len - 1] <= 9)
			return digits;

		for (int i = len - 1; i > 0; i--) {
			if (digits[i] == 10) {
				digits[i] = 0;
				digits[i - 1]++;

			} else
				break;
		}

		if (digits[0] == 10) {
			digits[0]=0;
			int result[] = new int[len + 1];
			result[0] = 1;
			for (int i = 0; i < len; i++) {
				result[i + 1] = digits[i];
			}
			return result;
		}
		return digits;

	}

}
