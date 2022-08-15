import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

    static int targetChannel;
    static int targetChannelSize, buttonCount = 500000;
    static boolean[] brokenButton;
    static List<Integer> targetButtons = new ArrayList<>();
    static Stack<Integer> buttons = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        brokenButton = new boolean[10]; // false : 정상, true : 고장

        int n = Integer.parseInt(br.readLine());
        targetChannel = n;

        int m = Integer.parseInt(br.readLine());

        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                brokenButton[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int presentChannel = 100;
        int manualCount = Math.abs(n - presentChannel);

        String targetChannel = String.valueOf(n);
        targetChannelSize = targetChannel.length();
        for (int i = 0; i < targetChannelSize; i++) {
            targetButtons.add(targetChannel.charAt(i) - 48);
        }

        pushButton(0, 0);

        if (m < 10) {
            targetChannelSize++;
            buttons.clear();

            for (int i = 1; i < 10; i++) {
                if (!brokenButton[i]) {
                    buttons.add(i);
                    break;
                }
            }

            if (!buttons.isEmpty()) {
                pushButton(1, 1);
            }

            if (Main.targetChannel > 9) {

                targetChannelSize -= 2;
                buttons.clear();

                for (int i = 9; i > -1; i--) {
                    if (!brokenButton[i]) {
                        buttons.add(i);
                        break;
                    }
                }

                if (!buttons.isEmpty()) {
                    pushButton(1, 1);
                }
            }
        }

        System.out.println(Math.min(manualCount, buttonCount));
    }

    private static void pushButton(int depth, int count) {
        if (depth == targetChannelSize) {
            if (verify()) {
                buttonCount = Math.min(buttonCount, count);
            } else {
                buttonCount = Math.min(buttonCount, count + Math.abs(
                    targetChannel - Integer.parseInt(buttons.toString().replaceAll("[^0-9]", ""))));
            }

            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!brokenButton[i]) {
                buttons.push(i);
                pushButton(depth + 1, count + 1);
                buttons.pop();
            }
        }
    }

    private static boolean verify() {
        if (targetButtons.size() != buttons.size()) {
            return false;
        }

        for (int i = 0; i < targetButtons.size(); i++) {
            if (targetButtons.get(i) != buttons.get(i)) {
                return false;
            }
        }

        return true;
    }
}
