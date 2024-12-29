import sys
input = lambda: sys.stdin.readline().rstrip()

from queue import PriorityQueue

N, E = map(int, input().split())

graph = [[] for _ in range(N + 1)]

INF = int(1e9)

for _ in range(E):
    a, b, c = map(int, input().split())
    graph[a].append([b, c])
    graph[b].append([a, c])

v1, v2 = map(int, input().split())

def dijkstra(start):
    dist = [INF] * (N + 1)
    pq = PriorityQueue()
    pq.put([0, start])
    dist[start] = 0

    while not pq.empty():
        cur_dist, cur_node = pq.get()

        for nxt_node, nxt_dist in graph[cur_node]:
            if dist[nxt_node] > cur_dist + nxt_dist:
                dist[nxt_node] = cur_dist + nxt_dist
                pq.put([cur_dist + nxt_dist, nxt_node])

    return dist

dist_1 = dijkstra(1)
dist_v1 = dijkstra(v1)
dist_v2 = dijkstra(v2)

result = min(dist_1[v1] + dist_v1[v2] + dist_v2[N], dist_1[v2] + dist_v2[v1] + dist_v1[N])

print(result if result < INF else -1)