package Array;

public class ValidAnagram {
	public static void main(String[] args) {
		System.out.println(isAnagram("abcdk", "bcd"));
	}

	public static boolean isAnagram(String s, String t) {
		if (s == null && t == null)
			return true;
		char[] sa = new char[26];
		char[] ta = new char[26];
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		for (char c : sc) {
			sa[c - 'a']++;
		}
		for (char c : tc) {
			ta[c - 'a']++;
		}
		return new String(sa).equals(new String(ta));
	}
}
