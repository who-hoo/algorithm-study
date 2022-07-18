package 아더;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5639_이진검색트리 {

    static Node rootNode;
    static StringBuilder sb = new StringBuilder();

    static class Node {
        int data;
        Node leftChild, rightChild;

        public Node(int data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }

        public void insert(int data) {
            // 데이터를 넣을 때 자신의 data와 비교해서 작으면 left, 크면 right에 넣어준다
            // left나 right가 null이 아니라면 재귀를 통해 다시 비교하고 넣어준다
            if (this.data > data) {
                // leftChild가 null이라면 새롭게 넣어준다, 아니라면 재귀호출
                if (this.leftChild == null) {
                    this.leftChild = new Node(data);
                } else {
                    this.leftChild.insert(data);
                }
            } else {
                if (this.rightChild == null) {
                    this.rightChild = new Node(data);
                } else {
                    this.rightChild.insert(data);
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            input();
            postOrder(rootNode);
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void print() {
        System.out.println(sb.toString());
    }

    private static void postOrder(Node node) {
        // 트리를 갖고 postOrder 구현(left -> right -> root)
        if (node.leftChild != null) {
            postOrder(node.leftChild);
        }
        if (node.rightChild != null) {
            postOrder(node.rightChild);
        }
        sb.append(node.data).append("\n");
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        // 전위 순회이므로 맨 처음 값이 루트노드이다;
        rootNode = new Node(Integer.parseInt(line));
        while (line != null) {
            int data = Integer.parseInt(line);
            // 이미 한 번 넣었다(루트노드)
            if (rootNode.data != data) {
                rootNode.insert(data);
            }

            line = br.readLine();
        }
    }
}
