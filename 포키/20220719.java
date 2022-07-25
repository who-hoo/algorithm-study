import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num;
        int rootNum = Integer.parseInt(br.readLine());
        Node root = new Node(rootNum);

        //이진 트리 만들기
        while ((num = br.readLine()) != null) {
            root.setChild(Integer.parseInt(num));
        }
        drill(root);
    }

    public static void drill(Node node) {
        if (node == null) {
            return;
        }
        drill(node.left);
        drill(node.right);
        System.out.println(node.val);
    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public void setChild(int num) {
            if (num < val) {
                if (left == null) left = new Node(num);
                else left.setChild(num);
            } else {
                if (right == null) right = new Node(num);
                else right.setChild(num);
            }
        }
    }
}
