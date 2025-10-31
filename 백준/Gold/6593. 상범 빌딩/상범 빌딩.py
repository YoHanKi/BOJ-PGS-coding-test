from collections import deque

directions = [(-1, 0, 0), (1, 0, 0), (0, -1, 0), (0, 1, 0), (0, 0, -1), (0, 0, 1)]

L, R, C = map(int, input().split())

while L != 0 and R != 0 and C != 0:
    building = []
    start = None
    end = None

    for l in range(L):
        floor = []
        for r in range(R):
            row = list(input().strip())
            for c in range(C):
                if row[c] == 'S':
                    start = (l, r, c)
                elif row[c] == 'E':
                    end = (l, r, c)
            floor.append(row)
        building.append(floor)
        input()  # blank line

    visited = [[[False] * C for _ in range(R)] for _ in range(L)]
    queue = deque()
    queue.append((start[0], start[1], start[2], 0))
    visited[start[0]][start[1]][start[2]] = True

    escaped = False
    while queue:
        l, r, c, dist = queue.popleft()

        if (l, r, c) == end:
            print(f"Escaped in {dist} minute(s).")
            escaped = True
            break

        for dl, dr, dc in directions:
            nl, nr, nc = l + dl, r + dr, c + dc

            if 0 <= nl < L and 0 <= nr < R and 0 <= nc < C:
                if not visited[nl][nr][nc] and building[nl][nr][nc] != '#':
                    visited[nl][nr][nc] = True
                    queue.append((nl, nr, nc, dist + 1))

    if not escaped:
        print("Trapped!")

    L, R, C = map(int, input().split())