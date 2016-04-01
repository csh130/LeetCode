package Array;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * 
 * click to show follow up.
 * 
 * Follow up: Did you use extra space? A straight forward solution using O(mn)
 * space is probably a bad idea. A simple improvement uses O(m + n) space, but
 * still not the best solution. Could you devise a constant space solution?
 * */
public class SetMatrixZero {
	public static void main(String[] args) {
		setZeroes(new int[][] { { 0 } });
	}

	public static void setZeroes(int[][] matrix) {
		// first check null cases;
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;
		// flag for the first row, we store the 0 which means that row or colum
		// should be set to 0
		// otherwise, we have to use extra space for the set as 0
		boolean frow = false, fcol = false;
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0)
						frow = true;
					if (j == 0)
						fcol = true;
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}

		// Start from 1, be careful with here!
		for (int i = 1; i < m; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		// Start from 1, be careful with here! If start from 0, will not get the
		// correct answer!
		for (int i = 1; i < n; i++) {
			if (matrix[0][i] == 0) {
				for (int j = 1; j < m; j++) {
					matrix[j][i] = 0;
				}
			}
		}
		if (frow) {
			for (int i = 0; i < n; i++)
				matrix[0][i] = 0;
		}
		if (fcol) {
			for (int i = 0; i < m; i++)
				matrix[i][0] = 0;
		}

	}
}
