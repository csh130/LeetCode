package BinarySearch;
/**
 * 求一个数的平方, O(logN)时间
 * */
public class Sqr {
	public int mySqrt(int x) {
		int s = 0, end = Integer.MAX_VALUE;
		while (s < end) {
			int mid = s + (end - s) / 2;
			if (mid < x / mid) {
				s = mid + 1;
			} else
				end = mid;
		}

		return s-1;

	}
}
