from collections import deque

N, M, D = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(N)]
max_kills = 0

def simulate(archer_positions):
    global N, M, D, grid
    temp_grid = [row[:] for row in grid]
    kills = 0

    while True:
        targets = set()
        for archer_col in archer_positions:
            min_dist = D + 1
            target = None
            for r in range(N):
                for c in range(M):
                    if temp_grid[r][c] == 1:
                        dist = abs(N - r) + abs(archer_col - c)
                        if dist <= D:
                            if dist < min_dist or (dist == min_dist and c < (target[1] if target else M)):
                                min_dist = dist
                                target = (r, c)
            if target:
                targets.add(target)

        for r, c in targets:
            if temp_grid[r][c] == 1:
                temp_grid[r][c] = 0
                kills += 1

        temp_grid.pop()
        temp_grid.insert(0, [0] * M)

        if all(temp_grid[r][c] == 0 for r in range(N) for c in range(M)):
            break

    return kills

for i in range(M):
    for j in range(i + 1, M):
        for k in range(j + 1, M):
            archer_positions = (i, j, k)
            kills = simulate(archer_positions)
            max_kills = max(max_kills, kills)

print(max_kills)