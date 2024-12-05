def findMax(i, j):
    global N, board
    best = 0

    count = 0
    before = '-'
    for k in range(N):
        if board[i][k] == before:
            count += 1
        else:
            count = 1
        before = board[i][k]
        best = max(best, count)

    count = 0
    before = '-'
    for k in range(N):
        if board[k][j] == before:
            count += 1
        else:
            count = 1
        best = max(best, count)
        before = board[k][j]

    return best


nx = [-1, 0, 1, 0]
ny = [0, -1, 0, 1]

N = int(input())

board = [list(input()) for _ in range(N)]

answer = 0

for i in range(N):
    for j in range(N):
        if i == j:
            answer = max(answer, findMax(i, j))
        for k in range(4):
            x, y = i + nx[k], j + ny[k]

            if 0 <= x < N and 0 <= y < N:
                if board[i][j] != board[x][y]:
                    board[i][j], board[x][y] = board[x][y], board[i][j]
                    answer = max(answer, findMax(i, j))
                    board[i][j], board[x][y] = board[x][y], board[i][j]

print(answer)