from itertools import combinations

n, m = map(int, input().split())

housePos = []
chickenPos = []

value = 0
while value != n:
    tmp = list(map(int, input().split()))
    for i in range(n):
        if tmp[i] == 1:
            housePos.append((value, i))
        elif tmp[i] == 2:
            chickenPos.append((value, i))
    value += 1

comb = combinations(chickenPos, m)

result = 1000000
for chickin_comb in comb:
    tmpResult = 0

    # 각 집에 대해서 가장 가까운 치킨집 거리 구하기
    for hx, hy in housePos:
        tmpDist = 200
        for cx, cy in chickin_comb:
            tmpPos = abs(hx - cx) + abs(hy - cy)
            if tmpPos < tmpDist:
                tmpDist = tmpPos

        tmpResult += tmpDist

    result = min(result, tmpResult)

print(result)
