package BitMunipulation;

import java.util.ArrayList;
import java.util.List;

public class RepeatedDNASequence {
	  public List<String> findRepeatedDnaSequences(String s) {
	        List<String> res=new ArrayList<String>();
	        if(s.length()<10) return res;
	        for(int i=0;i<s.length()-10;i++){
	        	String sub=s.substring(i, i+9);
	        	if(s.substring(i+1).indexOf(sub)!=-1){
	        		if(!res.contains(sub))
	        		res.add(sub);
	        	}
	            
	        }
			return res;
	        
	    }
}
