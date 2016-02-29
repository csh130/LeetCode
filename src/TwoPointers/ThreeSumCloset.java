package TwoPointers;

import java.util.Arrays;

public class ThreeSumCloset {
	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
	}

	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int diff = Integer.MAX_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			int res = target - nums[i];
			int low = i + 1, high = nums.length - 1;
			while (low < high) {
				int tsum = nums[i] + nums[low] + nums[high];
				int temp = Math.abs(target - tsum);
				if (temp < diff && low != high) {
					diff = temp;
					sum = tsum;
				}
				if (nums[low] + nums[high] < res) {
					low++;

				} else if (nums[low] + nums[high] > res) {
					high--;
				} else {
					// find the number

					return nums[i] + nums[low] + nums[high];
				}

			}

		}
		return sum;
	}
	public int threeSumClosest2(int[] nums, int target) {
	    Arrays.sort(nums);
	    int sum = nums[0] + nums[1] + nums[nums.length - 1];
	    int closestSum = sum;

	    for(int i = 0; i < nums.length - 2; i++){
	    	// 减少duplicate的case 减少循环次数
	        if(i==0 || nums[i]!=nums[i-1]){
	            int left = i + 1, right = nums.length - 1;
	            while(left < right){
	                sum = nums[left] + nums[right] + nums[i];
	                if(sum < target){
	                    //move closer to target sum.
	                    while(left<right && nums[left] == nums[left+1]){
	                        left++;
	                    }
	                    left++;
	                }else if(sum > target){
	                    //move closer to target sum.
	                    while(left<right && nums[right] == nums[right-1]){
	                        right--;
	                    }
	                    right--;
	                }else{
	                    return sum;
	                }
	                //update the closest sum if needed.
	                if(Math.abs(target - sum) < Math.abs(target - closestSum)){
	                    closestSum = sum;
	                }
	            }
	        }

	    }
	    return closestSum;
	}
}
