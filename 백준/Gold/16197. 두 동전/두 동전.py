import sys
sys.setrecursionlimit(10**7)

N, M = map(int, input().split())
grid = [list(input().strip()) for _ in range(N)]

directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
min_moves = float('inf')

def is_in_bounds(x, y):
    return 0 <= x < M and 0 <= y < N

def dfs(x1, y1, x2, y2, moves):
    global min_moves
    if moves >= min_moves:
        return
    if (x1, y1) == (x2, y2):
        return
    if moves > 10:
        return

    for dx, dy in directions:
        nx1, ny1 = x1 + dx, y1 + dy
        nx2, ny2 = x2 + dx, y2 + dy

        fall_count = 0
        if not is_in_bounds(nx1, ny1):
            fall_count += 1
        if not is_in_bounds(nx2, ny2):
            fall_count += 1

        if fall_count == 1:
            if moves + 1 <= 10:
                min_moves = min(min_moves, moves + 1)
            continue
        elif fall_count == 0:
            if grid[ny1][nx1] == '#':
                nx1, ny1 = x1, y1
            if grid[ny2][nx2] == '#':
                nx2, ny2 = x2, y2
            dfs(nx1, ny1, nx2, ny2, moves + 1)

start_positions = []
for y in range(N):
    for x in range(M):
        if grid[y][x] == 'o':
            start_positions.append((x, y))
(x1, y1), (x2, y2) = start_positions
dfs(x1, y1, x2, y2, 0)
print(min_moves if min_moves != float('inf') else -1)