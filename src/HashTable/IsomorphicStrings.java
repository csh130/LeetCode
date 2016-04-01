package HashTable;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
	public static void main(String[] args) {
		System.out.println(isIsomorphic("ab", "aa"));
	}

	public static boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;
		// one to one relation, so we can use hashmap
		Map<Character, Character> map = new HashMap<Character, Character>();
		char c1 = 'a', c2 = 'a';
		for (int i = 0; i < s.length(); i++) {
			c1 = s.charAt(i);
			c2 = t.charAt(i);
			if (!map.containsKey(c1)) {
				// if it is a new key, but the value already appears. return
				// false;
				if (map.values().contains(c2))
					return false;
				map.put(c1, c2);
			} else {
				if (c2 != map.get(c1))
					return false;
			}

		}
		return true;

	}
}
