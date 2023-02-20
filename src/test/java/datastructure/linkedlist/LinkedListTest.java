package datastructure.linkedlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 단방향 LinkedList 구현하기
 * 1. data를 가진 Node를 구현한다.
 * 2. append(int data) 메서드를 구현하여 data를 추가할 수 있다.
 * 3. delete(int data) 메서드를 구현하여 data를 삭제할 수 있다.
 * 4. print() 메서드를 구현하여 내부 data들을 출력할 수 있다.
 */
public class LinkedListTest {

    @DisplayName("print 메서드 구현하기")
    @Test
    void print() {
        // given
        Node node = new Node(1);

        // when, then
        node.print();
    }

    @DisplayName("Node를 추가하고 출력하기")
    @Test
    void appendNodePrint() {
        // given
        Node node = new Node(1);

        // when
        node.append(2);
        node.append(3);

        // then
        node.print(); // 1->2->3
    }

    @DisplayName("중간 Node를 삭제하고 출력하기")
    @Test
    void deleteNodePrint() {
        // given
        Node node = new Node(1);
        node.append(2);
        node.append(3);

        // when
        node.delete(2);

        // then
        node.print(); // 1->3
    }

    /**
     * 문제점: 첫 번째 노드를 삭제할 수 없다.
     */
    @DisplayName("첫 번째 Node 삭제하기")
    @Test
    void deleteFirstNode() {
        // given
        Node node = new Node(1);
        node.append(2);
        node.append(3);

        // when
        node.delete(1);

        // then
        node.print(); // 2->3이어야 하는데 1->2->3 출력
    }

    @DisplayName("LinkedList를 구현하여 첫 번째 노드도 삭제할 수 있도록 구현")
    @Test
    void implLinkedList() {
        // given
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);

        // when
        ll.delete(1);

        // then
        ll.print(); // 2->3
    }
}
