package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {
	public static void main(String[] args) {
		System.out.println(subsets(new int[] { 1, 2, 3 }));
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		Arrays.sort(nums);
		// add the empty list
		res.add(temp);
		for (int j = 0; j < nums.length; j++) {
			// use size as temporary variable, because it will change later.
			int n = res.size();
			for (int i = 0; i < n; i++) {
				temp = new ArrayList<Integer>(res.get(i));
				temp.add(nums[j]);
				res.add(temp);
			}
		}
		return res;

	}
}
