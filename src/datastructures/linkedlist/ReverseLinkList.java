package datastructures.linkedlist;

/**
 *
 * @Author Yogesh.Manware
 *
 */

public class ReverseLinkList {

  public static void main(String[] args) {
    Node head = initialize5();
    head = reverse(null, head);
    traverse(head);
  }

  public static void traverse(Node n) {
    while (n != null) {
      System.out.println(n.value);
      n = n.next;
    }
  }


  public static Node reverse(Node head, Node n) {
    if (n.next == null) {
      head = n;
      return n;
    }

    head = reverse(head, n.next);
    Node o = n.next;
    o.next = n;
    n.next = null;
    return head;
  }


  private static Node initialize1() {
    Node n1 = new Node();
    n1.value = "A";
    return n1;
  }


  private static Node initialize3() {
    Node n1 = new Node();
    n1.value = "A";

    Node n2 = new Node();
    n2.value = "B";
    n1.next = n2;

    Node n3 = new Node();
    n3.value = "C";
    n2.next = n3;

    return n1;
  }


  private static Node initialize5() {
    Node n1 = new Node();
    n1.value = "A";

    Node n2 = new Node();
    n2.value = "B";
    n1.next = n2;

    Node n3 = new Node();
    n3.value = "C";
    n2.next = n3;

    Node n4 = new Node();
    n4.value = "D";
    n3.next = n4;

    Node n5 = new Node();
    n5.value = "E";
    n4.next = n5;

    return n1;
  }
}



