package DynamicProgramming;

import org.omg.PortableInterceptor.INACTIVE;

/***
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * @author SihanCheng
 *
 */
public class ClimbingStairs {
	public int climbStairs(int n) {
		int d[] = new int[n];
		if (n == 0)
			return 0;
		int index = 0;

		if (n == 1)
			d[0] = 1;
		if (n == 2) {
			d[0] = 1;
			d[1] = 2;
		}
		if (n >= 3)
			for (int i = 2; i < d.length; i++) {
				d[i] = d[i - 1] + d[i - 2];
			}

		return d[n - 1];
	}
}
