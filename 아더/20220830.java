package 아더;

import java.util.Arrays;

public class PRO_68936_쿼드압축후개수세기 {

    public static void main(String[] args) {
        PRO_68936_쿼드압축후개수세기 pro = new PRO_68936_쿼드압축후개수세기();

        int[][] arr1 = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        int[][] arr2 = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};

        System.out.println(Arrays.toString(pro.solution(arr1)));
        System.out.println(Arrays.toString(pro.solution(arr2)));
    }

    public int[] solution(int[][] arr) {
        int[] answer = {};
        
        return answer;
    }
}
