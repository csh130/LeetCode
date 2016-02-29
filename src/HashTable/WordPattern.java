package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in str.
 * 
 * Examples: pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false. pattern =
 * "aaaa", str = "dog cat cat dog" should return false. pattern = "abba", str =
 * "dog dog dog dog" should return false. Notes: You may assume pattern contains
 * only lowercase letters, and str contains lowercase letters separated by a
 * single space.
 * 
 * */
public class WordPattern {
	public static void main(String[] args) {
		System.out.println(wordPattern("abba", "doga dog dog doga"));
	}

	public static boolean wordPattern(String pattern, String str) {
		if (pattern.isEmpty() || str.isEmpty())
			return false;
		char[] pat = pattern.toCharArray();
		String[] arr = str.split(" ");
		if (pat.length != arr.length)
			return false;
		Map<String, String> map = new HashMap<String, String>();

		for (int i = 0; i < arr.length; i++) {
			String p = pat[i] + "";
			if (map.containsKey(arr[i])) {
				if (!map.get(arr[i]).equals(p))
					return false;
			} else {
				if (map.values().contains(p))
					return false;
				map.put(arr[i], p);

			}

		}
		return true;
	}
}
