package Math;

public class AddBinary {
	public static void main(String[] args) {
		System.out.println(addBinary("111", "001"));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE-1);
	}

	public static String addBinary(String a, String b) {
		int sign = 0, i = a.length() - 1, j = b.length() - 1;
		StringBuilder sb = new StringBuilder();
		while (i >= 0 || j >= 0) {
			int a1 = 0, a2 = 0;
			if (i >= 0)
				a1 = a.charAt(i) - '0';
			if (j >= 0)
				a2 = b.charAt(j) - '0';
			i--;
			j--;
			if (a1 + a2 + sign == 3) {
				sb.append("1");
				sign = 1;
			} else if (a1 + a2 + sign == 2) {
				sb.append("0");
				sign = 1;
			} else {
				sb.append("" + (a1 + a2 + sign));
				sign = 0;
			}
		}
		if (sign != 0)
			sb.append(sign);
		return sb.reverse().toString();

	}

	// Simpler version
	public String addBinary2(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1, carry = 0;
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (j >= 0)
				sum += b.charAt(j--) - '0';
			if (i >= 0)
				sum += a.charAt(i--) - '0';
			sb.append(sum % 2);
			carry = sum / 2;
		}
		if (carry != 0)
			sb.append(carry);
		return sb.reverse().toString();
	}
}
