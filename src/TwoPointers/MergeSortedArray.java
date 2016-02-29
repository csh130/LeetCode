package TwoPointers;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note: You may assume that nums1 has enough space (size that is greater or
 * equal to m + n) to hold additional elements from nums2. The number of
 * elements initialized in nums1 and nums2 are m and n respectively.
 * */
public class MergeSortedArray {

}

class Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// Backward merge
		int i = m - 1, j = n - 1, index = m + n - 1;
		while (j > -1 && i > -1) {
			if (nums1[i] > nums2[j]) {
				nums1[index--] = nums1[i--];
			} else {
				nums1[index--] = nums2[j--];
			}

		}
		//still dont understand this part
		while (j > -1) {
			nums1[index--] = nums2[j--];
		}

	}
}