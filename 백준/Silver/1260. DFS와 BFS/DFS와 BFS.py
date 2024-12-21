from collections import deque

def dfs(V):
    global visited, graph

    if visited[V]:
        return
    visited[V] = True

    print(V, end=' ')

    for i in graph[V]:
        dfs(i)

def bfs(V):
    global visited, graph

    q = deque()
    q.append(V)
    visited[V] = True

    while q:
        cur = q.popleft()
        print(cur, end=' ')

        for i in graph[cur]:
            if not visited[i]:
                q.append(i)
                visited[i] = True

N, M, V = map(int, input().split())

graph = [[] for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(N + 1):
    graph[i].sort()

visited = [False] * (N + 1)
dfs(V)
print()

visited = [False] * (N + 1)
bfs(V)
print()
