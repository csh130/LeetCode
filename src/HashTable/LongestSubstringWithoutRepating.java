package HashTable;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepating {
	public int lengthOfLongestSubstring(String s) {
		int i = 0, j = 0, max = 0;
		Set<Character> set = new HashSet<>();

		while (j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				max = Math.max(max, set.size());
			} else {
				set.remove(s.charAt(i++));
			}
		}

		return max;
	}

	// My solution
	public int lengthOfLongestSubstring2(String s) {
		int max = Integer.MIN_VALUE, count = 0;
		Set<Character> set = new HashSet<Character>();
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			int j = i + 1;
			count = 1;
			set.add(arr[i]);
			while (j < arr.length && set.add(arr[j])) {
				count++;
				max = Math.max(count, max);
				j++;
			}
			set.clear();
			max = Math.max(count, max);
		}
		return s.length() == 0 ? 0 : max;
	}
}
