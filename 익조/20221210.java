import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int[] nodes;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), deleteIndex = 0;
        nodes = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nodes[i] = Integer.parseInt(st.nextToken());
            if (nodes[i] == -1) {
                deleteIndex = i;
            }
        }

        nodes[deleteIndex] = Integer.parseInt(br.readLine());

        Arrays.sort(nodes);

        int mid = n / 2;
        Node root = new Node(nodes[mid]);
        dc(root, 0, mid - 1);
        dc(root, mid + 1, n - 1);

        postOrder(root);
        System.out.println(result);
    }

    private static void dc(Node root, int start, int end) {
        if (start == end) {
            root.add(nodes[start]);
            return;
        }

        int mid = (start + end) / 2;
        root.add(nodes[mid]);
        dc(root, start, mid - 1);
        dc(root, mid + 1, end);
    }

    private static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.leftChild);
        postOrder(node.rightChild);
        result.append(node.value).append(" ");
    }

    private static class Node {
        int value;
        Node leftChild;
        Node rightChild;

        Node(int value) {
            this.value = value;
        }

        public Node add(int value) {
            if (this.value > value) {
                return addLeft(value);
            } else if (this.value < value){
                return addRight(value);
            } else {
                return null;
            }
        }

        private Node addLeft(int value) {
            if (leftChild == null) {
                leftChild = new Node(value);
                return leftChild;
            }

            if (leftChild.value > value) {
                return leftChild.addLeft(value);
            } else {
                return leftChild.addRight(value);
            }
        }

        private Node addRight(int value) {
            if (rightChild == null) {
                rightChild = new Node(value);
                return rightChild;
            }

            if (rightChild.value > value) {
                return rightChild.addLeft(value);
            } else {
                return rightChild.addRight(value);
            }
        }
    }
}
