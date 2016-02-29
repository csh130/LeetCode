package LinkedList;

public class SwapNodesInPair {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		// n1.next=n2;
		// ListNode n5=new ListNode(5);
		ListNode temp = swapPairs(n1);
		while (temp != null) {
			System.out.print(temp.val + "->");
			temp = temp.next;
		}
	}

	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode pre = new ListNode(0), dumpy = new ListNode(0), left = head, right = head.next, next = head;
		dumpy.next = right;
		while (right != null) {
			next = right.next;
			// swap
			pre.next = right;
			right.next = left;
			left.next = next;
			// move to next pair
			pre = left;
			left = left.next;
			if (left == null)
				return dumpy.next;
			;
			right = left.next;

		}
		return dumpy.next;
	}

	public ListNode swapPairs2(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode current = dummy;
		// current.next and next.next is one pair
		while (current.next != null && current.next.next != null) {
			ListNode first = current.next;
			ListNode second = current.next.next;
			first.next = second.next;
			current.next = second;
			current.next.next = first;
			current = current.next.next;
		}
		return dummy.next;
	}
}
