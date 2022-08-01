import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
		HashSet<String> duplicatesCheck = new HashSet<>();
		for (int i = 0; i < words.length; i++) {
			if (isInvalidWord(i, words)
				|| isDuplicatedWord(duplicatesCheck, words[i])
				|| isInValidLength(words[i])) {
				int person = ((i + 1) % n == 0) ? n : (i + 1) % n;
				int sequence = ((i + 1) % n == 0) ? (i + 1) / n : (i + 1) / n + 1;
				return new int[]{person, sequence};
			}
		}
		return new int[]{0, 0};
	}

	// 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
	boolean isInvalidWord(int idx, String[] words) {
		if (idx < 1) {
			return false;
		}
		String prevWord = words[idx - 1];
		char lastCharOfPrevWord = prevWord.charAt(prevWord.length() - 1);
		String curWord = words[idx];
		char firstCharOfCurWord = curWord.charAt(0);

		return lastCharOfPrevWord != firstCharOfCurWord;
	}

	// 이전에 등장했던 단어는 사용할 수 없습니다.
	boolean isDuplicatedWord(HashSet<String> duplicatesCheck, String word) {
		return !duplicatesCheck.add(word);
	}

	// 한 글자인 단어는 인정되지 않습니다.
	boolean isInValidLength(String word) {
		return word.length() < 2;
	}
}
