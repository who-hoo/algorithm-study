package beakjoon.main_5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            String input = br.readLine();
            if (input == null || input.equals("")) break;
            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
    }

    public static void postOrder(Node node) {
        if (node.left != null) postOrder(node.left);
        if (node.right != null) postOrder(node.right);
        System.out.println(node.value);
    }
}

class Node {

    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    void insert(int insertNum) {
        if (this.value < insertNum) {
            if (this.right != null) {
                this.right.insert(insertNum);
            } else {
                this.right = new Node(insertNum);
            }
        } else {
            if (this.left != null) {
                this.left.insert(insertNum);
            } else {
                this.left = new Node(insertNum);
            }
        }
    }


}
