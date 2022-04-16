import java.util.LinkedList;
import java.util.Queue;

class Solution {

    class Target {

        int nodeA;
        int nodeB;

        public Target(int nodeA, int nodeB) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }

        public boolean containNode(int nodeA, int nodeB) {
            return this.nodeA == nodeA || this.nodeA == nodeB || this.nodeB == nodeA
                || this.nodeB == nodeB;
        }
    }

    double result = Double.POSITIVE_INFINITY;

    public int solution(int n, int[][] wires) {
        if (n == 2 || n == 3) {
            return n - 2;
        }

        int countOfWires = wires.length;

        for (int i = 0; i < countOfWires; i++) {
            int[][] cutWires = cutOneWire(countOfWires, wires, i);
            int differenceInNumberOfGrids = getDifferenceInNumberOfGrids(cutWires);
            result = result < differenceInNumberOfGrids ? result : differenceInNumberOfGrids;
        }

        return (int) result;
    }

    public int[][] cutOneWire(int countOfWires, int[][] wires, int i) {
        int[][] cutWires = new int[countOfWires - 1][2];
        int index = 0;

        for (int j = 0; j < countOfWires; j++) {
            if (j != i) {
                cutWires[index++] = wires[j];
            }
        }

        return cutWires;
    }

    public int getDifferenceInNumberOfGrids(int[][] cutWires) {

        Queue<Target> targets = new LinkedList<>();
        targets.add(new Target(cutWires[0][0], cutWires[0][1]));

        int countOfGridA = 1; // cutWires[0]에 대한 전력망 1개
        int countOfTotalGrids = cutWires.length;

        boolean[] visited = new boolean[countOfTotalGrids];
        visited[0] = true;

        while (!targets.isEmpty()) {
            Target target = targets.poll();

            for (int i = 1; i < countOfTotalGrids; i++) {
                if (!visited[i] && target.containNode(cutWires[i][0], cutWires[i][1])) {
                    visited[i] = true;
                    targets.add(new Target(cutWires[i][0], cutWires[i][1]));
                    countOfGridA++;
                }
            }
        }

        return Math.abs(countOfTotalGrids - countOfGridA * 2);
    }
}
