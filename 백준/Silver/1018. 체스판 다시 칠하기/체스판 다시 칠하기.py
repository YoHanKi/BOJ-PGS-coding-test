b = [['' for _ in range(8)] for _ in range(8)]
w = [['' for _ in range(8)] for _ in range(8)]

for i in range(8):
    for j in range(8):
        b[i][j] = ('B' if (i + j) % 2 == 0 else 'W')
        w[i][j] = ('W' if (i + j) % 2 == 0 else 'B')

N, M = map(int, input().split())

board = [input() for _ in range(N)]

answer = int(1e12)

for i in range(N):
    for j in range(M):
        if i + 8 <= N and j + 8 <= M:
            cnt1 = 0
            cnt2 = 0
            for x in range(8):
                for y in range(8):
                    if board[i + x][j + y] != b[x][y]:
                        cnt1 += 1
                    if board[i + x][j + y] != w[x][y]:
                        cnt2 += 1
            answer = min(answer, cnt1, cnt2)

print(answer)

