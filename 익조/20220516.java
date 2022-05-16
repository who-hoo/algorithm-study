import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    List<Integer> list = new ArrayList<>();
    boolean[][][] visited;
    char[][] g;
    int row, col;
    int[] startPoints = new int[3];

    public int[] solution(String[] grid) {
        row = grid.length;
        col = grid[0].length();
        g = new char[row][col];
        visited = new boolean[row][col][4];

        for (int i = 0; i < row; i++) {
            g[i] = grid[i].toCharArray();
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < 4; k++) { // direction → 0 : up, 1 : right, 2 : down, 3 : left
                    if (!visited[i][j][k]) {
                        startPoints[0] = i;
                        startPoints[1] = j;
                        startPoints[2] = k;
                        move(i, j, k);
                    }
                }
            }
        }

        Collections.sort(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void move(int row, int col, int direction) {
        int count = 0;

        while (true) {
            visited[row][col][direction] = true;

            if (direction == 0) {
                if (g[row][col] == 'S') {
                    row--;
                } else if (g[row][col] == 'R') {
                    col++;
                    direction = 1;
                } else if (g[row][col] == 'L') {
                    col--;
                    direction = 3;
                }
            } else if (direction == 1) {
                if (g[row][col] == 'S') {
                    col++;
                } else if (g[row][col] == 'R') {
                    row++;
                    direction = 2;
                } else if (g[row][col] == 'L') {
                    row--;
                    direction = 0;
                }
            } else if (direction == 2) {
                if (g[row][col] == 'S') {
                    row++;
                } else if (g[row][col] == 'R') {
                    col--;
                    direction = 3;
                } else if (g[row][col] == 'L') {
                    col++;
                    direction = 1;
                }
            } else if (direction == 3) {
                if (g[row][col] == 'S') {
                    col--;
                } else if (g[row][col] == 'R') {
                    row--;
                    direction = 0;
                } else if (g[row][col] == 'L') {
                    row++;
                    direction = 2;
                }
            }

            if (row < 0) {
                row = this.row - 1;
            } else if (row > this.row - 1) {
                row = 0;
            } else if (col < 0) {
                col = this.col - 1;
            } else if (col > this.col - 1) {
                col = 0;
            }

            count++;

            if (startPoints[0] == row && startPoints[1] == col && startPoints[2] == direction) {
                list.add(count);
                break;
            }
        }
    }
}
