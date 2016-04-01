package Math;

public class StringToInteger {
	public static void main(String[] args) {
		System.out.println(myAtoi("    -105225454"));
	}

	public static int myAtoi(String str) {
		str = str.trim();
		int num = 0, sign = 1;
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			// if the first non-white space character is not '-' or number
			if (i == 0 && !Character.isDigit(ch[i]) && ch[i] != '-'
					&& ch[i] != '+') {
				return 0;
			} else if (i == 0 && ch[i] == '-') {
				sign = -1;
			} else if (i == 0 && ch[i] == '+') {
				sign = 1;
			} else if (Character.isDigit(ch[i])) {
				int temp = num;
				num = 10 * num + (ch[i] - '0');
				if (num / 10 != temp)
					return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			} else {
				break;
			}

		}
		return sign * num;
	}
}
