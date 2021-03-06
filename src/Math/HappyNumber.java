package Math;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 19 is a happy number
 * 
 * 1^2 + 9^2 = 82 8^2 + 2^2 = 68 6^2 + 8^2 = 100 1^2 + 0^2 + 0^2 = 1
 */
public class HappyNumber {
	public boolean isHappy(int n) {
		//use hashset, add the sum in hashset, once repeated, stop the loop
		Set<Integer> set = new HashSet<Integer>();
		int sum = 0;
		while (set.add(n)) {
			sum = 0;
			while (n != 0) {
				int tail = n % 10;
				sum += tail * tail;
				n /= 10;
			}
			if (n == 0) {
				if (sum == 1)
					return true;
				else
					n = sum;
			}
		}
		return false;
	}
}
