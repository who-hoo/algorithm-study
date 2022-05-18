public class Solution {

	public static void main(String[] args) {
		String[] strings = {"SL", "LR"};
		Solution s = new Solution();
		int[] result = s.solution(strings);
		System.out.println(result);
	}

	private int[] solution(String[] grid) {
		int[] result = new int[0];
		int rowCount = grid.length;
		int colCount = grid[0].length();
		Boolean[][][] visited = new Boolean[rowCount][colCount][4];
		return result;
	}

}
