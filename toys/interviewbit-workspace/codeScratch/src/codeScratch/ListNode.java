package codeScratch;

import java.security.GeneralSecurityException;

public class ListNode {

	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	public ListNode getIntersectionNode(ListNode a, ListNode b) {
		ListNode aCurrent = a;
		while (aCurrent != null) {

			System.out.println("aCurrent " + aCurrent.val);
			ListNode bCurrent = b;
			while (bCurrent != null) {

				System.out.println("bCurrent " + bCurrent.val);
				if (bCurrent == aCurrent) {
					ListNode aCurrentTmp = aCurrent, bCurrentTmp = bCurrent;
					while (aCurrentTmp != null && bCurrentTmp != null) {
						System.out.println("aCurrentTmp " + aCurrentTmp.val);
						System.out.println("bCurrentTmp " + bCurrentTmp.val);
						if (aCurrentTmp != bCurrentTmp) {
							break;
						} else if (aCurrentTmp.next == null && bCurrentTmp.next == null) {
							System.out.println(aCurrent.val);
							return aCurrent;
						}
						aCurrentTmp = aCurrentTmp.next;
						bCurrentTmp = bCurrentTmp.next;
					}
					// break;
				}
				bCurrent = bCurrent.next;
			}
			aCurrent = aCurrent.next;
		}
		return null;
	}

	public static void main(String[] args) {
		// ListNode a = new ListNode(1);
		// a.next = new ListNode(2);
		// a.next.next = new ListNode(3);
		// a.next.next.next = new ListNode(4);
		//
		// ListNode b = new ListNode(6);
		// b.next = new ListNode(7);
		// b.next.next = new ListNode(3);
		// b.next.next.next = new ListNode(8);
		ListNode a = new ListNode(5);
		a.next = new ListNode(2);
		a.next.next = new ListNode(3);

		ListNode b = new ListNode(1);
		b.next = new ListNode(5);
		b.next.next = new ListNode(2);
		b.next.next.next = new ListNode(3);

		System.out.println(a.getIntersectionNode(a, b).val);
	}

}
