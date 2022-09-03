result = [0, 0]


def quadCheck(sx, sy, size, arr):
    firstValue = arr[sx][sy]
    for i in range(sx, sx + size):
        for j in range(sy, sy + size):
            if arr[i][j] != firstValue:
                return False
    return True


def quad(sx, sy, size, arr):
    if quadCheck(sx, sy, size, arr):
        result[arr[sx][sy]] += 1
    else:
        nSize = size // 2
        quad(sx, sy, nSize, arr)
        quad(sx + nSize, sy, nSize, arr)
        quad(sx, sy + nSize, nSize, arr)
        quad(sx + nSize, sy + nSize, nSize, arr)


def solution(arr):
    quad(0, 0, len(arr), arr)
    return result

