import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static class Node {

		int n;
		Node left;
		Node right;

		Node(int n) {
			this.n = n;
		}

		void insertLeft(Node node) {
			if (this.left == null) {
				this.left = node;
			} else {
				this.left.insertLeft(node);
			}
		}

		void insertRight(Node node) {
			if (this.right == null) {
				this.right = node;
			} else {
				this.right.insertRight(node);
			}
		}
	}

	static class BinaryTree {

		Node root;

		BinaryTree(Node root) {
			this.root = root;
		}

		void insert(Node node) {
			if (root.n > node.n) {
				root.insertLeft(node);
			} else {
				root.insertRight(node);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		Node root = new Node(Integer.parseInt(in.readLine()));
		BinaryTree tree = new BinaryTree(root);
		String line;
		while ((line = in.readLine()) != null) {
			Node node = new Node(Integer.parseInt(line));
			tree.insert(node);
		}
		//TODO: 후위순회

		out.close();
		in.close();
	}
}
