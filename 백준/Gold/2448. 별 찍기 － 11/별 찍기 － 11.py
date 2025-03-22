def printStar(y, x, size):
    global star
    if size == 3:
        star[y][x] = '*'
        star[y + 1][x - 1] = star[y + 1][x + 1] = '*'
        for k in range(-2, 3):
            star[y + 2][x + k] = '*'
    else :
        printStar(y, x, size // 2)
        printStar(y + size // 2, x - size // 2, size // 2)
        printStar(y + size // 2, x + size // 2, size // 2)

N = int(input())

star = [[' '] * ((2 * N) - 1) for _ in range(N)]

printStar(0, N - 1, N)

for s in star:
    print("".join(s))