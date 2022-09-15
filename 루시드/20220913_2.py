n, r, c = map(int, input().split())

size = 2 ** n
answer = 0
while size != 0:
    size //= 2
    if r < size and c < size:
        continue
    elif r < size and c >= size:
        answer += size ** 2 * 1
        c -= size
    elif r >= size and c < size:
        answer += size ** 2 * 2
        r -= size
    else:
        answer += size ** 2 * 3
        r -= size
        c -= size

print(answer)
