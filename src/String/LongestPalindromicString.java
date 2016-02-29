package String;

public class LongestPalindromicString {
	public static void main(String[] args) {
		System.out.println();
	}

	public String longestPalindrome(String s) {

		if (s.length() == 0 || s.equals(""))
			return "";
		if (s.length() == 1)
			return s;
		int max = 0;
		String longest = "";
		String temp = "";
		for (int i = 0; i < s.length() - 1; i++) {
			char c = s.charAt(i);
			int j = i + 1;
			while (j < s.length()) {
				if (c == s.charAt(j)) {
					temp = s.substring(i, j + 1);
					if (temp.equals(new StringBuilder(temp).reverse()
							.toString())) {
						if (temp.length() > max) {
							max = Math.max(max, temp.length());
							longest = temp;
						}
					}
				}
				j += max;
			}
		}
		return longest;

	}

	public static boolean isValid(String s) {
		int i = 0, j = s.length();
		while (i <= j) {
		}
		return false;
	}
}
