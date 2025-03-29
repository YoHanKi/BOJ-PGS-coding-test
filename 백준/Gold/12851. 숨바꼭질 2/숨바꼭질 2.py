import sys
from collections import deque

input = sys.stdin.readline
N, K = map(int, input().split())
limit = 100001
dist = [-1] * limit
ways = [0] * limit

q = deque([N])
dist[N] = 0
ways[N] = 1

while q:
    pos = q.popleft()
    for nxt in (pos - 1, pos + 1, pos * 2):
        if nxt < 0 or nxt >= limit:
            continue
        if dist[nxt] == -1:
            dist[nxt] = dist[pos] + 1
            ways[nxt] = ways[pos]
            q.append(nxt)
        elif dist[nxt] == dist[pos] + 1:
            ways[nxt] += ways[pos]

print(dist[K])
print(ways[K])