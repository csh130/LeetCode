package Math;

import java.util.LinkedList;
import java.util.List;

public class Permutation {
	public static void main(String[] args) {
		System.out.println(getPermutation(2, 2));
	}

	public static String getPermutation(int n, int k) {
		int[] factorial = new int[n];
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new LinkedList<Integer>();
		factorial[0] = 1; // from 0 to n-1
		for (int i = 1; i < n; i++) {
			factorial[i] = factorial[i - 1] * n;
			list.add(i);
		}
		// add the last number to the list;
		list.add(n);
		k--;
		for (int i = 1; i <= n; i++) {
			int index = k / factorial[n - i - 1];
			sb.append(list.get(index));
			list.remove(index);
			k -= index * factorial[n - i];
		}
		return sb.toString();
	}
}
