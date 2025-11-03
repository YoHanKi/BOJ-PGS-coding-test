T = int(input())
for _ in range(T):
    M, N, x, y = map(int, input().split())
    year = x
    while True:
        if (year - y) % N == 0:
            print(year)
            break
        year += M
        if year > M * N:
            print(-1)
            break