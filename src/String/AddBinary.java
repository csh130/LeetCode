package String;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 * */
public class AddBinary {
	public static void main(String[] args) {
		System.out.println(addBinary("11", "111"));
	}

	public static String addBinary(String a, String b) {
		StringBuilder result = new StringBuilder();
		int sign = 0;
		int l1 = a.length() - 1, l2 = b.length() - 1;
		while (l1 >= 0 || l2 >= 0) {
			int i1 = 0, i2 = 0;
			if (l1 >= 0)
				i1 = Integer.valueOf(a.charAt(l1) - '0');
			if (l2 >= 0)
				i2 = Integer.valueOf(b.charAt(l2) - '0');
			int sum = i1 + i2;
			if (sum == 2) {
				if (sign == 1)
					result.append("1");
				else
					result.append("0");
				sign = 1;
			} else {
				sum += sign;
				if (sum == 2) {
					result.append("0");
					sign = 1;
				} else {
					result.append("" + sum);
					sign = 0;
				}

			}
			l1--;
			l2--;

		}
		if (sign != 0)
			result.append("" + sign);
		return result.reverse().toString();
	}

	// simple solution
	public String addBinary2(String a, String b) {
		int aLength = a.length() - 1;
		int bLength = b.length() - 1;
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		while (Math.max(aLength, bLength) > 0) {
			int aNum = aLength > 0 ? (a.charAt(aLength--) - '0') : 0;
			int bNum = bLength > 0 ? (b.charAt(bLength--) - '0') : 0;
			int cNum = aNum + bNum + carry;
			sb.append(cNum % 2);
			carry = cNum / 2;
		}
		return (carry == 1) ? sb.append(1).reverse().toString() : sb.reverse()
				.toString();
	}
}
