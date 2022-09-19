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
    minute_time_table = sorted(timeToMin(timetable))

    curBusTime = 540
    lastBusTime = curBusTime + (n - 1) * t
    idx, count = 0, 0

    # 막차 전까지는 가능한만큼 태워 보내기
    while minute_time_table[idx] <= curBusTime != lastBusTime:
        idx += 1
        count += 1
        if count == m or minute_time_table[idx] > curBusTime:
            count = 0
            curBusTime += t

    # 현재 탈 사람이 lastBus보다 늦게 오는 사람이라면 어차피 못탐
    if minute_time_table[idx] > lastBusTime or curBusTime != lastBusTime:
        return resolveToTime(lastBusTime)

    # 남은 사람 다 탈 수 있다면 가능
    if len(minute_time_table) - idx < m:
        return resolveToTime(lastBusTime)
    # 못타는 경우 새치기
    else:
        lastIdx = len(minute_time_table) - 1
        while lastIdx - idx + 1 != m:
            lastIdx -= 1
        return resolveToTime(minute_time_table[lastIdx] - 1)
