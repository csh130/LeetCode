package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PscalTriangle {
	public static void main(String[] args) {
		System.out.println(generate(4));
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		for (int i = 0; i < numRows; i++) {
			List<Integer> ls = new ArrayList<Integer>();
			ls.add(0, 1);
			for (int j = 1; j < i; j++) {
				ls.add(j,
						result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));

			}
			if (i != 0)
				ls.add(1);
			result.add(ls);
		}
		return result;
	}
}
