from collections import deque

n = int(input())
result = ""


def bfs(q, t, chk):
    global result
    while q:
        now, path = q.popleft()
        if now == t:
            result += (path + '\n')
            return

        # D
        temp = (now << 1) % 10000
        if not chk[temp]:
            chk[temp] = True
            q.append((temp, path + 'D'))

        # S
        temp = now - 1 if now != 0 else 9999
        if not chk[temp]:
            chk[temp] = True
            q.append((temp, path + 'S'))

        # L
        temp = (now % 1000) * 10 + now // 1000
        if not chk[temp]:
            chk[temp] = True
            q.append((temp, path + 'L'))

        # R
        temp = (now % 10) * 1000 + now // 10
        if not chk[temp]:
            chk[temp] = True
            q.append((temp, path + 'R'))


for _ in range(n):
    init, target = map(int, input().split())
    queue = deque([(init, '')])
    checker = [False] * 10000
    checker[init] = True
    bfs(queue, target, checker)

print(result)
