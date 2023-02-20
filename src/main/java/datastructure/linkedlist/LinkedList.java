package datastructure.linkedlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LinkedList {

    Node header;

    static class Node {

        int data;
        Node next;
    }

    public LinkedList() {
        header = new Node();
    }

    public void append(int data) {
        Node end = new Node();
        end.data = data;
        Node n = header;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public void delete(int data) {
        Node n = header;
        while (n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    public void removeDuplicateDataPointer() {
        Node n = header;
        while (n != null && n.next != null) {
            Node r = n;
            while (r.next != null) {
                if (n.data == r.next.data) {
                    r.next = r.next.next;
                } else {
                    r = r.next;
                }
            }
            n = n.next;
        }
    }

    public void removeDuplicateDataBuffer() {
        HashSet<Integer> buffer = new HashSet<>();
        Node n = header;
        while (n.next != null) {
            if (buffer.contains(n.next.data)) {
                n.next = n.next.next;
            } else {
                buffer.add(n.next.data);
                n = n.next;
            }
        }
    }

    public List<Integer> getList() {
        ArrayList<Integer> result = new ArrayList<>();
        Node n = header.next;
        while (n.next != null) {
            result.add(n.data);
            n = n.next;
        }
        result.add(n.data);
        return result;
    }
}
