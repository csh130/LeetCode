package LinkedList;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public String toString() {
		ListNode temp = this;
		String str = "";
		while (temp != null) {
			str += " " + temp.val;
			temp = temp.next;
		}
		return str;
	}
}
