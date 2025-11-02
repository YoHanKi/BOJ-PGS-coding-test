import sys
from collections import deque
input = sys.stdin.readline

K = int(input())
W, H = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(H)]
directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
horse_moves = [(-2, -1), (-1, -2), (1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1)]

visited = [[[False] * (K + 1) for _ in range(W)] for _ in range(H)]
queue = deque()
queue.append((0, 0, 0, K))
visited[0][0][K] = True
result = -1

while queue:
    x, y, dist, horse_left = queue.popleft()

    if x == W - 1 and y == H - 1:
        result = dist
        break

    for dx, dy in directions:
        nx, ny = x + dx, y + dy

        if 0 <= nx < W and 0 <= ny < H and grid[ny][nx] == 0 and not visited[ny][nx][horse_left]:
            visited[ny][nx][horse_left] = True
            queue.append((nx, ny, dist + 1, horse_left))

    if horse_left > 0:
        for dx, dy in horse_moves:
            nx, ny = x + dx, y + dy

            if 0 <= nx < W and 0 <= ny < H and grid[ny][nx] == 0 and not visited[ny][nx][horse_left - 1]:
                visited[ny][nx][horse_left - 1] = True
                queue.append((nx, ny, dist + 1, horse_left - 1))

print(result)