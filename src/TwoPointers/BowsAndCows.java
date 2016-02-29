package TwoPointers;

public class BowsAndCows {
	public class Solution {
		public String getHint(String secret, String guess) {
			int bull = 0, cow = 0;
			int[] map = new int[10];
			for (int i = 0; i < secret.length(); i++) {
				// compare char by char
				int a = secret.charAt(i) - '0';
				int b = guess.charAt(i) - '0';

				// if char and position match, it is bull, return A
				if (a == b) {
					bull++;
					continue;
				} else {
					// if not match, check whether the char exists in other
					// place
					if (map[a] < 0)
						cow++;
					if (map[b] > 0)
						cow++;
					map[a]++;
					map[b]--;
				}

			}

			return bull + "A" + cow + "B";
		}
	}
}
