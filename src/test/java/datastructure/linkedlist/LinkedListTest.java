package datastructure.linkedlist;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        assertThat(ll.getList()).containsExactly(2, 3);
    }

    @DisplayName("정렬되지 않은 LinkedList의 중복된 값 제거하기 - 포인터")
    @Test
    void removeDuplicateDataInNotSortedLinkedList_pointer() {
        // given
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(1);
        ll.append(3);
        ll.append(4);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(4);
        ll.append(4);

        // when
        ll.removeDuplicateDataPointer();

        // then
        assertThat(ll.getList()).containsExactly(1, 3, 4, 2);
    }

    @DisplayName("정렬되지 않은 LinkedList의 중복된 값 제거하기 - 버퍼")
    @Test
    void removeDuplicateDataInNotSortedLinkedList_buffer() {
        // given
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(1);
        ll.append(3);
        ll.append(4);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(4);
        ll.append(4);

        // when
        ll.removeDuplicateDataBuffer();

        // then
        assertThat(ll.getList()).containsExactly(1, 3, 4, 2);
    }

    /**
     * 공간 복잡도: O(N)
     * 시간 복잡도: O(N)
     */
    @DisplayName("버퍼를 사용해 LinkedList에서 뒤에서 k번째 값 조회하기")
    @Test
    void findKthToLastBuffer() {
        // given
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);

        // when
        int actual = ll.findKthToLastBuffer(2);

        // then
        assertThat(actual).isEqualTo(3);
    }

    /**
     * 공간 복잡도: O(N)
     * 시간 복잡도: O(2N)
     */
    @DisplayName("재귀를 사용해 LinkedList에서 뒤에서 k번째 값 조회하기")
    @Test
    void findKthToLastRecursion() {
        // given
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);

        // when
        int actual = ll.findKthToLastRecursion(2);

        // then
        assertThat(actual).isEqualTo(3);
    }
}
