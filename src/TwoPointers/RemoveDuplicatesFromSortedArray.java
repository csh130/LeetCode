package TwoPointers;

public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1,1,1,2,3,3}));
		
	}
	  public static int removeDuplicates(int[] nums) {
	        if(nums.length==0 || nums==null) return 0;
	        //Use two pointers, count the number appearance times
	        int j=0, num=nums[0], count=0;
	        for(int i=0 ;i<nums.length; i++){
	           
	            if(num==nums[i]){ 
	                count++;
	                if(count <3){
	                     nums[j++]=nums[i];
	                }
	            }else{
	                count=1;
	                nums[j++]=nums[i];
	            }
	            
	            num=nums[i];
	            
	        }
	        return j;
	    }
	  public int removeDuplicates2(int[] nums) {
		    int i = 0;
		    for (int n : nums)
		        if (i < 2 || n > nums[i-2])
		            nums[i++] = n;
		    return i;
		}
}
