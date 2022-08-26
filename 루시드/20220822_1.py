from collections import deque


def solution(cacheSize, cities):
    answer = 0
    cache = deque([])

    if cacheSize == 0:
        return len(cities) * 5

    for city in cities:
        if city.upper() in cache:
            answer += 1
            cache.remove(city.upper())
        else:
            answer += 5
            if len(cache) == cacheSize:
                cache.pop()
        cache.appendleft(city.upper())

    return answer
