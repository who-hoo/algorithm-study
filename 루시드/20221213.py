def postOrder(start, end):
    mid = (start + end) // 2

    if mid - start > 1:
        # 재귀 수행
        postOrder(start, mid - 1)
        postOrder(mid + 1, end)
        answer.append(arrs[mid])
    else:
        # 출력 수행
        answer.extend([arrs[start], arrs[end], arrs[mid]])
        return


n = int(input())
arrs = list(map(int, input().split()))
answer = []
changed_value = int(input())

for idx, arr in enumerate(arrs):
    if arr == -1:
        arrs[idx] = changed_value
        break

arrs.sort()
postOrder(0, n - 1)
print(*answer)
