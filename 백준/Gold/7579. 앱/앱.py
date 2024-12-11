INF = int(1e9)
MAX = 10001

N, M = map(int, input().split())

A = [0] + list(map(int, input().split()))
C = [0] + list(map(int, input().split()))

dp = [[0] * MAX for _ in range(N + 1)]

for i in range(1, N + 1):
    for j in range(0, MAX):
        dp[i][j] = dp[i - 1][j]
        if j - C[i] >= 0:
            dp[i][j] = max(dp[i][j], dp[i - 1][j - C[i]] + A[i])

answer = INF
for i in range(0, MAX):
    if dp[N][i] >= M:
        answer = min(answer, i)

print(answer)