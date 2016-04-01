package DynamicProgramming;

public class MaxRob2 {
	public static void main(String[] args) {
		// System.out.println(rob(new int[] { 2, 7, 9, 3, 1 }));

		Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;

		System.out.println(f1 == f2);
		System.out.println(f3 == f4);

		// betterSolution b = new betterSolution();
		// System.out.println(b.rob(new int[] { 1, 1, 1 }));
	}

	public static int rob(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return 0;
		if (len == 1)
			return nums[0];
		if (len == 2)
			return Math.max(nums[1], nums[0]);
		if (len == 3)
			return Math.max(Math.max(nums[1], nums[0]), nums[2]);
		return Math.max(max(nums, 0), max(nums, 1));
	}

	public static int max(int[] nums, int start) {
		int d[] = new int[nums.length - 1];
		int len = nums.length;
		int n = 1;

		d[0] = nums[start];
		d[1] = Math.max(nums[start], nums[start + 1]);
		d[2] = Math.max(d[1], d[0] + nums[start + 2]);
		// d[3] = Math.max(d[2], d[1] + nums[start + 3]);
		for (int i = 3; i < len - 1; i++) {
			d[i] = Math.max(d[i - 2], d[i - 3]) + nums[i + start];
		}

		n++;
		return Math.max(d[d.length - 2], d[d.length - 1]);

	}

}

class betterSolution {
	public int rob(int nums[]) {
		if (nums.length == 1)
			return nums[0];
		return Math.max(max(nums, 0, nums.length - 1),
				max(nums, 1, nums.length));
	}

	public int max(int nums[], int start, int end) {
		// s0 means last one is robbed
		// s1 means last one is not robbed
		int s0 = 0;
		int s1 = 0;
		for (int i = start; i < end; i++) {
			// if rob current one
			int rob = s1 + nums[i];
			// if not rob current one
			int notRob = Math.max(s0, s1);
			s0 = rob;
			s1 = notRob;
		}

		return Math.max(s0, s1);
	}

}