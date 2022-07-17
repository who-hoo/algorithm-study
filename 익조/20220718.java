import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }

        void addLeft(int data) {
            if (left == null) {
                left = new Node(data);
                return;
            }

            if (left.data > data) {
                left.addLeft(data);
            } else {
                left.addRight(data);
            }
        }

        void addRight(int data) {
            if (right == null) {
                right = new Node(data);
                return;
            }

            if (right.data > data) {
                right.addLeft(data);
            } else {
                right.addRight(data);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int rootValue = Integer.parseInt(br.readLine()), number;
        Node root = new Node(rootValue);

        while (br.ready()) {
            number = Integer.parseInt(br.readLine());

            if (rootValue > number) {
                root.addLeft(number);
            } else {
                root.addRight(number);
            }
        }

        postOrder(root);
    }

    private static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }
}
