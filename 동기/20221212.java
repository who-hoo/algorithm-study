import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());
        Solution s = new Solution();
        System.out.println(s.solution(n, arr, x));
    }

    public String solution(int n, int[] arr, int x) {
        StringBuilder sb = new StringBuilder();
        // 모든 내부 노드가 두개의 자식 노드를 가지며, 모든 잎 노드가 동일한 깊이를 가진 이진트리
        // 모든 내부 노드가 두 개의 자식 노드를 가지고 있는지 체크 (어떻게? 일일히 모든 노드의 자식 노드를 확인?)
        // -1, 가려진 하나의 노드 대신 x 값을 넣어 다시 포화 이진 트리를 그린다.. . 어떻게..?
        // 후위 순회(왼쪽, 오른쪽, root) 결과를 출력
        
        return sb.toString();
    }

}

class Node {
    int value;
    Node left;
    Node right;


    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void insert(int value) {
        if (value < this.value) {
            if (this.left == null) {
                this.left = new Node(value);
            } else {
                this.left.insert(value);
            }
        } else {
            if (this.right == null) {
                this.right = new Node(value);
            } else {
                this.right.insert(value);
            }
        }
    }
}
