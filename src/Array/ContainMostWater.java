package Array;

/**
 * 11. Container With Most Water 
 * 
 * Given n non-negative integers a1, a2, ..., an,
 * where each represents a point at coordinate (i, ai). n vertical lines are
 * drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find
 * two lines, which together with x-axis forms a container, such that the
 * container contains the most water.
 * 
 * Note: You may not slant the container.
 * 
 * 
 * */
public class ContainMostWater {
	
		
	  public int maxArea(int[] height) {
	        int j=height.length-1,i=0;
	        int max=Integer.MIN_VALUE;
	        while(i<j){
	            int area=0;
	            //if height[i]<height[j]
	            if(height[i]< height[j]){
	                area=height[i]*(j-i);
	                i++;
	            }else if(height[i] > height[j]){
	                area=height[j]*(j-i);
	                j--;
	            }else{
	                area=height[i]*(j-i);
	                i++; 
	                j--;
	            }
	            max=Math.max(max, area);
	            
	        }
	        return max;
	    }
}
