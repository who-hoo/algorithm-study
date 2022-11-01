public class 스티커모으기2 {

    public int solution(int sticker[]) {

        boolean isEven = sticker.length % 2 == 0;
        int result1 = 0, result2 = 0;
        if (isEven) {

            for (int i = 0; i < sticker.length-1; i += 2) {
                result1 += sticker[i];
            }
            for (int i = 1; i < sticker.length; i += 2) {
                result2 += sticker[i];
            }
        }else{
            for (int i = 0; i < sticker.length; i += 2) {
                result1 += sticker[i];
            }
            for (int i = 1; i < sticker.length - 1; i += 2) {
                result2 += sticker[i];
            }

        }
        return Math.max(result1, result2);
    }

}