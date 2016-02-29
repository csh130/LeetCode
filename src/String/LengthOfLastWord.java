package String;

public class LengthOfLastWord {
	  public int strStr(String haystack, String needle) {
	        if(needle.equals("") || needle.length()==0) return 0;
	            return haystack.lastIndexOf(needle);
	    }
}
