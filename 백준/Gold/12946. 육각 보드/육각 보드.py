from collections import deque

N = int(input())
board = [list(input().strip()) for _ in range(N)]

dx = [0, 1, -1, 1, -1, 0]
dy = [-1, -1, 0, 0, 1, 1]

color = [[-1] * N for _ in range(N)]
has_x = False
has_edge = False
is_bipartite = True

for i in range(N):
    for j in range(N):
        if board[i][j] != 'X' or color[i][j] != -1:
            continue
        has_x = True
        color[i][j] = 0
        q = deque([(i, j)])

        while q:
            x, y = q.popleft()
            for k in range(6):
                nx, ny = x + dx[k], y + dy[k]
                if not (0 <= nx < N and 0 <= ny < N):
                    continue
                if board[nx][ny] != 'X':
                    continue
                has_edge = True
                if color[nx][ny] == -1:
                    color[nx][ny] = color[x][y] ^ 1
                    q.append((nx, ny))
                elif color[nx][ny] == color[x][y]:
                    is_bipartite = False

if not has_x:
    print(0)
elif not has_edge:
    print(1)
elif not is_bipartite:
    print(3)
else:
    print(2)
