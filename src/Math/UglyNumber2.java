package Math;

public class UglyNumber2 {
	public static void main(String[] args) {
		System.out.println(nthUglyNumber(1352));
	}

	public static int nthUglyNumber(int n) {
		int count = 1, number = 1;
		while (count <= n) {
			if (isUgly(number)) {
				count++;
//				System.out.println(number);
			}
			number++;
		}
		return number-1;

	}

	public static boolean isUgly(int n) {
		if (n <= 0)
			return false;
		if (n == 1)
			return true;
		while ((n & 1) == 0)
			n /= 2;
		while (n % 3 == 0)
			n /= 3;
		while (n % 5 == 0)
			n /= 5;
		return n == 1;
	}
}
