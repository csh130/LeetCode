package LinkedList;

public class ReorderList {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		reorderList2(n1);
		System.out.println(n1);

	}

	public static void reorderList(ListNode head) {
		// to reorder the list, make sure the list's length >1
		if (head == null || head.next == null)
			return;
		ListNode slow = head, fast = head;
		// use slow and fast pointer to reach the middle point of the list
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// reverse the second half
		ListNode pre = null, cur = slow.next, next = slow.next;
		while (cur.next != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		cur.next = pre;
		slow.next = null;
		// re order the linkedlist
		ListNode temp = head, leftNext = head, rightNext = cur;
		while (cur != null) {
			leftNext = temp.next;
			rightNext = cur.next;
			temp.next = cur;
			cur.next = leftNext;
			temp = leftNext;
			cur = rightNext;
		}

	}
	
	public static void reorderList2(ListNode head) {
        if(head==null||head.next==null) return;

        //Find the middle of the list
        ListNode p1=head;
        ListNode p2=head;
        while(p2.next!=null&&p2.next.next!=null){ 
            p1=p1.next;
            p2=p2.next.next;
        }

        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle=p1;
        ListNode preCurrent=p1.next;
        while(preCurrent.next!=null){
            ListNode current=preCurrent.next;
            preCurrent.next=current.next;
            current.next=preMiddle.next;
            preMiddle.next=current;
        }

        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        p1=head;
        p2=preMiddle.next;
        while(p1!=preMiddle){
            preMiddle.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=preMiddle.next;
        }
    }
}
