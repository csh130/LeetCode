package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Given an array of integers, find if the array contains any duplicates. Your
 * function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 * */
public class ContainsDuplicate217 {
	public static void main(String[] args) {
		ContainsDuplicate217 c = new ContainsDuplicate217();
		System.out.println(c
				.containsDuplicate(new int[] { 1, 2, 3, 6, 5, 8, 7 }));
	}

	public boolean containsDuplicate(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums) {
			if (map.containsKey(i))
				return true;
			else
				map.put(i, 0);
		}
		return false;
	}
	
	/**
	 * ??hashset ?????????? ???????? ??????false?? ??????????????????
	 * */
	public boolean containsDuplicate2(int[] nums) {

	    HashSet<Integer> flag = new HashSet<Integer>();

	    for(int i : nums) {
	        if(!flag.add(i)) {
	            return true;
	        }
	    }
	    return false;
	}
}
