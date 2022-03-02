// 리팩토링 전

import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] rgbHouse = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                rgbHouse[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n - 1; i++) {
            int[] minValueAndIndex = getMinValueAndIndex(rgbHouse[i]);
            for (int j = 0; j < 3; j++) {
                if (minValueAndIndex[1] != j) {
                    rgbHouse[i + 1][j] += minValueAndIndex[0];
                }
                else {
                    Arrays.sort(rgbHouse[i]);
                    rgbHouse[i + 1][j] += rgbHouse[i][1];
                }
            }
        }

        System.out.println(getMinValueAndIndex(rgbHouse[n-1])[0]);
    }

    public static int[] getMinValueAndIndex(int[] arr) {
        int minValue = arr[0], index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (minValue > arr[i]) {
                minValue = arr[i];
                index = i;
            }
        }

        return new int[]{minValue, index};
    }
}

// 리팩토링 후

import java.util.Scanner;

class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] rgbHouse = new int[n][3];

        for (int j = 0; j < 3; j++) {
            rgbHouse[0][j] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            int pR = rgbHouse[i - 1][0], pG = rgbHouse[i - 1][1], pB = rgbHouse[i - 1][2];

            for (int j = 0; j < 3; j++) {
                rgbHouse[i][j] = sc.nextInt();
            }

            rgbHouse[i][0] += Math.min(pG, pB);
            rgbHouse[i][1] += Math.min(pR, pB);
            rgbHouse[i][2] += Math.min(pR, pG);
        }

        System.out.println(getMinValueAndIndex(rgbHouse[n - 1]));
    }

    public static int getMinValueAndIndex(int[] arr) {
        int minValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (minValue > arr[i]) {
                minValue = arr[i];
            }
        }

        return minValue;
    }
}
