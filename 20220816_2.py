target = int(input())
mallfunc = int(input())
mallList = [False] * 10
tmp = []
if mallfunc > 0:
    tmp = list(map(int, input().split()))

for j in tmp:
    mallList[j] = True


def solve(target, mallfunc, mallList):
    result = abs(target - 100)
    for i in range(500001):
        if malfunc_checker(i, mallList):
            now = abs(target - i)
            result = min(result, now + len(str(i)))

    return result


def malfunc_checker(cp, mallList):
    if cp == 0:
        return not mallList[0]

    while cp > 0:
        if mallList[cp % 10]:
            return False
        cp //= 10
    return True


print(solve(target, mallfunc, mallList))
