package collections.linkedlist;

import java.util.List;

public class FindMiddleElement {

	public static String search(List<String> list) {
		// prepare linked list
		Node head = null;
		Node n = null;
		Node p = null;

		for (String string : list) {
			p = n;
			n = new Node();
			if (p != null) {
				p.next = n;
			}

			n.value = string;
			if (head == null) {
				head = n;
			}
		}

		Node n1 = head;
		Node middle = head;
		int i = 0;
		while (n1.next != null) {
			if (i % 2 == 0) {
				middle = middle.next;
			}
			n1 = n1.next;
			i++;
		}

		return middle.value;
	}

}

class Node {

	String value = null;
	Node next = null;

}
