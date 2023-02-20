package datastructure.linkedlist;

public class Node {

    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }

    public void append(int data) {
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = new Node(data);
    }

    public void delete(int data) {
        Node n = this;
        while (n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    public void print() {
        Node n = this;
        while (n.next != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println(n.data);
    }
}
