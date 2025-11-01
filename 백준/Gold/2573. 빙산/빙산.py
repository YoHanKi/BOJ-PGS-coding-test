import sys
from collections import deque

input = sys.stdin.readline

H, W = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(H)]

ice = []
for y in range(H):
    for x in range(W):
        if grid[y][x] > 0:
            ice.append((y, x))

directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def check_count():
    global ice, grid
    visited = [[False] * W for _ in range(H)]
    count = 0

    for y, x in ice:
        if not visited[y][x]:
            count += 1
            queue = deque()
            queue.append((y, x))
            visited[y][x] = True

            while queue:
                cy, cx = queue.popleft()

                for dy, dx in directions:
                    ny, nx = cy + dy, cx + dx

                    if 0 <= ny < H and 0 <= nx < W:
                        if not visited[ny][nx] and grid[ny][nx] > 0:
                            visited[ny][nx] = True
                            queue.append((ny, nx))
    return count

years = 0
while check_count() < 2:
    years += 1
    melt = []

    for y, x in ice:
        water_count = 0

        for dy, dx in directions:
            ny, nx = y + dy, x + dx

            if 0 <= ny < H and 0 <= nx < W:
                if grid[ny][nx] == 0:
                    water_count += 1

        melt.append((y, x, water_count))

    new_ice = []
    for y, x, water_count in melt:
        grid[y][x] = max(0, grid[y][x] - water_count)
        if grid[y][x] > 0:
            new_ice.append((y, x))

    ice = new_ice

    if not ice:
        years = 0
        break

print(years)