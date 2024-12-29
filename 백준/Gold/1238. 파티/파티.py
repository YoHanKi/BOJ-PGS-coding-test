from queue import PriorityQueue

INF = int(1e12)

def dijkstra(adj_list, start_node):
	global N

	dist = [INF] * (N + 1)

	pq = PriorityQueue()
	dist[start_node] = 0
	pq.put([0, start_node])

	while not pq.empty():
		cur_dist, cur_node = pq.get()
		for adj_node, adj_dist in adj_list[cur_node]:
			temp_dist = cur_dist + adj_dist
			if temp_dist < dist[adj_node]:
				dist[adj_node] = temp_dist
				pq.put([temp_dist, adj_node])

	return dist

# input
N, M, X = map(int, input().split())

adj_list1 = [[] for _ in range(N + 1)]
adj_list2 = [[] for _ in range(N + 1)]

for _ in range(M):
	a, b, t = map(int, input().split())
	adj_list1[a].append([b, t])
	adj_list2[b].append([a, t])

# solve (dijkstra)
dist1 = dijkstra(adj_list1, X)
dist2 = dijkstra(adj_list2, X)

ans = -1
for i in range(1, N + 1):
	ans = max(ans, dist1[i] + dist2[i])

print(ans)