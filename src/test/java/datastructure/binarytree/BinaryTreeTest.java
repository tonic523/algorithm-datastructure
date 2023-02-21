package datastructure.binarytree;

import static org.assertj.core.api.Java6Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/** 이진트리 순회방법 구현하기
 *           (1)
 *         /    \
 *      (2)     (3)
 *     /  \
 *  (4)   (5)
 *  - 위 트리를 기준으로 수행한다.
 */
public class BinaryTreeTest {

    @DisplayName("Inorder 순회한 값을 반환한다.")
    @Test
    void inorder() {
        // given
        Node three = new Node(3, null, null);
        Node four = new Node(4, null, null);
        Node five = new Node(5, null, null);
        Node two = new Node(2, four, five);
        Node root = new Node(1, two, three);
        BinaryTree binaryTree = new BinaryTree(root);

        // when
        List<Integer> actual = binaryTree.inorder(root);

        // then
        assertThat(actual).containsExactly(4, 2, 5, 1, 3);
    }

    @DisplayName("Preorder 순회한 값을 반환한다.")
    @Test
    void preorder() {
        // given
        Node three = new Node(3, null, null);
        Node four = new Node(4, null, null);
        Node five = new Node(5, null, null);
        Node two = new Node(2, four, five);
        Node root = new Node(1, two, three);
        BinaryTree binaryTree = new BinaryTree(root);

        // when
        List<Integer> actual = binaryTree.preorder(root);

        // then
        assertThat(actual).containsExactly(1, 2, 4, 5, 3);
    }

    @DisplayName("Postorder 순회한 값을 반환한다.")
    @Test
    void postorder() {
        // given
        Node three = new Node(3, null, null);
        Node four = new Node(4, null, null);
        Node five = new Node(5, null, null);
        Node two = new Node(2, four, five);
        Node root = new Node(1, two, three);
        BinaryTree binaryTree = new BinaryTree(root);

        // when
        List<Integer> actual = binaryTree.postorder(root);

        // then
        assertThat(actual).containsExactly(4, 5, 2, 3, 1);
    }
}
