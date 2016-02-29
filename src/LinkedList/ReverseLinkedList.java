package LinkedList;
/**
 * Reverse a linkedlist
 * */

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return "->" + val;

	}
}

public class ReverseLinkedList {
	/**
	 * Definition for singly-linked list.
	 */

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		ListNode head = reverseList(n1);
		System.out.println(head + "" + head.next + "" + head.next.next);
	}

	public static ListNode reverseList(ListNode head) {
		if (head != null) {
			ListNode temp = head, pre = null, next = head.next;
			while (temp != null) {
				next = temp.next;
				temp.next = pre;
				pre = temp;
				temp = next;
			}
			return pre;
		}
		return head;

	}

	// Recursive solution
	public ListNode reverseList2(ListNode head) {
		return reverseListInt(head, null);
	}

	public ListNode reverseListInt(ListNode head, ListNode newHead) {
		if (head == null)
			return newHead;
		ListNode next = head.next;
		head.next = newHead;
		return reverseListInt(next, head);

	}
}
