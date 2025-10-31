from collections import deque

TEST = int(input())

for _ in range(TEST):
    I = int(input())
    start_x, start_y = map(int, input().split())
    end_x, end_y = map(int, input().split())

    visited = [[False] * I for _ in range(I)]

    queue = deque()
    queue.append((start_x, start_y, 0))

    visited[start_x][start_y] = True
    directions = [(-2, -1), (-1, -2), (1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1)]

    while queue:
        x, y, dist = queue.popleft()

        if x == end_x and y == end_y:
            print(dist)
            break

        for dx, dy in directions:
            nx, ny = x + dx, y + dy

            if 0 <= nx < I and 0 <= ny < I and not visited[nx][ny]:
                visited[nx][ny] = True
                queue.append((nx, ny, dist + 1))