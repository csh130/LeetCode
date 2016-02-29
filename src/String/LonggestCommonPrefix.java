package String;

public class LonggestCommonPrefix {
	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[] { "aa", "a" }));
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0 || strs == null)
			return "";
		String s = "";
		for (int j = 0; j < strs[0].length(); j++) {
			char c = strs[0].charAt(j);
			for (int i = 0; i < strs.length; i++) {
				// 不等于c 或者长度不相等  直接返回string
				if (strs[i].length() - 1 < j || strs[i].charAt(j) != c)
					return s;
			}
			s += c;
		}
		StringBuilder s=new StringBuilder();
		s.reverse().to
		
		return s;
	}
}
