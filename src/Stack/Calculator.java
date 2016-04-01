package Stack;

import java.util.Stack;

public class Calculator {

	public static void main(String[] args) {
		System.out.println(calculate3("24+3-(2-3)"));
	}

	/**
	 * 主要考虑-(2-3) 的情况,把括号之前的运算符号压栈, 括号里面的算出来压栈 然后循环到反括号的时候 把括号前的数值跟括号里面的进行运算
	 */

	public static int calculate3(String s) {
		if (s.length() == 0 || s == null)
			return 0;
		char[] arr = s.toCharArray();
		int result = 0, sign = 1;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < arr.length; i++) {
			int num = 0;
			if (Character.isDigit(arr[i])) {
				while (Character.isDigit(arr[i]) && i < arr.length) {
					num = 10 * num + (arr[i] - '0');
					i++;

				}
				result += sign * num;
				i--;
				continue;
			} else if (arr[i] == '+') {
				sign = 1;
			} else if (arr[i] == '-') {
				sign = -1;
			} else if (arr[i] == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			} else if (arr[i] == ')') {
				result = +stack.pop() * result + stack.pop();
			}
		}
		return result;
	}

	public static int calculate(String s) {
		int len = s.length(), sign = 1, result = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < len; i++) {
			if (Character.isDigit(s.charAt(i))) {
				int sum = s.charAt(i) - '0';
				// 把多位数sum出来, sum就是当前的数
				while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
					sum = sum * 10 + s.charAt(i + 1) - '0';
					i++;
				}
				result += sum * sign;
			} else if (s.charAt(i) == '+')
				sign = 1;
			else if (s.charAt(i) == '-')
				sign = -1;
			else if (s.charAt(i) == '(') {
				// 把括号之前的运算符跟运算结果压栈, sigh至为1, result=0
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			} else if (s.charAt(i) == ')') {
				result = result * stack.pop() + stack.pop();
			}

		}
		return result;
	}

	public static int calculator(String str) {
		int result = 0;
		int sign = 1;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isDigit(c)) {
				int num = c - '0';
				while (i + 1 < str.length()
						&& Character.isDigit(str.charAt(i + 1))) {
					num = num * 10 + (str.charAt(i + 1) - '0');
					i++;
				}
				result += num * sign;
			} else if (c == '+') {
				sign = 1;
			} else if (c == '-') {
				sign = -1;
			} else if (c == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			} else if (c == ')') {
				if (!stack.isEmpty())
					result = result * stack.pop() + stack.pop();
			}

		}
		return result;

	}
}
