package String;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern My Submissions Given a pattern and a string str, find if
 * str follows the same pattern.
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
 * */
public class WordPattern {
	public static void main(String[] args) {
		System.out.println(wordPattern("abba", "dog dog dog dog"));
	}

	public static boolean wordPattern(String pattern, String str) {
		Map<Character, String> map = new HashMap<Character, String>();
		String[] arr = str.split(" ");
		if (pattern.length() != arr.length || arr.length == 0)
			return false;
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(pattern.charAt(i))) {
				if (!map.get(pattern.charAt(i)).equals(arr[i]))
					return false;
			} else {
				// be careful here! If it is a new pattern, check the value
				if (map.values().contains(arr[i]))
					return false;
				map.put(pattern.charAt(i), arr[i]);
			}
		}
		return true;
	}

}
