package DynamicProgramming;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * 
 * */
public class UniquePath {
 public static void main(String[] args) {
	
	 System.out.println(uniquePaths(10, 1)+"");
}
		public static int uniquePaths(int m, int n) {
			if (m == 1 && n == 1)
				return 1;
			if (m == 0 || n == 0)
				return 0;
			int maze[][] = new int[m][n];
			for (int i = 0; i < m; i++) {
				maze[i][0]=1;
			}
			for (int j = 0; j < n; j++) {
				maze[0][j]=1;
			}
			for (int j = 1; j < m; j++) {
				for (int j2 = 1; j2 < n; j2++) {
					 
					maze[j][j2]=maze[j-1][j2]+maze[j][j2-1];
				}
			}
			
			return maze[m-1][n-1];

		 
	}
}
