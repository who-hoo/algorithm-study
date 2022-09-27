import java.util.Arrays;

public class 정수삼각형 {

    public int solution(int[][] triangle) {
        if (triangle.length == 1) {
            return triangle[0][0];
        }

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                //0일경우 무조건 0
                if (j == 0) {
                    triangle[i][0] += triangle[i - 1][0];
                } else if (i == j) {
                    //i랑 j랑 같을 경우 무조건 -1
                    triangle[i][j] += triangle[i - 1][j - 1];
                }else{
                    //나머지 경우에는 j-1, j 랑 비교해서 큰 값으로
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
            }
        }

        return Arrays.stream(triangle[triangle.length - 1])
            .max().getAsInt();
    }

}