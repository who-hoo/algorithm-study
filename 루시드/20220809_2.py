n, s = map(int, input().split())
nums = list(map(int, input().split()))

start = 0
result, cur_sum = n + 1, 0

for end in range(n):
    cur_sum += nums[end]
    if cur_sum >= s:
        result = min(result, end - start + 1)

    while cur_sum >= s:
        cur_sum -= nums[start]
        start += 1
        if cur_sum >= s:
            result = min(result, end - start + 1)

print(0) if result == n + 1 else print(result)
