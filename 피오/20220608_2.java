import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numString = br.readLine().split(" ");
        int numCount = Integer.parseInt(numString[0]);
        int plusCount = Integer.parseInt(numString[1]);
      
        int[] nums = new int[numCount];
        for (int i = 0; i < numCount; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
      

    }
}
