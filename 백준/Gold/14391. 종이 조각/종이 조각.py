N, M = map(int, input().split())
grid = [list(map(int, input().strip())) for _ in range(N)]

max_sum = 0
for mask in range(1 << (N * M)):
    total = 0
    for i in range(N):
        j = 0
        while j < M:
            if ((mask >> (i * M + j)) & 1) == 1:
                num = 0
                k = j
                while k < M and ((mask >> (i * M + k)) & 1) == 1:
                    num = num * 10 + grid[i][k]
                    k += 1
                total += num
                j = k
            else:
                j += 1
    for j in range(M):
        i = 0
        while i < N:
            if ((mask >> (i * M + j)) & 1) == 0:
                num = 0
                k = i
                while k < N and ((mask >> (k * M + j)) & 1) == 0:
                    num = num * 10 + grid[k][j]
                    k += 1
                total += num
                i = k
            else:
                i += 1
    if total > max_sum:
        max_sum = total

print(max_sum)