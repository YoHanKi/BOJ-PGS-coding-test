from collections import deque

N, K = map(int, input().split())

max_limit = 10**5
visited = [False] * (max_limit + 1)

def bfs(start, target):
    dist = [-1] * (max_limit + 1)
    parent = [-1] * (max_limit + 1)
    queue = deque([start])
    dist[start] = 0

    while queue:
        v = queue.popleft()
        if v == target:
            break
        for nxt in (v - 1, v + 1, v * 2):
            if 0 <= nxt <= max_limit and dist[nxt] == -1:
                dist[nxt] = dist[v] + 1
                parent[nxt] = v
                queue.append(nxt)

    path = []
    cur = target
    while cur != -1:
        path.append(cur)
        if cur == start:
            break
        cur = parent[cur]
    path.reverse()
    return dist[target], path

result_dist, result_path = bfs(N, K)

print(result_dist)
print(' '.join(map(str, result_path)))