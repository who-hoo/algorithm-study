import java.util.*;

class Solution {
	public String[] solution(int[][] line) {

		List<long[]> list = new ArrayList<>();

		long maxX = Long.MIN_VALUE;
		long minX = Long.MAX_VALUE;
		long maxY = Long.MIN_VALUE;
		long minY = Long.MAX_VALUE;

		for(int i = 0; i < line.length; i++) {
			long a = line[i][0];
			long b = line[i][1];
			long e = line[i][2];

			for(int j = i + 1; j < line.length; j++) {
				long c = line[j][0];
				long d = line[j][1];
				long f = line[j][2];

				if (a * d - b * c == 0) {
					continue;
				}

				double x = ((b * f) - (e * d)) / (double) ((a * d) - (b * c));
				double y = ((e * c) - (a * f)) / (double) ((a * d) - (b * c));

				if (Math.floor(x) == Math.ceil(x) && Math.floor(y) == Math.ceil(y)) {
					list.add(new long[]{(long) x, (long) y});
					maxX = Math.max((long) x, maxX);
					minX = Math.min((long) x, minX);
					maxY = Math.max((long) y, maxY);
					minY = Math.min((long) y, minY);
				}
			}
		}

		int h = (int) (maxY - minY + 1);
		int w = (int) (maxX - minX + 1);

		char[][] marker = new char[h][w];

		for (int i = 0; i < h; i++) {
			Arrays.fill(marker[i], '.');
		}

		for (long[] a : list) {
			marker[(int) maxY - (int) a[1]][(int) a[0] - (int) minX] = '*';
		}

		String[] answer = new String[h];
		for (int i = 0; i < h; i++) {
			answer[i] = String.valueOf(marker[i]);
		}

		return answer;
	}
}
