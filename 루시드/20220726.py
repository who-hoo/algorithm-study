import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)

n = int(input())
m = int(input())

# 도시 n개의 거리 초기화
distance = [INF] * (n + 1)

# 거리 정보 넣기
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    n1, n2, dist = map(int, input().split())
    graph[n1].append([n2, dist])

start_city, end_city = map(int, input().split())


def dijkstra(start):
    queue = []
    # 우선순위 큐에 시작점 넣기, (거리, 도시숫자)
    heapq.heappush(queue, (0, start))
    distance[start] = 0

    while queue:
        dist, cur_node = heapq.heappop(queue)

        # 기존 처리 되었다면 continue
        if distance[cur_node] < dist:
            continue

        for adjacency in graph[cur_node]:
            temp_dist = dist + adjacency[1]  # 지금까지 거리(dist) + 새로운 노드까지의 거리

            if temp_dist < distance[adjacency[0]]:  # temp_dist가 지금까지 distance(start 노드로부터)보다 작다면 갱신한다.
                distance[adjacency[0]] = temp_dist
                heapq.heappush(queue, (temp_dist, adjacency[0]))


dijkstra(start_city)
print(distance[end_city])
