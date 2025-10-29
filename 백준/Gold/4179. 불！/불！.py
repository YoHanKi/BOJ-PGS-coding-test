from collections import deque

R, C = map(int, input().split())
maze = [list(input().strip()) for _ in range(R)]

# 지훈이 위치와 불의 위치 찾기
fires = []
for i in range(R):
    for j in range(C):
        if maze[i][j] == 'J':
            start = (i, j)
        elif maze[i][j] == 'F':
            fires.append((i, j))

directions = [(0, -1), (0, 1), (-1, 0), (1, 0)]

def bfs():
    global R, C, maze, start, fires, directions
    visited = [[False] * C for _ in range(R)]

    queue = deque()
    startX, startY = start
    visited[startX][startY] = True
    for fire in fires:
        queue.append((fire[0], fire[1], 0, 'F'))
    queue.append((start[0], start[1], 0, 'J'))

    while queue:
        x, y, time, entity = queue.popleft()

        for dx, dy in directions:
            nx, ny = x + dx, y + dy

            if entity == 'J':
                if nx < 0 or nx >= R or ny < 0 or ny >= C:
                    return time + 1
                if 0 <= nx < R and 0 <= ny < C:
                    if maze[nx][ny] == '.' and not visited[nx][ny]:
                        visited[nx][ny] = True
                        queue.append((nx, ny, time + 1, 'J'))
            elif entity == 'F':
                if 0 <= nx < R and 0 <= ny < C:
                    if maze[nx][ny] in ('.', 'J'):
                        maze[nx][ny] = 'F'
                        queue.append((nx, ny, time + 1, 'F'))

    return "IMPOSSIBLE"

result = bfs()
print(result)
