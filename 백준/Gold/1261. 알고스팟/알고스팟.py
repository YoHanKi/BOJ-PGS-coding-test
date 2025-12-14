from collections import deque

M, N = map(int, input().split())
rooms = [list(map(int, input().strip())) for _ in range(N)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

q = deque()
visited = [[False] * M for _ in range(N)]
dist = [[-1] * M for _ in range(N)]

q.append((0, 0))
dist[0][0] = 0
visited[0][0] = True

while q:
    x, y = q.popleft()
    for dir in range(4):
        nx = x + dx[dir]
        ny = y + dy[dir]
        if 0 <= nx < N and 0 <= ny < M:
            if not visited[nx][ny]:
                visited[nx][ny] = True
                if rooms[nx][ny] == 0:
                    dist[nx][ny] = dist[x][y]
                    q.appendleft((nx, ny))
                else:
                    dist[nx][ny] = dist[x][y] + 1
                    q.append((nx, ny))
print(dist[N-1][M-1])