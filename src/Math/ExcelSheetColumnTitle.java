package Math;
/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 * */
public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		// stringBuilder is more efficient than string.
        StringBuilder sb=new StringBuilder();
        while(n != 0) {
        	// Because it starts from 'A' , so if n=27, it should be 'A'+0 . So we use N-1 here;
            sb.insert(0,(char)('A' + (n - 1) % 26) );
            n = (n - 1) / 26;
        }
        return sb.toString();
}
}
