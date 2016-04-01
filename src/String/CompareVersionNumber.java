package String;

public class CompareVersionNumber {
	public static void main(String[] args) {
		System.out.println(compareVersion("1.5.2", "1.2"));
	}

	public static int compareVersion(String version1, String version2) {
		String[] s1 = version1.split("\\.");
		String[] s2 = version2.split("\\.");
		int i = 0, j = 0;
		while (i < s1.length || j < s2.length) {
			int num1 = 0, num2 = 0;
			if (i < s1.length)
				num1 = Integer.parseInt(s1[i]);
			if (j < s2.length)
				num2 = Integer.parseInt(s2[j]);
			i++;
			j++;
			if (num1 > num2)
				return 1;
			else if (num1 == num2)
				continue;
			else
				return -1;
		}
		return 0;
	}
}
