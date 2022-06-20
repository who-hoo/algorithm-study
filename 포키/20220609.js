function solution(n, words) {
  let list = [words[0]];

  for (let i = 1; i < words.length; i++) {
    let lastWord = list[i - 1][list[i - 1].length - 1];
    let user = i >= n ? (i % n) + 1 : i + 1;
    if (words[i].length === 1 || lastWord !== words[i][0] || list.includes(words[i])) {
      return [user, Math.floor(i / n) + 1];
    }

    list.push(words[i]);
  }

  return [0, 0];
}
