from collections import deque

N = int(input())
maps = [list(map(int, input().strip())) for _ in range(N)]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
visited = [[False] * N for _ in range(N)]

def bfs(x, y):
    q = deque()
    q.append((x, y))
    visited[x][y] = True
    count = 1

    while q:
        cx, cy = q.popleft()
        for dir in range(4):
            nx = cx + dx[dir]
            ny = cy + dy[dir]
            if 0 <= nx < N and 0 <= ny < N:
                if maps[nx][ny] == 1 and not visited[nx][ny]:
                    visited[nx][ny] = True
                    q.append((nx, ny))
                    count += 1
    return count

result = []
for i in range(N):
    for j in range(N):
        if maps[i][j] == 1 and not visited[i][j]:
            result.append(bfs(i, j))

result.sort()
print(len(result))
for r in result:
    print(r)