from collections import deque

TEST = int(input())
directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

for _ in range(TEST):
    W, H = map(int, input().split())
    building = [list(input().strip()) for _ in range(H)]

    f_q = deque()
    sang_q = deque()
    visited = [[False] * W for _ in range(H)]

    for y in range(H):
        for x in range(W):
            if building[y][x] == '*':
                f_q.append((x, y, 0))
                visited[y][x] = True
            elif building[y][x] == '@':
                sang_q.append((x, y, 0))
                visited[y][x] = True
            elif building[y][x] == '#':
                visited[y][x] = True

    escaped = False
    while sang_q:
        for _ in range(len(f_q)):
            fx, fy, fdist = f_q.popleft()
            for dx, dy in directions:
                nfx, nfy = fx + dx, fy + dy
                if 0 <= nfx < W and 0 <= nfy < H and not visited[nfy][nfx]:
                    visited[nfy][nfx] = True
                    f_q.append((nfx, nfy, fdist + 1))

        for _ in range(len(sang_q)):
            sx, sy, sdist = sang_q.popleft()
            if sx == 0 or sx == W - 1 or sy == 0 or sy == H - 1:
                print(sdist + 1)
                escaped = True
                break
            for dx, dy in directions:
                nsx, nsy = sx + dx, sy + dy
                if 0 <= nsx < W and 0 <= nsy < H and not visited[nsy][nsx]:
                    visited[nsy][nsx] = True
                    sang_q.append((nsx, nsy, sdist + 1))
        if escaped:
            break

    if not escaped:
        print("IMPOSSIBLE")