# python
import sys
from collections import deque
input = sys.stdin.readline

N, M, P = map(int, input().split())
players = [0] + list(map(int, input().split()))
grid = [list(input().strip()) for _ in range(N)]

dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]
queues = [deque() for _ in range(P + 1)]

for y in range(N):
    for x in range(M):
        if grid[y][x] != '.' and grid[y][x] != '#':
            pid = int(grid[y][x])
            queues[pid].append((x, y))

while True:
    any_expanded = False
    for pid in range(1, P + 1):
        if not queues[pid]:
            continue
        player = players[pid]
        steps = 0
        while steps < player and queues[pid]:
            for _ in range(len(queues[pid])):
                x, y = queues[pid].popleft()
                for dx, dy in dirs:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < M and 0 <= ny < N and grid[ny][nx] == '.':
                        grid[ny][nx] = str(pid)
                        queues[pid].append((nx, ny))
                        any_expanded = True
            steps += 1
    if not any_expanded:
        break

counts = [0] * (P + 1)
for y in range(N):
    for x in range(M):
        if grid[y][x] != '.' and grid[y][x] != '#':
            counts[int(grid[y][x])] += 1

print(' '.join(str(counts[i]) for i in range(1, P + 1)))