import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        Map<String, Boolean> noListen = new HashMap<>();

        for (int i = 0; i < n; i++) {
            noListen.put(br.readLine(), false);
        }

        List<String> result = new ArrayList<>();

        String noShow;
        while (br.ready()) {
            noShow = br.readLine();
            if (noListen.containsKey(noShow)) {
                result.add(noShow);
            }
        }

        Collections.sort(result);
        
        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }
    }
}
