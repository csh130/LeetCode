package Array;

public class ProductOfArrayExceptSelf {
	public static void main(String[] args) {
		System.out.println(productExceptSelf(new int[] { 0, 10, 1, 2, 3 }));
	}

	// basic idea is loop from left to right , product[n]=product[n-1]*nums[i-1]
	public static int[] productExceptSelf(int[] nums) {
		int[] product = new int[nums.length];
		product[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			product[i] = product[i - 1] * nums[i - 1];
		}
		int pro = 1;
		// loop from right to the left; pro= nums[n+1]*....*(nums.length-1)
		// then the product[i]=product[i]* pro
		for (int i = nums.length - 2; i >= 0; i--) {
			pro *= nums[i + 1];
			product[i] = product[i] * pro;
		}
		return product;
	}
}
