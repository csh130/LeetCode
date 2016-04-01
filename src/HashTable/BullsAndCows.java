package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BullsAndCows {
	public static void main(String[] args) {
		System.out.println(getHint("1122", "1222"));
	}

	public static String getHint(String secret, String guess) {
		if (secret == null || secret.length() == 0) {
			return "0A0B";
		}
		int bull = 0;
		int total = 0;
		char[] sChar = secret.toCharArray();
		char[] gChar = guess.toCharArray();
		int[] flags = new int[10];
		for (char c : sChar) {
			flags[c - '0']++;
		}

		for (int i = 0; i < sChar.length; i++) {
			if (gChar[i] == sChar[i]) {
				bull++;
			}
			// here is the tricky part.
			if (flags[gChar[i] - '0']-- > 0) {
				total++;
			}
		}
		return bull + "A" + (total - bull) + "B";
	}
}
