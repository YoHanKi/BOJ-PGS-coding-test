def is_possible(y, x, num):
    global board
    for i in range(9):
        if board[y][i] == num or board[i][x] == num:
            return False
    for i in range(3):
        for j in range(3):
            if board[(y // 3) * 3 + i][(x // 3) * 3 + j] == num:
                return False
    return True

def check(lev):
    global board, pos

    if lev == len(pos):
        for i in range(9):
            for j in range(9):
                print(board[i][j], end=' ')
            print()
        exit(0)
        return

    y, x = pos[lev]

    for i in range(1, 10):
        if is_possible(y, x, i):
            board[y][x] = i
            check(lev + 1)
            board[y][x] = 0

board = [list(map(int, input().split())) for _ in range(9)]

pos = []

for i in range(9):
    for j in range(9):
        if board[i][j] == 0:
            pos.append((i, j))

check(0)
