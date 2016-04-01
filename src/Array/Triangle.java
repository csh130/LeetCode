package Array;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	public static void main(String[] args) {
		List<List<Integer>> l = new ArrayList<List<Integer>>();

		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(-1);
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(3);
		l2.add(2);
		List<Integer> l3 = new ArrayList<Integer>();
		l3.add(1);
		l3.add(-2);
		l3.add(1);
		l.add(l1);
		l.add(l2);
		l.add(l3);
		System.out.println(minimumTotal(l));
	}

	public static int minimumTotal(List<List<Integer>> triangle) {
		int i = triangle.size() - 1;
		int min = Integer.MAX_VALUE;
		for (int j = 0; j < triangle.get(i).size(); j++) {
			int sum = triangle.get(i).get(j);
			int index = j;
			for (int k = i; k >= 1; k--) {
				// left or right most element;
				if (index == 0) {
					sum += triangle.get(k - 1).get(index);
				} else if (index == k) {
					sum += triangle.get(k - 1).get(k-1);
					index--;
				} else {
					if (triangle.get(k - 1).get(index - 1) < triangle
							.get(k - 1).get(index)) {
						sum += triangle.get(k - 1).get(index - 1);
						index--;
					} else {
						sum += triangle.get(k - 1).get(index);
					}

				}
			}
			min = Math.min(sum, min);
		}
		return min;

	}
}
