package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * 
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * */
public class SummaryRanges228 {
	public static void main(String[] args) {
		SummaryRanges228 s = new SummaryRanges228();
		int[] test = new int[] { 0, 3, 5, 6 };
		System.out.println(s.summaryRanges(test));
	}

	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<String>();
		if (nums.length == 0)
			return result;
		int i = 0;
		while (i < nums.length) {
			if (i == nums.length - 1) {
				result.add("" + nums[i]);
				return result;
			}

			String range = nums[i] + "->";

			for (int j = i + 1; j < nums.length; j++) {

				if (nums[j] == (nums[i] + j - i)) {
					if (j == nums.length - 1) {
						range += nums[j];
						result.add(range);
						return result;
					} else
						continue;
				} else {
					if (j == (i + 1)) {
						range = "" + nums[i];
						result.add(range);
					} else {
						range += nums[j - 1];
						result.add(range);
					}
					i = j - 1;
					break;
				}

			}
			i++;
		}

		return result;

	}

	public List<String> summaryRanges2(int[] nums) {

		int start = 0;
		int end = 0;

		List<String> result = new ArrayList<String>();
		if (nums.length == 0)
			return result;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1] + 1) {
				end = i;
			} else // Sequence toot gayi
			{
				AddToResult(result, nums, start, end);
				start = i;
				end = i;
			}
		}

		// Take care of the last block when sequence ended
		AddToResult(result, nums, start, end);
		return result;
	}

	public void AddToResult(List<String> result, int[] nums, int start, int end) {
		String seq = null;
		if (start != end)
			seq = nums[start] + "->" + nums[end];
		else if (start == end)
			seq = nums[start] + "";
		result.add(seq);
	}
}
