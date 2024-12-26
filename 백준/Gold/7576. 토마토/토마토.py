from collections import deque

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

M, N = map(int, input().split())

box = [list(map(int, input().split())) for _ in range(N)]

INF = int(1e9)

visited = [[INF] * M for _ in range(N)]

q = deque()

for y in range(N):
    for x in range(M):
        if box[y][x] == 1:
            q.append((y, x))
            visited[y][x] = 0

while q:
    y, x = q.popleft()

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if not (0 <= nx < M and 0 <= ny < N):
            continue

        if box[ny][nx] == -1:
            continue

        if visited[ny][nx] > visited[y][x] + 1:
            visited[ny][nx] = visited[y][x] + 1
            q.append((ny, nx))

result = 0

for y in range(N):
    for x in range(M):
        if box[y][x] != -1:
            result = max(result, visited[y][x])

print(result if result != INF else -1)