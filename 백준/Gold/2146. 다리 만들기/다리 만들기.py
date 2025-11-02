import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
grid = [list(map(int, input().split())) for _ in range(N)]

def bfs(start_x, start_y, island_id):
    queue = deque()
    queue.append((start_x, start_y))
    grid[start_y][start_x] = island_id

    while queue:
        x, y = queue.popleft()

        for dx, dy in directions:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < N and grid[ny][nx] == 1:
                grid[ny][nx] = island_id
                queue.append((nx, ny))

island_id = 2
for y in range(N):
    for x in range(N):
        if grid[y][x] == 1:
            bfs(x, y, island_id)
            island_id += 1

best = 10**4
def find_bridge(island_id):
    global best
    visited = [[-1] * N for _ in range(N)]
    queue = deque()

    for y in range(N):
        for x in range(N):
            if grid[y][x] == island_id:
                queue.append((x, y, 0))
                visited[y][x] = 0

    while queue:
        x, y, dist = queue.popleft()
        if (dist >= best):
            continue

        for dx, dy in directions:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < N:
                if grid[ny][nx] > 0 and grid[ny][nx] != island_id:
                    return min(best, dist)
                if grid[ny][nx] == 0 and visited[ny][nx] == -1:
                    visited[ny][nx] = dist + 1
                    queue.append((nx, ny, dist + 1))
    return best

result = 10**4
for id in range(2, island_id):
    bridge_length = find_bridge(id)
    if bridge_length < result:
        result = bridge_length

print(result)