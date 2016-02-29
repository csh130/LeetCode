package DynamicProgramming;

/**
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example, There is one obstacle in the middle of a 3x3 grid as illustrated
 * below.
 * 
 * [ [0,0,0], [0,1,0], [0,0,0] ] The total number of unique paths is 2.
 * 
 * */
public class UniquePath2 {
	public static void main(String[] args) {
		System.out.println(uniquePathsWithObstacles(new int[][] {
				{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1 }, { 0, 0, 0, 1, 0 },
				{ 0, 0, 1, 0, 0 } }));
	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if (m == 1) {
			for (int i = 0; i < n; i++)
				if (obstacleGrid[0][i] == 1)
					return 0;

		}
		if (n == 1) {
			for (int i = 0; i < m; i++)
				if (obstacleGrid[i][0] == 1)
					return 0;

		}
		if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1)
			return 0;
		if (m == 1 || n == 1)
			return 1;

		int t[][] = new int[m][n];
		boolean block = false;
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 1)
				block = true;
			t[i][0] = block ? 0 : 1;
		}
		block = false;

		for (int i = 0; i < n; i++) {
			if (obstacleGrid[0][i] == 1)
				block = true;
			t[0][i] = block ? 0 : 1;

		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 1)
					t[i][j] = 0;
				else if (obstacleGrid[i - 1][j] == 1)
					t[i][j] = t[i][j - 1];
				else if (obstacleGrid[i][j - 1] == 1)
					t[i][j] = t[i - 1][j];
				else
					t[i][j] = t[i - 1][j] + t[i][j - 1];
			}
		}

		return t[m - 1][n - 1];
	}

}
