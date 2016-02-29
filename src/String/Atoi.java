package String;

public class Atoi {
	public static void main(String[] args) {
		System.out.println(myAtoi("123  456"));
	}

	public static int myAtoi(String str) {
		if (str.length() == 0 || str.equals(""))
			return 0;
		char ch[] = str.toCharArray();
		StringBuilder num = new StringBuilder();
		int plus = 0, minu = 0, space = 0;
		int index = 0;
		
		while (ch[index] == ' ') {
			index++;
		}
		for (int i = index; i < ch.length; i++) {
			char c = ch[i];
			// if c is a digit, add it to the num
			if (Character.isDigit(c))
				num.append(c);
			else {
				if (c == '-')
					minu++;
				else if (c == '+')
					plus++;
				else if (c == ' ')
					return 0;
				else
					break;
			}
			if (num.length() >= 11)
				break;
		}
		// if there is no number found in the string
		if (num == null || num.length() == 0 || num.toString().equals("-")
				|| (plus != 0 && minu != 0) || plus >= 2 || minu >= 2)
			return 0;
		if (num.length() >= 10 && num.length() < 11) {
			Long a = Long.valueOf(num.toString());
			if (minu == 1)
				a = -a;
			if (a > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			else
				return Integer.MIN_VALUE;
		}
		if (minu == 1)
			num.insert(0, '-');
		return Integer.valueOf(num.toString());
	}
	
	
	/**
	 * Better solution
	 * */
	public static int myAtoi2(String str) {
	    if (str == null || str.length() == 0)
	        return 0;//
	    //去除首尾的空格.
	    str = str.trim();
	    char firstChar = str.charAt(0);
	    int sign = 1, start = 0, len = str.length();
	    long sum = 0;
	    if (firstChar == '+') {
	        sign = 1;
	        start++;
	    } else if (firstChar == '-') {
	        sign = -1;
	        start++;
	    }
	    for (int i = start; i < len; i++) {
	        if (!Character.isDigit(str.charAt(i)))
	            return (int) sum * sign;
	        sum = sum * 10 + str.charAt(i) - '0';
	        if (sign == 1 && sum > Integer.MAX_VALUE)
	            return Integer.MAX_VALUE;
	        if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
	            return Integer.MIN_VALUE;
	    }

	    return (int) sum * sign;
	}
	
}
