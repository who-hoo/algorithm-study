class Solution {
	public String solution(int n, int t, int m, int p) {
		StringBuilder sequence = new StringBuilder();
		StringBuilder answer = new StringBuilder();

		for(int i = 0; sequence.length() <= t * m; i++){
			sequence.append(Integer.toString(i, n));
		}

		for(int i = p - 1; i < t * m; i += m){
			answer.append(sequence.charAt(i));
		}

		return answer.toString().toUpperCase();
	}
}
