import sys
input = sys.stdin.readline

N, M = map(int, input().split())
grid = [list(map(int,input().split())) for _ in range(N)]
directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
diagrams = [
    [[0,0], [0,1], [0,2], [0,3]],
    [[0,0], [1,0], [1,1], [0,1]],
    [[0,0], [1,0], [2,0], [2,1]],
    [[0,0], [1,0], [1,1], [2,1]],
    [[0,0], [0,1], [1,1], [0,2]],
]
max_sum = -float('inf')

def rotate(diagram):
    return [[-dx, dy] for dy, dx in diagram]

def reflect(diagram):
    return [[dy, -dx] for dy, dx in diagram]

def normalize(diag):
    rs = [r for r, c in diag]
    cs = [c for r, c in diag]
    min_r, min_c = min(rs), min(cs)
    normalized = sorted(((r - min_r, c - min_c) for r, c in diag))
    return tuple(normalized)

all_set = set()
for d in diagrams:
    cur = d
    for _ in range(4):
        all_set.add(normalize(cur))
        all_set.add(normalize(reflect(cur)))
        cur = rotate(cur)

all_diagrams = [list(di) for di in all_set]

for y in range(N):
    for x in range(M):
        for diagram in all_diagrams:
            s = 0
            ok = True
            for dy, dx in diagram:
                ny = y + dy
                nx = x + dx
                if 0 <= ny < N and 0 <= nx < M:
                    s += grid[ny][nx]
                else:
                    ok = False
                    break
            if ok and s > max_sum:
                max_sum = s

print(max_sum)