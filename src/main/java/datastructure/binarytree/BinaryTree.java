package datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public List<Integer> inorder(Node node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(inorder(node.left));
        result.add(node.data);
        result.addAll(inorder(node.right));
        return result;
    }

    public List<Integer> preorder(Node node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        result.add(node.data);
        result.addAll(preorder(node.left));
        result.addAll(preorder(node.right));
        return result;
    }

    public List<Integer> postorder(Node node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(postorder(node.left));
        result.addAll(postorder(node.right));
        result.add(node.data);
        return result;
    }
}
