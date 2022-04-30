class Solution {
    public int solution(String s) {
        int lengthOfString = s.length();
        if (lengthOfString == 1) {
            return 1;
        }

        StringBuilder zipString = new StringBuilder();
        int result = 1000, multiple = 1, unit = 1, nextIndex = unit;
        String currentString, nextString;

        while (nextIndex + unit <= lengthOfString) {
            currentString = s.substring(0, unit);
            nextString = s.substring(nextIndex, nextIndex + unit);

            while (nextIndex + unit <= lengthOfString - 1
                && nextIndex + unit * 2 <= lengthOfString) {
                if (currentString.equals(nextString)) {
                    multiple++;
                } else {
                    if (multiple == 1) {
                        zipString.append(currentString);
                    } else {
                        zipString.append(multiple).append(currentString);
                        multiple = 1;
                    }
                }

                currentString = s.substring(nextIndex, nextIndex + unit);
                nextIndex += unit;
                nextString = s.substring(nextIndex, nextIndex + unit);
            }

            if (currentString.equals(nextString)) {
                multiple++;
                nextIndex += unit;
            }

            if (multiple == 1) {
                zipString.append(currentString);
            } else {
                zipString.append(multiple).append(currentString);
            }

            zipString.append(s.substring(nextIndex));

            result = Math.min(result, zipString.length());
            multiple = 1;
            unit++;
            nextIndex = unit;
            zipString.setLength(0);
        }

        return result;
    }
}
