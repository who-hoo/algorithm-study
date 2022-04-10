import java.util.*;

class Solution {
    static class Node {

        int node;
        LinkedList<Node> connectedNode = new LinkedList<>();

        Node(int node) {
            this.node = node;
        }

        void connect(Node node) {
            this.connectedNode.add(node);
            node.connectedNode.add(this);
        }

        void disconnect(Node node) {
            this.connectedNode.remove(node);
            node.connectedNode.remove(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node1 = (Node) o;
            return node == node1.node;
        }

        @Override
        public int hashCode() {
            return Objects.hash(node);
        }
    }

    public int dfs(Node root, int nodeCount) {
        boolean[] visited = new boolean[nodeCount + 1];
        Stack<Node> stack = new Stack<>();
        visited[root.node] = true;
        stack.push(root);
        int count = 1;
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            for (Node n : node.connectedNode) {
                if (visited[n.node] == false) {
                    visited[n.node] = true;
                    stack.push(n);
                    count++;
                }
            }
        }
        return count;
    }

    public int solution(int n, int[][] wires) {
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }
        for (int[] wire : wires) {
            nodes[wire[0]].connect(nodes[wire[1]]);
        }

        int answer = n;
        for (int i = 0; i < wires.length; i++) {
            int[] wire = wires[i];
            nodes[wire[0]].disconnect(nodes[wire[1]]);
            int group = dfs(nodes[1], n);
            int diff = Math.abs((n - group) - group);
            if (diff < answer) {
                answer = diff;
            }
            nodes[wire[0]].connect(nodes[wire[1]]);
        }

        return answer;
    }
}
