package Math;

import java.util.Arrays;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * */
public class ReverseInteger {
	// use stringBuilder to append the char reversely.
	public int reverse(int x) {
		char[] c = String.valueOf(x).toCharArray();
		int sign = 1;
		StringBuilder str = new StringBuilder();
		for (int i = c.length - 1; i >= 0; i--) {
			if (c[i] == '-')
				sign = -1;
			else
				str.append(c[i]);
		}
		Long result = Long.parseLong(str.toString()) * sign;
		// remeber to check
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
			return 0;
		else
			return Integer.parseInt(str.toString()) * sign;

	}

	public int reverse2(int x) {
		int result = 0;
		while (x != 0) {
			int tail = x % 10;
			int newResult = result * 10 + tail;
			// if the newresult overflow, then , newnesult- tail /10 will not
			// equal to result
			if ((newResult - tail) / 10 != result)
				return 0;
			x /= 10;
			result = newResult;

		}
		return result;
	}
	
	 
}
