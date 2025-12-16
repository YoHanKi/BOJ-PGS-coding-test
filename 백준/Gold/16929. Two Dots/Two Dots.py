N, M = map(int, input().split())
board = [list(input().strip()) for _ in range(N)]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
visited = [[False] * M for _ in range(N)]

def dfs(x, y, start_x, start_y, color, count):
    if visited[x][y]:
        if count - 4 >= 0 and x == start_x and y == start_y:
            return True
        return False

    visited[x][y] = True

    for direction in range(4):
        nx = x + dx[direction]
        ny = y + dy[direction]

        if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == color:
            if dfs(nx, ny, start_x, start_y, color, count + 1):
                return True

    return False

for i in range(N):
    for j in range(M):
        visited = [[False] * M for _ in range(N)]
        if dfs(i, j, i, j, board[i][j], 0):
            print("Yes")
            exit()

print("No")