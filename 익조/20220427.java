import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

    static int[][] office, origin;
    static int n, m, result = 64;
    static List<CCTV> cctvs = new ArrayList<>();
    static Stack<int[][]> logs = new Stack<>();

    static class CCTV {
        int x;
        int y;
        int cctvNumber;

        public CCTV(int x, int y, int cctvNumber) {
            this.x = x;
            this.y = y;
            this.cctvNumber = cctvNumber;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        office = new int[n][m];
        origin = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                origin[i][j] = office[i][j];
                if (office[i][j] >= 1 && office[i][j] <= 5) {
                    cctvs.add(new CCTV(i, j, office[i][j]));
                }
            }
        }

        runCCTV(0);

        System.out.println(result);
    }

    private static void runCCTV(int depth) {
        if (depth == cctvs.size()) {
            verify();
            return;
        }

        CCTV c = cctvs.get(depth);
        int cctvNumber = c.cctvNumber, x = c.x, y = c. y;

        if (cctvNumber == 1) {
            for (int i = 0; i < 4; i++) {
                copy();
                observe1(x, y, i);
                runCCTV(depth + 1);
                office = logs.pop();
            }
        } else if (cctvNumber == 2) {
            for (int i = 0; i < 2; i++) {
                copy();
                observe2(x, y, i);
                runCCTV(depth + 1);
                office = logs.pop();
            }
        } else if (cctvNumber == 3) {
            for (int i = 0; i < 4; i++) {
                copy();
                observe3(x, y, i);
                runCCTV(depth + 1);
                office = logs.pop();
            }
        } else if (cctvNumber == 4) {
            for (int i = 0; i < 4; i++) {
                copy();
                observe4(x, y, i);
                runCCTV(depth + 1);
                office = logs.pop();
            }
        } else if (cctvNumber == 5) {
            copy();
            observe5(x, y);
            runCCTV(depth + 1);
            office = logs.pop();
        }
    }

    private static void copy() {
        int[][] office = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                office[i][j] = Main.office[i][j];
            }
        }
        logs.push(office);
    }

    private static void rollback() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                office[i][j] = origin[i][j];
            }
        }
    }

    private static void observe1(int x, int y, int direction) {
        if (direction == 0) {
            observeRight(x, y);
        } else if (direction == 1) {
            observeDown(x, y);
        } else if (direction == 2) {
            observeLeft(x, y);
        } else if (direction == 3) {
            observeUp(x, y);
        }
    }

    private static void observe2(int x, int y, int direction) {
        if (direction == 0) {
            observeRight(x, y);
            observeLeft(x, y);
        } else if (direction == 1) {
            observeDown(x, y);
            observeUp(x, y);
        }
    }

    private static void observe3(int x, int y, int direction) {
        if (direction == 0) {
            observeUp(x, y);
            observeRight(x, y);
        } else if (direction == 1) {
            observeRight(x, y);
            observeDown(x, y);
        } else if (direction == 2) {
            observeDown(x, y);
            observeLeft(x, y);
        } else if (direction == 3) {
            observeLeft(x, y);
            observeUp(x, y);
        }
    }

    private static void observe4(int x, int y, int direction) {
        if (direction == 0) {
            observeLeft(x, y);
            observeUp(x, y);
            observeRight(x, y);
        } else if (direction == 1) {
            observeUp(x, y);
            observeRight(x, y);
            observeDown(x, y);
        } else if (direction == 2) {
            observeRight(x, y);
            observeDown(x, y);
            observeLeft(x, y);
        } else if (direction == 3) {
            observeDown(x, y);
            observeLeft(x, y);
            observeUp(x, y);
        }
    }

    private static void observe5(int x, int y) {
        observeRight(x, y);
        observeDown(x, y);
        observeLeft(x, y);
        observeUp(x, y);
    }

    private static void observeRight(int x, int y) {
        for (int i = y + 1; i < m; i++) {
            if (office[x][i] == 6) {
                break;
            }
            if (office[x][i] == 0) {
                office[x][i] = 7;
            }
        }
    }

    private static void observeLeft(int x, int y) {
        for (int i = y - 1; i > -1; i--) {
            if (office[x][i] == 6) {
                break;
            }
            if (office[x][i] == 0) {
                office[x][i] = 7;
            }
        }
    }

    private static void observeUp(int x, int y) {
        for (int i = x - 1; i > -1; i--) {
            if (office[i][y] == 6) {
                break;
            }
            if (office[i][y] == 0) {
                office[i][y] = 7;
            }
        }
    }

    private static void observeDown(int x, int y) {
        for (int i = x + 1; i < n; i++) {
            if (office[i][y] == 6) {
                break;
            }
            if (office[i][y] == 0) {
                office[i][y] = 7;
            }
        }
    }

    private static void verify() {
        int temp = 0;
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                if (office[j][k] == 0) {
                    temp++;
                }
            }
        }

        result = Math.min(result, temp);
    }
}
