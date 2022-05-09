package beakjoon;

import java.util.*;
import java.io.*;

public class Main_1436 { //영화감독 숌

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int curr = 666;
        int count = 0;
        int N = sc.nextInt();
        
        while (count <= N) {
            if (String.valueOf(curr).contains("666")) {
                count++;
                if (N == count) {
                    System.out.println(curr);
                    break;
                }
            }
            curr++;
        }

    }

}
