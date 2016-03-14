package Math;

public class PalidromeNumber {
	public static void main(String[] args) {
		System.out.println(isPalindrome(Integer.MAX_VALUE));
	}
	  public static boolean isPalindrome(int x) {
	        if(x<0 || ( x%10==0 && x!=0)) return false;
	        int n=0;
	        int ori=x;
	        while(x>0){
	            n= (10*n+x%10);
	            x/=10;
	        }

	        return ori==n;
	        
	    }
}
