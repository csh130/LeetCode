package BinarySearch;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted in ascending from left to right. Integers in
 * each column are sorted in ascending from top to bottom. For example,
 * 
 * Consider the following matrix:
 * 
 * [ [1, 4, 7, 11, 15], [2, 5, 8, 12, 19], [3, 6, 9, 16, 22], [10, 13, 14, 17,
 * 24], [18, 21, 23, 26, 30] ] Given target = 5, return true. Given target = 20,
 * return false.
 * */
public class Matrix2D2 {
	public static void main(String[] args) {
		System.out.println(searchMatrix(new int[][]{{1,1}}, 2));
	}
	//从最右边一列开始向左边寻找,比目标小 行++, 比目标大, 列--
	public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix == null)
			return false;
		int m = 0;
		int n = matrix[0].length - 1;
		while (m < matrix.length && n >= 0) {
			if (matrix[m][n] == target)
				return true;
			else if (matrix[m][n] > target)
				n--;
			else
				m++;

		}
		return false;
    }
}
