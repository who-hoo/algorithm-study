import sys

def solution(N, road, K):
    INF = sys.maxsize
    dists = [INF] * (N + 1)
    dists[1] = 0
    q = [1]

    while q:
        cur = q.pop(0)
        for n1, n2, d in road:
            if n1 == cur or n2 == cur:
                target = n2 if n1 == cur else n1
                if dists[target] > dists[cur] + d:
                    dists[target] = dists[cur] + d
                    q.append(target)

    return sum(1 for i in dists if i <= K)
