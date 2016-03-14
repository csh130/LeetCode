package LinkedList;

public class RemoveDuplicate {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		System.out.println(deleteDuplicates(n1).toString());
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		ListNode pre = head, cur = head;
		while (head.next != null && head.next.val == head.val)
			head = head.next;
		head = head.next;
		cur = head;
		pre = head;
		while (cur.next != null) {
			while (cur.next != null && cur.val == cur.next.val) {
				cur = cur.next;
			}
			pre.next = cur;
			pre = cur;

		}

		return head;
	}
	
	public String print(ListNode node) {
		ListNode temp = node;
		String str = "?";
		while (temp.next != null)
			str += " " + temp.val;
		return str;
	}
}
