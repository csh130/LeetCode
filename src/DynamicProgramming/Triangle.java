package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle [ [2], [3,4], [6,5,7], [4,1,8,3] ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * */
public class Triangle {
	public static void main(String[] args) {
		List<List<Integer>> test = new ArrayList<List<Integer>>();
		test.add(new ArrayList<Integer>() {
			{
				add(1);
			}
		});
		test.add(new ArrayList<Integer>() {
			{
				add(2);
				add(3);
			}
		});

		System.out.println(minimumTotal(test));
	}

	public static int minimumTotal1(List<List<Integer>> triangle) {
		if (triangle.size() == 0)
			return 0;
		if (triangle.size() == 1)
			return triangle.get(0).get(0);

		int sum = triangle.get(0).get(0);
		int ls = 0;
		int rs = 0;
		int start = 0;
		for (int i = 1; i < triangle.size(); i++) {
			int size = triangle.get(i).size();
			int left = 0;
			int right = 0;
			if (start < size)
				left = triangle.get(i).get(start);
			if (start + 1 < size)
				right = triangle.get(i).get(start + 1);

			ls = sum + left;
			rs = sum + right;
			if (rs < ls)
				start++;
			sum = Math.min(ls, rs);

		}
		return sum;

	}

	/**
	 * 从倒数第二排开始,把每个 element 设成下一排相邻的2个数之和,取较小的那一个加上自己的 number, 直到加到第一排
	 * */
	public static int minimumTotal(List<List<Integer>> triangle) {
		if (triangle.size() == 0)
			return 0;
		if (triangle.size() == 1)
			return triangle.get(0).get(0);
		int sum = 0;
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				triangle.get(i).set(
						j,
						triangle.get(i).get(j)
								+ Math.min(triangle.get(i + 1).get(j), triangle
										.get(i + 1).get(j + 1)));
			}
		}

		return triangle.get(0).get(0);

	}
}
