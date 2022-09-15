class Solution {

    public String solution(int n, int t, int m, int p) {
        int number = 0, myTurn = 0, index = p - 1;

        StringBuilder convertedNumber = new StringBuilder().append(0);
        StringBuilder result = new StringBuilder();

        while (myTurn != t) {
            if (convertedNumber.length() > index) {
                result.append(convertedNumber.charAt(index));
            } else {
                convertedNumber.append(convertBase(++number, n));
                continue;
            }

            index += m;
            myTurn++;
        }

        return result.toString();
    }

    private String convertBase(int number, int base) {
        if (number == 0) {
            return "0";
        }

        String bit = "0123456789ABCDEF";

        StringBuilder sb = new StringBuilder();

        while (number != 0) {
            sb.append(bit.charAt(number % base));
            number /= base;
        }

        return sb.reverse().toString();
    }
}
