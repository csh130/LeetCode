package Array;

public class SpiralII {
	public static void main(String[] args) {
		System.out.println(generateMatrix(4));
	}

	public static int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int count = 1;
		if (n == 0 || n == 1) {
			if (n == 1)
				matrix[0][0] = 1;
			return matrix;
		}
		int rowBegin = 0, colBegin = 0, rowEnd = n - 1, colEnd = n - 1;
		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			// traverse to right
			for (int i = colBegin; i <= colEnd; i++) {
				matrix[rowBegin][i] = count++;
			}
			rowBegin++;

			// traverse down
			for (int i = rowBegin; i <= rowEnd; i++) {
				matrix[i][colEnd] = count++;
			}
			colEnd--;

			// traverse to left
			if (colEnd >= colBegin)
				for (int i = colEnd; i >= colBegin; i--) {
					matrix[rowEnd][i] = count++;
				}
			rowEnd--;

			// traverse to up
			if (rowEnd >=rowBegin)
				for (int i = rowEnd; i >= rowBegin; i--) {
					matrix[i][colBegin] = count++;
				}
			colBegin++;
		}
		return matrix;
	}
}
