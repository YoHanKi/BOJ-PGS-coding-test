import sys
input = sys.stdin.readline

N = int(input().strip())
A = [list(map(int, input().split())) for _ in range(N)]

def calc(x, y, d1, d2):
    area = [[0]*N for _ in range(N)]

    for i in range(d1+1):
        area[y+i][x-i] = 5
        area[y+d2+i][x+d2-i] = 5
    for i in range(d2+1):
        area[y+i][x+i] = 5
        area[y+d1+i][x-d1+i] = 5

    for r in range(y+1, y+d1+d2):
        fill = False
        for c in range(N):
            if area[r][c] == 5:
                fill = not fill
            elif fill:
                area[r][c] = 5

    s1 = s2 = s3 = s4 = s5 = 0

    for r in range(0, y + d1):
        for c in range(0, x + 1):
            if area[r][c] != 5:
                s1 += A[r][c]

    for r in range(0, y + d2 + 1):
        for c in range(x + 1, N):
            if area[r][c] != 5:
                s2 += A[r][c]

    right_col = x - d1 + d2
    for r in range(y + d1, N):
        for c in range(0, right_col):
            if area[r][c] != 5:
                s3 += A[r][c]

    for r in range(y + d2 + 1, N):
        for c in range(right_col, N):
            if area[r][c] != 5:
                s4 += A[r][c]

    for r in range(N):
        for c in range(N):
            if area[r][c] == 5:
                s5 += A[r][c]

    mx = max(s1, s2, s3, s4, s5)
    mn = min(s1, s2, s3, s4, s5)
    return mx - mn

ans = 10**18
for y in range(N):
    for x in range(N):
        for d1 in range(1, N):
            for d2 in range(1, N):
                if x - d1 < 0: continue
                if x + d2 >= N: continue
                if y + d1 + d2 >= N: continue
                ans = min(ans, calc(x, y, d1, d2))

print(ans)