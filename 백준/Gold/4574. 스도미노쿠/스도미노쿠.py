import sys
input = sys.stdin.readline

step = 1

grid = [[0] * 10 for _ in range(10)]
row_used = [[False] * 10 for _ in range(10)] # 해당 행에 숫자 v가 사용되었는지
col_used = [[False] * 10 for _ in range(10)] # 해당 열에 숫자 v가 사용되었는지
box_used = [[False] * 10 for _ in range(10)] # 해당 박스에 숫자 v가 사용되었는지
pair_used = [[False] * 10 for _ in range(10)] # 숫자 a,b 쌍이 사용되었는지

def box_idx(r, c):
    # 1..9 -> 1..9
    return ((r - 1) // 3) * 3 + ((c - 1) // 3) + 1

def can_place(r, c, v):
    return (not row_used[r][v]) and (not col_used[c][v]) and (not box_used[box_idx(r, c)][v])

def place(r, c, v, flag=True):
    # flag=True면 놓기, False면 되돌리기
    grid[r][c] = v if flag else 0
    row_used[r][v] = flag
    col_used[c][v] = flag
    box_used[box_idx(r, c)][v] = flag

def use_pair(a, b, flag=True):
    pair_used[a][b] = flag
    pair_used[b][a] = flag

def to_rc(cell):
    r = ord(cell[0]) - ord('A') + 1
    c = int(cell[1])
    return r, c

def find_next_empty():
    for r in range(1, 10):
        for c in range(1, 10):
            if grid[r][c] == 0:
                return r, c
    return 0, 0

def solve():
    r, c = find_next_empty()
    if r == 0:
        return True

    if c + 1 <= 9 and grid[r][c + 1] == 0:
        for a in range(1, 10):
            if not can_place(r, c, a):
                continue
            for b in range(1, 10):
                if a == b:
                    continue
                if pair_used[a][b]:
                    continue
                if not can_place(r, c + 1, b):
                    continue
                place(r, c, a, True)
                place(r, c + 1, b, True)
                use_pair(a, b, True)

                if solve():
                    return True

                use_pair(a, b, False)
                place(r, c + 1, b, False)
                place(r, c, a, False)

    if r + 1 <= 9 and grid[r + 1][c] == 0:
        for a in range(1, 10):
            if not can_place(r, c, a):
                continue
            for b in range(1, 10):
                if a == b:
                    continue
                if pair_used[a][b]:
                    continue
                if not can_place(r + 1, c, b):
                    continue
                place(r, c, a, True)
                place(r + 1, c, b, True)
                use_pair(a, b, True)

                if solve():
                    return True

                use_pair(a, b, False)
                place(r + 1, c, b, False)
                place(r, c, a, False)

    return False

def reset_state():
    for r in range(10):
        for c in range(10):
            grid[r][c] = 0
    for r in range(10):
        for v in range(10):
            row_used[r][v] = False
            col_used[v][r] = False
    for b in range(10):
        for v in range(10):
            box_used[b][v] = False
    for a in range(10):
        for b in range(10):
            pair_used[a][b] = False

def solution(N):
    global step
    print(f"Puzzle {step}")
    step += 1

    reset_state()

    for _ in range(N):
        U, LU, V, LV = input().split()
        U = int(U); V = int(V)
        r1, c1 = to_rc(LU)
        r2, c2 = to_rc(LV)

        if not can_place(r1, c1, U):
            pass
        place(r1, c1, U, True)
        if not can_place(r2, c2, V):
            pass
        place(r2, c2, V, True)

        use_pair(U, V, True)

    line = input().split()
    for i in range(9):
        cell = line[i]
        r, c = to_rc(cell)
        v = i + 1
        place(r, c, v, True)

    solve()

    for r in range(1, 10):
        print(''.join(str(grid[r][c]) for c in range(1, 10)))

N = int(input())
while N != 0:
    solution(N)
    N = int(input())