def timeToMin(timetable):
    results = []
    for time in timetable:
        h, m = map(int, time.split(":"))
        results.append(h * 60 + m)

    return results


def resolveToTime(minute):
    h, m = str(minute // 60), str(minute % 60)
    h = h if len(h) == 2 else '0' + h
    m = m if len(m) == 2 else '0' + m
    return "{}:{}".format(h, m)


def solution(n, t, m, timetable):
    minTimeTable = sorted(timeToMin(timetable))

    curBusTime = 540
    lastBusTime = curBusTime + (n - 1) * t
    idx, count = 0, 0
    while True:
        if minTimeTable[idx] > lastBusTime:
            return resolveToTime(lastBusTime)

        if curBusTime == lastBusTime:
            # 남은 사람 다 탈 수 있다면 가능
            if len(minTimeTable) - idx < m:
                return resolveToTime(lastBusTime)
            # 못타는 경우 새치기
            else:
                lastIdx = len(minTimeTable) - 1
                while lastIdx - idx + 1 != m:
                    lastIdx -= 1

                return resolveToTime(minTimeTable[lastIdx] - 1)

        # 사람 태우기
        if minTimeTable[idx] <= curBusTime and count < m:
            idx += 1
            count += 1

        # 인원 다 채워지면 curBusTime을 올리기
        if count == m or minTimeTable[idx] > curBusTime:
            count = 0
            curBusTime += t
