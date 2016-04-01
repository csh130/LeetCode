package LinkedList;

public class AddTwoNumber {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(9);
		ListNode n2 = new ListNode(9);
		ListNode n3 = new ListNode(5);
		ListNode n4 = new ListNode(7);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(6);
		// n1.next = n2;sFs
		// n3.next = n4;
		// n4.next = n5;
		// n5.next = n6;
		System.out.println(addTwoNumbers(n1, n2).next);
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		String s1 = getString(l1);
		String s2 = getString(l2);
		String res = addTwoString(s1, s2);

		ListNode head = new ListNode(0), cur = head;
		for (int i = 0; i < res.length(); i++) {
			int num = (res.charAt(i) - '0');
			ListNode node = new ListNode(num);
			cur.next = node;
			cur = cur.next;
		}
		return head.next;

	}

	public static String getString(ListNode node) {
		if (node == null)
			return "";
		StringBuilder sb = new StringBuilder();
		ListNode cur = node;
		while (cur != null) {
			sb.append(cur.val);
			cur = cur.next;
		}
		return sb.reverse().toString();
	}

	public static String addTwoString(String s1, String s2) {
		int len1 = s1.length() - 1, len2 = s2.length() - 1, sign = 0;
		StringBuilder sb = new StringBuilder();
		while (len1 >= 0 || len2 >= 0) {
			int num = sign;
			if (len1 >= 0)
				num += (s1.charAt(len1) - '0');
			if (len2 >= 0)
				num += (s2.charAt(len2) - '0');
			if (num >= 10) {
				sign = 1;
				num -= 10;
			} else
				sign = 0;
			len1--;
			len2--;
			sb.append(num);
		}
		if (sign != 0)
			sb.append(1);
		return sb.reverse().toString();
	}
}
