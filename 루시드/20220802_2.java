def solution(line):
    result = []
    uy, dy, ux, dx = 10e10, -10e10, 10e10, -10e10
    for i in range(0, len(line) - 1):
        A, B, E = line[i]
        for j in range(i + 1, len(line)):
            C, D, F = line[j]
            denominator = (A * D) - (B * C)
            if denominator == 0:
                continue

            x = ((B * F) - (E * D)) // denominator
            y = ((E * C) - (A * F)) // denominator

            if ((B * F) - (E * D)) % denominator == 0 and ((E * C) - (A * F)) % denominator == 0:
                result.append([x, y])
                ux, uy, dx, dy = min(x, ux), min(y, uy), max(x, dx), max(y, dy)

    answer = [['.'] * (dx - ux + 1) for _ in range(dy - uy + 1)]

    for x, y in result:
        answer[y - uy][x - ux] = '*'

    for i in range(len(answer)):
        answer[i] = ''.join(answer[i])

    answer.reverse()
    return answer
