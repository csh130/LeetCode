package Math;

public class AddDigits {
	public static void main(String[] args) {
		System.out.println(addDigits(38));
	}

	public static int addDigits(int num) {
		int sum = 0;
		char[] arr = String.valueOf(num).toCharArray();
		for (char c : arr) {
			sum += Integer.parseInt(c + "");
		}
		num = sum;
		if (sum >= 10) {
			return addDigits(sum);

		} else

			return sum;
	}

	// prove in the wiki
	public int addDigits2(int num) {
		return (num - 1) % 9 + 1;
	}
}
