package BinarySearch;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row. For example,
 * 
 * Consider the following matrix:
 * 
 * [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ] Given target = 3, return
 * true.
 * */
public class Marix2D {
	public static void main(String[] args) {
		int[][] m = new int[][] { { 1, 3 } };
		System.out.println(searchMatrix(m, 2));
	}

	// 把它想象成一个list, 数字接在一起的, 这样通过 matrix[mid/n][mid%n] 可以对应数组中的数字
	public static boolean searchMatrix(int[][] matrix, int target) {

		if (matrix == null || matrix.length == 0 || target < matrix[0][0]
				|| target > matrix[matrix.length - 1][matrix[0].length - 1])
			return false;
		int m = matrix.length;
		int n = matrix[0].length;

		int start = 0, end = m * n - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (matrix[mid / n][mid % n] < target)
				start = mid + 1;
			else {
				if (matrix[mid / n][mid % n] == target)
					return true;

				end = mid - 1;
			}
		}

		return false;

	}

}
