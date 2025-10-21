import sys
from itertools import permutations, product
from collections import deque

board = [[list(map(int, input().split(' '))) for _ in range(5)] for _ in range(5)]
b = [[[0] * 5 for _ in range(5)] for _ in range(5)]
result = sys.maxsize
dx = [1, -1, 0, 0, 0, 0]
dy = [0, 0, 1, -1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]
visited = [[[0] * 5 for _ in range(5)] for _ in range(5)]

def rotate(layers):
    new_layer = [[0] * 5 for _ in range(5)]
    for i in range(5):
        for j in range(5):
            new_layer[j][4 - i] = layers[i][j]
    return new_layer

rot_pre = []
for k in range(5):
    r0 = board[k]
    r1 = rotate(r0)
    r2 = rotate(r1)
    r3 = rotate(r2)
    rot_pre.append((r0, r1, r2, r3))

def bfs():
    if b[0][0][0] == 0 or b[4][4][4] == 0:
        return sys.maxsize

    for z in range(5):
        for y in range(5):
            for x in range(5):
                visited[z][y][x] = 0

    q = deque()
    q.append((0, 0, 0, 0))
    visited[0][0][0] = 1

    while q:
        z, y, x, dist = q.popleft()
        if (z, y, x) == (4, 4, 4):
            return dist

        rem = (4 - z) + (4 - y) + (4 - x)
        if dist + rem >= result:
            continue

        for i in range(6):
            nz = z + dz[i]
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= nz < 5 and 0 <= ny < 5 and 0 <= nx < 5:
                if visited[nz][ny][nx] == 0 and b[nz][ny][nx] == 1:
                    visited[nz][ny][nx] = 1
                    q.append((nz, ny, nx, dist + 1))
    return sys.maxsize

for perm in permutations(range(5), 5):
    for rotates in product(range(4), repeat=5):
        for i in range(5):
            b[i] = rot_pre[perm[i]][rotates[i]]

        if b[0][0][0] == 0 or b[4][4][4] == 0:
            continue

        res = bfs()
        if res < result:
            result = res
            if result == 12:
                print(12)
                sys.exit(0)

if result == sys.maxsize:
    print(-1)
else:
    print(result)