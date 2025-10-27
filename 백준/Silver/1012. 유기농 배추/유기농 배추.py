from collections import deque

def bfs(x, y, M, N, grid, visited, directions):
    queue = deque()
    queue.append((x, y))

    visited[x][y] = True

    while queue:
        cur_x, cur_y = queue.popleft()

        for dx, dy in directions:
            nx, ny = cur_x + dx, cur_y + dy

            if 0 <= nx < M and 0 <= ny < N:
                if grid[nx][ny] == 1 and not visited[nx][ny]:
                    visited[nx][ny] = True
                    grid[nx][ny] = 0
                    arr.remove((nx, ny))
                    queue.append((nx, ny))

    return True

T = int(input())

for _ in range(T):
    M, N, K = map(int, input().split())
    grid = [[0] * N for _ in range(M)]
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    arr = set()
    for _ in range(K):
        x, y = map(int, input().split())
        grid[x][y] = 1
        arr.add((x, y))

    visited = [[False] * N for _ in range(M)]

    count = 0
    while arr:
        x, y = arr.pop()
        if bfs(x, y, M, N, grid, visited, directions):
            count += 1

    print(count)


