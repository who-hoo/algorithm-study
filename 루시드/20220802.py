N = int(input())

small_sum = list(map(int, input().split()))
large_sum = small_sum.copy()

for i in range(1, N):
    n1, n2, n3 = map(int, input().split())

    mintmp0 = min(small_sum[0], small_sum[1]) + n1
    mintmp1 = min(small_sum[0], small_sum[1], small_sum[2]) + n2
    mintmp2 = min(small_sum[1], small_sum[2]) + n3

    maxtmp0 = max(large_sum[0], large_sum[1]) + n1
    maxtmp1 = max(large_sum[0], large_sum[1], large_sum[2]) + n2
    maxtmp2 = max(large_sum[1], large_sum[2]) + n3

    small_sum[0], small_sum[1], small_sum[2] = mintmp0, mintmp1, mintmp2
    large_sum[0], large_sum[1], large_sum[2] = maxtmp0, maxtmp1, maxtmp2

print(max(large_sum), min(small_sum))
