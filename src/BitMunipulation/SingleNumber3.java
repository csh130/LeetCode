package BitMunipulation;

public class SingleNumber3 {
	public static void main(String[] args) {

		System.out.println(isOdd(3));
		System.out.println(2%3);
	}

	public static boolean isOdd(int x) {
		if ((x & 1  ) == 0) {
			return false;

		}
		return true;
	}
}
