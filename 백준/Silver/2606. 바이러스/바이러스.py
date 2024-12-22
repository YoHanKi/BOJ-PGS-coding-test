def dfs(V):
    global visited, graph, cnt

    if visited[V]:
        return
    visited[V] = True
    cnt += 1

    for i in graph[V]:
        dfs(i)

N = int(input())
M = int(input())

graph = [[] for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

cnt = 0

visited = [False] * (N + 1)
dfs(1)

print(cnt - 1)