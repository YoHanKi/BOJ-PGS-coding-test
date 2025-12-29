import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
underground = [[] for _ in range(N)]
for _ in range(N):
    a, b = map(int, input().split())
    underground[a - 1].append(b - 1)
    underground[b - 1].append(a - 1)

deg = [len(underground[i]) for i in range(N)]
in_cycle = [True] * N
q = deque()

for i in range(N):
    if deg[i] == 1:
        q.append(i)
        in_cycle[i] = False

while q:
    u = q.popleft()
    for v in underground[u]:
        deg[v] -= 1
        if in_cycle[v] and deg[v] == 1:
            in_cycle[v] = False
            q.append(v)

# 사이클 노드들을 출발점으로 BFS하여 거리 계산
dist = [-1] * N
q = deque()
for i in range(N):
    if in_cycle[i]:
        dist[i] = 0
        q.append(i)

while q:
    u = q.popleft()
    for v in underground[u]:
        if dist[v] == -1:
            dist[v] = dist[u] + 1
            q.append(v)

print(' '.join(map(str, dist)))
