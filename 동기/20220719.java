import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 전위 순회의 결과가 입력 값으로 들어오게 되고
        // 입력 값을 통해 Tree를 만든다
        // 만들어진 Tree 에서 후위순회의 결과값을 출력
        Tree tree = new Tree();

        while (true) {
            int node = Integer.parseInt(br.readLine());
            tree.createNode(node);
        }
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

class Tree {

    public Node root;
    private int target = 0;

    public void createNode(int node) {
        if (root == null) {
            root = new Node(node);
            target = node;
        } else if (target < node) {
            // left
            root.left = new Node(node);
        } else if (target > node) {
            // right
            root.right = new Node(node);
        } else {
            searchNode();
        } 
    }
}
