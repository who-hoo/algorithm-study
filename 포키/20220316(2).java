import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ11501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        for (int i = 0; i < cases; i++) {
            int stockCount = sc.nextInt();
            long result = 0;
            int point = 0;
            List<Integer> stocks = new ArrayList<>();
            for (int j = 0; j < stockCount; j++) {
                stocks.add(sc.nextInt());
            }
            for (int k = stocks.size() - 1; k >= 0; k--) {
                if (point < stocks.get(k)) {
                    point = stocks.get(k);
                }else{
                    result += point - stocks.get(k);
                }
            }
            System.out.println(result);
        }
    }
}


// 3,5,9
// 하루에 하나씩밖에 못산다.
// 하루에 팔 수 있는건 제한이 없다. -> 젤 비쌀때 전부 파는게 최고.
// 최고가 이전까지는 무조건 산다.

//1. 최고값을 구한다.
//2. 최고값 * 주식 개수 - 매입가



//1,1,3,1,2
// 이런 경우 2개 사고 팔고
// 한개 살고 팔고
//맨 뒤의 값을 시작점으로 잡고, 자기보다 큰 값이 나올때까지 result에 매도가 - 매입가를 더해간다.