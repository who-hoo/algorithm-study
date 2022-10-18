row_length, column_length = 0, 0
results = []


def comb(S, size, relation, arr):
    if len(arr) == size:
        # arr에 해당하는 인덱스를 가져와서 string을 만들고 tmpSet을 만들기
        tmpSet = set()
        for row in relation:
            tmp = ""
            for i in arr:
                tmp += row[i]
            tmpSet.add(tmp)

        if len(tmpSet) == row_length:
            # 최소성 검사 수행
            arr = set(arr)
            for result in results:
                if not set(result) - arr:
                    break
            else:  # break 안당했으면 실행
                results.append(arr)
        return

    for i in range(S, column_length):
        comb(i + 1, size, relation, arr + [i])


def solution(relation):
    global row_length, column_length
    row_length = len(relation)
    column_length = len(relation[0])

    # 조합
    for size in range(1, column_length + 1):
        comb(0, size, relation, [])

    return len(results)
