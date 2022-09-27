import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

class Solution {

	static class File implements Comparable<File> {
		String head;
		String number;
		String tail;

		@Override
		public String toString() {
			return head + number + tail;
		}

		public File(String fileName) {
			init(fileName);
		}

		private void init(String fileName) {
			char[] ch = fileName.toCharArray();
			int maxLength = ch.length;
			int idx = 0;
			while (idx < maxLength) {
				if ('0' <= ch[idx] && ch[idx] <= '9') {
					break;
				}
				idx++;
			}
			head = fileName.substring(0, idx);
			int headIdx = idx;

			while (idx < maxLength) {
				if (!('0' <= ch[idx] && ch[idx] <= '9')) {
					break;
				}
				idx++;
			}
			number = fileName.substring(headIdx, idx);
			tail = fileName.substring(idx);
		}

		@Override
		public int compareTo(File o) {
			String originHead = this.head.toLowerCase(Locale.ROOT);
			String CompareHead = o.head.toLowerCase(Locale.ROOT);

			if (originHead.equals(CompareHead)) {
				return Integer.parseInt(this.number) - Integer.parseInt(o.number);
			}
			return originHead.compareTo(CompareHead);
		}
	}

	public String[] solution(String[] files) {

		List<File> fileList = new ArrayList<>(files.length);
		for (String file : files) {
			fileList.add(new File(file));
		}
		Collections.sort(fileList);

		String[] answer = new String[fileList.size()];
		for (int i = 0; i < answer.length; i++) {
			File file = fileList.get(i);
			answer[i] = file.toString();
		}
		return answer;
	}
}
