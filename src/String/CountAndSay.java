package String;

public class CountAndSay {
	public static void main(String[] args) {
		System.out.println(countAndSay(1211));
	}

	public static String countAndSay(int n) {
		if (n <= 0)
			return "";
		String s = "";
		int c1 = 0, c2 = 0;
		boolean two = false;
		boolean change = false;
		char[] arr = (n + "").toCharArray();
		char c;
		for (int i = 0; i < arr.length; i++) {
			c = arr[i];
			if (c == '1') {
				two = false;
				if (two != change) {
					if (c2 != 0)
						s += c2 + "2";
					c1 = 1;
					change = two;
				} else
					c1++;
			} else {
				two = true;
				if (two != change) {
					if (c1 != 0)
						s += c1 + "1";
					c2 = 1;
					change = two;
				} else
					c2++;

			}
		}

		if (c1 != 0)
			s += c1 + "1";
		else
			s += c2 + "2";

		return s;
	}
}
