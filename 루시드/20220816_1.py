str1 = input()
str2 = input()

lcs = [[0] * (len(str1) + 1) for _ in range(len(str2) + 1)]

for i in range(1, len(str2) + 1):
    for j in range(1, len(str1) + 1):
        if str2[i - 1] == str1[j - 1]:
            lcs[i][j] = lcs[i - 1][j - 1] + 1
        else:
            lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1])

print(max(lcs[len(str2)]))
