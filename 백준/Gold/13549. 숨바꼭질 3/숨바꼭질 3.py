from queue import PriorityQueue

N, X = map(int, input().split())

INF = int(1e9)
MAX = int(1e5)

dist = [INF] * (MAX + 1)

pq = PriorityQueue()
dist[N] = 0
pq.put([0, N])

while not pq.empty():
    cur_dist, cur_node = pq.get()

    search_nodes = [
        (cur_dist, cur_node * 2),
        (cur_dist + 1, cur_node + 1),
        (cur_dist + 1, cur_node - 1)
    ]

    for search_dist, search_node in search_nodes:
        if 0 <= search_node <= MAX:
            if search_dist < dist[search_node]:
                dist[search_node] = search_dist
                pq.put([search_dist, search_node])

print(dist[X])