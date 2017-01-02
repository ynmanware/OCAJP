package datastructures.linkedlist;

/**
 *
 * @Author Yogesh.Manware
 *
 */

public class FindNthFromLast {

  public static void main(String[] args) {



    Node head = initialize1();
    // find the nth element from last
    System.out.println(findNthElementFromLast(head, 1).value); // A
    System.out.println(findNthElementFromLast(head, 2)); // null

    head = initialize3();
    // find the nth element from last
    System.out.println(findNthElementFromLast(head, 2).value);// B

    head = initialize5();
    // find the nth element from last
    System.out.println(findNthElementFromLast(head, 3).value); // C


  }

  /**
   * @param head
   * @return
   */
  private static Node findNthElementFromLast(Node head, int n) {

    Node node = head;
    int i = 1;
    Node requiredNode = null;

    while (node != null) {
      if (i == n) {
        requiredNode = head;
      } else if (requiredNode != null) {
        requiredNode = requiredNode.next;
      }

      node = node.next;
      i++;
    }

    return requiredNode;

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



class Node {
  String value = "undefined";
  Node next = null;
}
