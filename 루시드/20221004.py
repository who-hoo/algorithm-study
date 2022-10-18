import sys
from collections import defaultdict

def solution(n, d, k, c, arrs):
    num_dict = defaultdict(int)
    for i in range(k):
        num_dict[arrs[i]] += 1

    left, right = 0, k - 1
    mxCount = 0
    while left < n:
        # 계산
        tmp = len(num_dict) + 1 if c not in num_dict else len(num_dict)
        mxCount = max(mxCount, tmp)

        # 왼쪽 remove & left + 1
        num_dict[arrs[left]] -= 1
        if num_dict[arrs[left]] == 0:
            del num_dict[arrs[left]]
        left += 1

        # 오른쪽 right + 1 & add
        right += 1
        if right == n:
            right = 0
        num_dict[arrs[right]] += 1

    return mxCount


if __name__ == '__main__':
    n, d, k, c = map(int, sys.stdin.readline().split())
    arrs = []
    for _ in range(n):
        arrs.append(int(sys.stdin.readline()))
    print(solution(n, d, k, c, arrs))
