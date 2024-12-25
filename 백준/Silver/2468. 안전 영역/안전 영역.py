import sys
sys.setrecursionlimit(int(1e6))

def dfs(x, y, height):
    global N, maps, visited, dx, dy

    if not (0 <= y < N and 0 <= x < N):
        return
    if visited[y][x] or maps[y][x] <= height:
        return

    visited[y][x] = True

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        dfs(nx, ny, height)


N = int(input())

maps = [list(map(int, input().split())) for _ in range(N)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

visited = [[False] * N for _ in range(N)]

count = 0
for height in range(0, 101):
    sum = 0
    for y in range(N):
        for x in range(N):
            if not visited[y][x] and maps[y][x] > height:
                dfs(x, y, height)
                sum += 1

    visited = [[False] * N for _ in range(N)]
    count = max(count, sum)

print(count)