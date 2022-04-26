import java.util.Scanner;

class Main {

    static int[][] office, origin;
    static boolean[][] visited;
    static int n, m, result = 64;
    static int[] cctv = {0, 4, 2, 4, 4, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        office = new int[n][m];
        origin = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                office[i][j] = sc.nextInt();
                origin[i][j] = office[i][j];
            }
        }

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                if (office[j][k] == 0 || office[j][k] == 7) {
                    continue;
                }

                /**
                 * // TODO
                for (int i = 0; i < cctv[office[j][k]]; i++) {

                    if (office[j][k] == 1) {
                        observe1(j, k, i);
                    } else if (office[j][k] == 2) {
                        observe2(j, k, i);
                    } else if (office[j][k] == 3) {
                        observe3(j, k, i);
                    } else if (office[j][k] == 4) {
                        observe4(j, k, i);
                    } else if (office[j][k] == 5) {
                        observe5(j, k);
                    }

                }
                 */

            verify();

            }
        }

        System.out.println(result);
    }

    public static void observeRight(int x) {
        for (int i = x; i < m; i++) {
            if (office[x][i] == 6) {
                break;
            }
            if (office[x][i] == 0) {
                office[x][i] = 7;
            }
        }
    }

    public static void observeLeft(int x) {
        for (int i = x; i > -1; i--) {
            if (office[x][i] == 6) {
                break;
            }
            if (office[x][i] == 0) {
                office[x][i] = 7;
            }
        }
    }

    public static void observeUp(int y) {
        for (int i = y; i > -1; i--) {
            if (office[i][y] == 6) {
                break;
            }
            if (office[i][y] == 0) {
                office[i][y] = 7;
            }
        }
    }

    public static void observeDown(int y) {
        for (int i = y; i < n; i++) {
            if (office[i][y] == 6) {
                break;
            }
            if (office[i][y] == 0) {
                office[i][y] = 7;
            }
        }
    }

    public static void observe1(int x, int y, int control) {
        if (control == 0) {
            observeRight(x);
        } else if (control == 1) {
            observeDown(y);
        } else if (control == 2) {
            observeLeft(x);
        } else if (control == 3) {
            observeUp(y);
        }
    }

    public static void observe2(int x, int y, int control) {
        if (control == 0) {
            observeRight(x);
            observeLeft(x);
        } else if (control == 1) {
            observeDown(y);
            observeUp(y);
        }
    }

    public static void observe3(int x, int y, int control) {
        if (control == 0) {
            observeUp(y);
            observeRight(x);
        } else if (control == 1) {
            observeRight(x);
            observeDown(y);
        } else if (control == 2) {
            observeDown(y);
            observeLeft(x);
        } else if (control == 3) {
            observeLeft(x);
            observeUp(y);
        }
    }

    public static void observe4(int x, int y, int control) {
        if (control == 0) {
            observeLeft(x);
            observeUp(y);
            observeRight(x);
        } else if (control == 1) {
            observeUp(y);
            observeRight(x);
            observeDown(y);
        } else if (control == 2) {
            observeRight(x);
            observeDown(y);
            observeLeft(x);
        } else if (control == 3) {
            observeDown(y);
            observeLeft(x);
            observeUp(y);
        }
    }

    public static void observe5(int x, int y) {
        observeRight(x);
        observeDown(y);
        observeLeft(x);
        observeUp(y);
    }

    public static void verify() {
        int temp = 0;
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                if (office[j][k] == 0) {
                    temp++;
                }
            }
        }

        result = Math.min(result, temp);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                office[i][j] = origin[i][j];
            }
        }
    }
}
