package BinarySearch;

public class PowX {
	public static void main(String[] args) {
		System.out.println(myPow(8.888, 5));
	}

	/*
	 * 计算x的n次幂
	 * 
	 * @param x 底数
	 * 
	 * @param n 指数
	 * 
	 * @return 幂
	 */
	public static double myPow(double x, int n) {

		// 特例，快速给出结果
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return x;
		} else if (n == -1) {
			return 1 / x;
		}

		// 要考虑n为正数和负数两种情况
		double temp;
		if (n > 0) {
			temp = myPow(x, n / 2);
			if (n % 2 != 0) {
				return temp * temp * x;
			} else {
				return temp * temp;
			}
		} else {
			temp = 1 / myPow(x, -n / 2);
			if (n % 2 != 0) {
				return temp * temp / x;
			} else {
				return temp * temp;
			}

		}
	}
}
