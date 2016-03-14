package LinkedList;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * 
 * Subscribe to see which companies asked this question
 * */
public class Partritionlist {

	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; } }
	 */

	public ListNode partition(ListNode head, int x) {
		ListNode head1 = new ListNode(0);
		ListNode head2 = new ListNode(0);
		ListNode cur1 = head1, cur2 = head2;
		if (head != null)
			while (head != null) {
				if (head.val < x) {
					// add to the smaller list
					cur1.next = head;
					cur1 = cur1.next;
				} else {
					// add to bigger llist
					cur2.next = head;
					cur2 = cur2.next;
				}
				head = head.next;
			}
		// make the end of second as null , in case that it forms a circle.
		cur2.next = null;
		cur1.next = head2.next;
		return head1.next;
	}
}