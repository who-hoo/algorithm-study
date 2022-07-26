count, east, west, south, north = map(int, input().split())

perc = [east / 100, west / 100, south / 100, north / 100]

direction = [
    [0, 1], [0, -1], [1, 0], [-1, 0]
]

chk_brd = [[0] * 29 for _ in range(29)]
chk_brd[14][14] = 1

result = 0


def DFS(brd, x, y, reply, tmp_per):
    global result
    if reply == count:
        # 지금까지 확률을 결과에 더하기
        result += tmp_per
        return

    for i in range(4):
        nx = x + direction[i][0]
        ny = y + direction[i][1]

        if 0 <= nx <= 28 and 0 <= ny <= 28 and brd[nx][ny] == 0:
            brd[nx][ny] = 1
            DFS(brd, nx, ny, reply + 1, tmp_per * (perc[i]))
            brd[nx][ny] = 0


DFS(chk_brd, 14, 14, 0, 1)
print('{:.10f}'.format(result))
