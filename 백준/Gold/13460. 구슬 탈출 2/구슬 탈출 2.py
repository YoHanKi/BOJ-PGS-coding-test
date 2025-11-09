from collections import deque

H, W = map(int, input().split())

board = []
for h in range(H):
    row = input().strip()
    for r in row:
        if r == '#':
            continue
        elif r == 'R':
            red_position = (h, row.index('R'))
        elif r == 'B':
            blue_position = (h, row.index('B'))
        elif r == 'O':
            hole_position = (h, row.index('O'))
    board.append(list(row))

directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def move_until_wall_or_hole(x, y, dx, dy):
    distance = 0
    while True:
        nx, ny = x + dx, y + dy
        if board[nx][ny] == '#':
            break
        if board[nx][ny] == 'O':
            x, y = nx, ny
            distance += 1
            break
        x, y = nx, ny
        distance += 1
    return x, y, distance

def bfs():
    queue = deque()
    queue.append((red_position[0], red_position[1], blue_position[0], blue_position[1], 0))
    visited = set()
    visited.add((red_position[0], red_position[1], blue_position[0], blue_position[1]))

    while queue:
        rx, ry, bx, by, depth = queue.popleft()

        if depth >= 10:
            continue

        for dx, dy in directions:
            nrx, nry, r_dist = move_until_wall_or_hole(rx, ry, dx, dy)
            nbx, nby, b_dist = move_until_wall_or_hole(bx, by, dx, dy)

            if board[nbx][nby] == 'O':
                continue
            if board[nrx][nry] == 'O':
                return depth + 1

            if nrx == nbx and nry == nby:
                if r_dist > b_dist:
                    nrx -= dx
                    nry -= dy
                else:
                    nbx -= dx
                    nby -= dy

            if (nrx, nry, nbx, nby) not in visited:
                visited.add((nrx, nry, nbx, nby))
                queue.append((nrx, nry, nbx, nby, depth + 1))

    return -1

print(bfs())