import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
      
        String[] nums = br.readLine().split(" ");      
        int[] students = new int[N];

        for (int i = 0; i < nums.length; i++) {
            students[i] = Integer.parseInt(nums[i]);
        }

    }
}
