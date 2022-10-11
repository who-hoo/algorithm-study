import sys
input = sys.stdin.readline

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
answer = [0] * 3


def is_not_all_same(i, j, size):
    sv = board[i][j]
    for x in range(i, i + size):
        for y in range(j, j + size):
            if board[x][y] != sv:
                return True
    return False


def solution(i, j, size):
    if is_not_all_same(i, j, size):
        reSize = size // 3
        for x in range(i, i + size, reSize):
            for y in range(j, j + size, reSize):
                solution(x, y, reSize)
    else:
        answer[board[i][j] + 1] += 1


solution(0, 0, n)
print('\n'.join(map(str, answer)))
