public class BOJ10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] l = new int[10001];
        for (int i = 0; i < n; i++) {
            l[Integer.parseInt(br.readLine())] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<l.length; i++) {
            if (l[i] > 0) {
                for (int j = 0; j < l[i]; j++) {
                    sb.append(i + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}
