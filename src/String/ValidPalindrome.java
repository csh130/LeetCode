package String;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * */
public class ValidPalindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome("ab2a"));
	}

	// 考虑 string 为空的情况. 再就是判断是否为字母 或者数字 用character的API
	public static boolean isPalindrome(String s) {
		if (s.equals("") || s.length() == 0)
			return true;
		int i = 0, j = s.length() - 1;
		char a;
		char b;
		while (i <= j) {
			a = Character.toLowerCase(s.charAt(i));
			b = Character.toLowerCase(s.charAt(j));

			if (!Character.isAlphabetic(a) && !Character.isDigit(a)) {
				i++;
				continue;
			}
			if (!Character.isAlphabetic(b) && !Character.isDigit(b)) {
				j--;
				continue;
			}
			if (a == b) {
				i++;
				j--;
			} else {
				return false;
			}
		}
		return true;
	}
}
