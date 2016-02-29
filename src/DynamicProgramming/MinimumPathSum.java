package DynamicProgramming;

public class MinimumPathSum {

	public int minimuSumPath(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int result = 0;
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				grid[i][j] = grid[i][j]
						+ Math.min(grid[i - 1][j], grid[i][j - 1]);
			}

		}

		return grid[m - 1][n - 1];

	}

}
