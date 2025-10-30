from collections import deque

W, H, C = map(int, input().split())

boxes = []
for _ in range(C):
    boxes.append([list(map(int, input().split())) for _ in range(H)])

directions = [(1,0,0), (-1,0,0), (0,1,0), (0,-1,0), (0,0,1), (0,0,-1)]

def bfs():
    global W, H, C, boxes, directions
    queue = deque()
    for z in range(C):
        for x in range(H):
            for y in range(W):
                if boxes[z][x][y] == 1:
                    queue.append((z, x, y, 0))

    max_days = 0
    while queue:
        z, x, y, days = queue.popleft()
        max_days = max(max_days, days)

        for dz, dx, dy in directions:
            nz, nx, ny = z + dz, x + dx, y + dy

            if 0 <= nz < C and 0 <= nx < H and 0 <= ny < W:
                if boxes[nz][nx][ny] == 0:
                    boxes[nz][nx][ny] = 1
                    queue.append((nz, nx, ny, days + 1))

    for z in range(C):
        for x in range(H):
            for y in range(W):
                if boxes[z][x][y] == 0:
                    return -1
    return max_days

print(bfs())