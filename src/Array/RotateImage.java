package Array;

/**
 * 48. Rotate Image My Submissions Question Total Medium You are given an n x n
 * 2D matrix representing an image. * Rotate the image by 90 degrees
 * (clockwise). Follow up: Could you do this in-place?
 * */
public class RotateImage {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		int[][] temp = new int[n][n];
		int col = n - 1, startRow = 0, startCol = 0;
		while (col >= 0) {
			for (int i = 0; i < n; i++) {
				temp[i][col] = matrix[startRow][startCol++];
			}
			startRow++;
			startCol = 0;
			col--;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = temp[i][j];

			}
		}

	}
}
