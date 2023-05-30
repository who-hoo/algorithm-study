# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
n = int(input())
board = list(map(int, input().split()))

a = [False, False] + [True] * (n - 1)

answer = 0

for i in range(2, n + 1):
    if a[i]:
        for j in range(2 * i, n + 1, i):
            a[j] = False

for idx, result in enumerate(a):
    if idx == 0:
        continue
    if result:
        answer += board[idx - 1]

print(answer)
