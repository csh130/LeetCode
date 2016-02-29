package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAng {
	public static void main(String[] args) {
		String[] sa=new String[]{""};
		System.out.println( groupAnagrams(sa).get(0).get(0));
	}
	 public static List<List<String>> groupAnagrams(String[] strs) {
	         
		 if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
		   Map<String, List<String>> map=new HashMap<String, List<String>>();
		   //sort 
		   Arrays.sort(strs);
		   for(String s:strs){
		            char[] c=s.toCharArray();
		            Arrays.sort(c);
		            String str=String.valueOf(c);
		            if(!map.containsKey(str)) 
		                map.put(str,new ArrayList<String>());
		             map.get(str).add(s);
		        }
		        return new ArrayList<List<String>>(map.values());
	    }
}
