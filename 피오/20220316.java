package beakjoon;

import java.util.Scanner;

public class Main_11501 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); //테스트케이스 수

        for (int i = 0; i < T; i++) {
            int day = sc.nextInt(); //날의 수 ~ 1,000,000
            long[] stocks = new long[day];
            for (int j = 0; j < day; j++) {
                stocks[j] = sc.nextLong();
            }

            int stockCount = 0;
            long profit = 0L;
            long purchaseAmount = 0L;
            for (int j = 0; j < stocks.length; j++) {
                if (j == stocks.length - 1) {
                    profit += stocks[j] * stockCount - purchaseAmount;
                    break;
                }
                //다음날 주식이 비싸면 그냥 사면 되고
                if (stocks[j] < stocks[j + 1]) {
                    purchaseAmount += stocks[j];
                    stockCount++;
                    continue;
                }

                //다음날 주식 가격이 더 싸거나 같을 때는
                if (stocks[j] >= stocks[j + 1]) {
                    //이후 날짜에 더 비싼 주식이 있으면 사고,
                    if (hasMuchExpensiveAfter(j, stocks[j], stocks)) {
                        purchaseAmount += stocks[j];
                        stockCount++;
                    } else {
                        //이후에도 가격이 같거나 가격이 더 싸지면 지금 판다.
                        profit += stocks[j] * stockCount - purchaseAmount;
                        purchaseAmount = 0;
                        stockCount = 0;
                    }

                }

            }
            System.out.println(profit);
        }
    }

    private static boolean hasMuchExpensiveAfter(int currDay, long currPrice, long[] stocks) {
        for (int k = currDay + 1; k < stocks.length; k++) {
            if (currPrice < stocks[k]) {
                return true;
            }
        }
        return false;
    }


}
