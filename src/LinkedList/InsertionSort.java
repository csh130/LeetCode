package LinkedList;

public class InsertionSort {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(5);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(7);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		System.out.println(insertionSortList(n1));
	}

	public static ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode cur = head.next, dummy = new ListNode(0), curNext = head, temp = head, pre = head;
		dummy.next = head;

		while (cur != null) {
			curNext = cur.next;
			temp = dummy.next;
			ListNode pre_temp=dummy.next;
			while (temp != cur) {
				if (temp.val >= cur.val) {
					pre_temp.next=cur;
					cur.next = temp;
					break;
				}
				pre_temp=temp;
				temp = temp.next;
			}
			pre.next = curNext;
			cur = curNext;
		}
		return dummy.next;
	}
}
