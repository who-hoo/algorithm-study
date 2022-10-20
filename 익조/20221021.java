
import java.util.HashSet;
import java.util.Set;

class Solution {

    public int solution(String dirs) {
        Set<String> set = new HashSet<>();

        int posX = 5, posY = 5;

        for (char dir : dirs.toCharArray()) {
            if (dir == 'U' && posX - 1 > -1) {
                set.add(getPosition(posX, posY, posX - 1, posY));
                set.add(getPosition(posX - 1, posY, posX, posY));
                posX--;
            } else if (dir == 'D' && posX + 1 < 11) {
                set.add(getPosition(posX, posY, posX + 1, posY));
                set.add(getPosition(posX + 1, posY, posX, posY));
                posX++;
            } else if (dir == 'R' && posY + 1 < 11) {
                set.add(getPosition(posX, posY, posX, posY + 1));
                set.add(getPosition(posX, posY + 1, posX, posY));
                posY++;
            } else if (dir == 'L' && posY - 1 > -1){
                set.add(getPosition(posX, posY, posX, posY - 1));
                set.add(getPosition(posX, posY - 1, posX, posY));
                posY--;
            }
        }

        return set.size() / 2;
    }

    private String getPosition(int startPosX, int startPosY, int endPosX, int endPosY) {
        StringBuilder sb = new StringBuilder();
        sb.append(startPosX).append(startPosY).append(endPosX).append(endPosY);
        return sb.toString();
    }
}
