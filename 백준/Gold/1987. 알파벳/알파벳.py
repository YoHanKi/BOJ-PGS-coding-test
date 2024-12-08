def search(y, x):
    global dy, dx, R, C, board, check, cur_len, ans

    # base case
    if y < 0 or x < 0 or y >= R or x >= C:
        return
    if check[ord(board[y][x]) - ord('A')]:
        return
    check[ord(board[y][x]) - ord('A')] = True
    cur_len += 1

    ans = max(ans, cur_len)

    # recursive case
    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        search(ny, nx)

    cur_len -= 1
    check[ord(board[y][x]) - ord('A')] = False


dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]

R, C = map(int, input().split())
board = [input() for _ in range(R)]

check = [False] * 26
cur_len = 0
ans = 0

search(0, 0)

print(ans)