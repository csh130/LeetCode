package String;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsinString {
	public static void main(String[] args) {
		System.out.println(reverseWords("   a   b "));
	}

	public static String reverseWords(String s) {
		String arr[] = s.trim().split("\\s+");
		String b = "";
		for (int i = arr.length - 1; i >= 0; i--) {
			b += arr[i] + " ";
		}
		return b.trim();
	}

	public String reverseWords2(String s) {
		String[] words = s.trim().split(" +");
		Collections.reverse(Arrays.asList(words));
		return String.join(" ", words);
	}
}
