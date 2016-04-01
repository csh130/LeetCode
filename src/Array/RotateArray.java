package Array;

public class RotateArray {
	public static void main(String[] args) {
		rotate(new int[] { 1, 2, 3 }, 2);
	}

	public static void rotate(int[] nums, int k) {
		int[] arr = new int[nums.length];
		if (k > nums.length)
			k %= nums.length;
		
		for (int i = 0; i <k; i++) {
			arr[i] = nums[nums.length-k+i];
		
		}
		int j = 0;
		for (int i = k; i < nums.length; i++) {
			arr[i] = nums[j];
			j++;
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = arr[i];
		}
	}
}
