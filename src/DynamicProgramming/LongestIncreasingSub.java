package DynamicProgramming;

public class LongestIncreasingSub {
	public static void main(String[] args) {

		System.out.println(max(new int[] { 1, 3, 5, 2, 7 }));
	}

	public static int max(int nums[]) {
		int d[] = new int[nums.length];
		int max = 1;
		for (int i = 0; i < d.length; i++) {
			d[i] = 1;
			
			for (int j = 0; j < i; j++) {
				if (nums[j] <= nums[i])
					d[i] = d[i] > d[j] + 1 ? d[i] : d[j]+1;
			}
			max = Math.max(d[i], max);
		}

		return max;
	}
}
