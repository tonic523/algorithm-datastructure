package datastructure.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class Graph {

    private final List<Node> nodes;

    public Graph(List<Integer> nodes) {
        this.nodes = nodes.stream()
                .map(Node::new)
                .collect(Collectors.toList());
    }

    public void addEdge(int nodeData1, int nodeData2) {
        Node node1 = findByData(nodeData1);
        Node node2 = findByData(nodeData2);
        node1.adjancentNodes.add(node2);
        node2.adjancentNodes.add(node1);
    }

    public List<Integer> dfs(int startData) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node startNode = findByData(startData);
        stack.add(startNode);
        while (!stack.isEmpty()) {
            Node now = stack.pop();
            result.add(now.data);
            now.visited = true;
            List<Node> adjancency = now.adjancentNodes.stream()
                    .filter(node -> !node.visited)
                    .filter(node -> !stack.contains(node))
                    .collect(Collectors.toList());
            stack.addAll(adjancency);
        }
        initVisited();
        return result;
    }

    public List<Integer> dfsRecursive(int startData) {
        List<Integer> result = new ArrayList<>();
        dfsRecursive(result, startData);
        return result;
    }

    private void dfsRecursive(List<Integer> result, int startData) {
        if (result.contains(startData)) {
            return;
        }
        Node node = findByData(startData);
        result.add(node.data);
        node.visited = true;
        List<Node> adjancentNodes = node.adjancentNodes
                .stream()
                .filter(item -> !item.visited)
                .collect(Collectors.toList());
        for (Node adjancentNode : adjancentNodes) {
            dfsRecursive(result, adjancentNode.data);
        }
    }

    public List<Integer> bfs(int startData) {
        List<Integer> result = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        Node startNode = findByData(startData);
        queue.add(startNode);
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            result.add(now.data);
            now.visited = true;
            List<Node> adjancency = now.adjancentNodes.stream()
                    .filter(node -> !node.visited)
                    .filter(node -> !queue.contains(node))
                    .collect(Collectors.toList());
            queue.addAll(adjancency);
        }
        return result;
    }

    private Node findByData(int nodeData1) {
        return nodes.stream()
                .filter(node -> node.data == nodeData1)
                .findAny()
                .get();
    }

    private void initVisited() {
        for (Node node : nodes) {
            node.visited = false;
        }
    }

    class Node {

        int data;
        LinkedList<Node> adjancentNodes = new LinkedList<>();
        boolean visited = false;

        public Node(int data) {
            this.data = data;
        }
    }
}
