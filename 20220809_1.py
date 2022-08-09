from collections import deque
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


def bfs(mp, chk, x, y):
    q = deque([(x, y)])
    chk[x][y] = True

    depth = 0
    while q:
        repeat = len(q)
        depth += 1
        for _ in range(repeat):
            tx, ty = q.popleft()
            if tx == (len(chk) - 1) and ty == (len(chk[0]) - 1):
                return depth

            for i in range(4):
                nx = tx + dx[i]
                ny = ty + dy[i]
                if 0 <= nx < len(chk) and 0 <= ny < len(chk[0]) and not chk[nx][ny] and mp[nx][ny] == 1:
                    chk[nx][ny] = True
                    q.append((nx, ny))
    return -1


def solution(maps):
    chk = [[False] * len(maps[0]) for _ in range(len(maps))]
    return bfs(maps, chk, 0, 0)
