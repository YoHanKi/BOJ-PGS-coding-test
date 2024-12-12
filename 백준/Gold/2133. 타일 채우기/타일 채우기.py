dp = [[0, 0, 0] for _ in range(31)]
dp[1][1] = 2
dp[2][0] = 2
dp[2][2] = 3

for n in range(3, 31):
    dp[n][0] = dp[n - 1][1]
    dp[n][1] = dp[n - 1][2] * 2 + dp[n - 1][0]
    dp[n][2] = dp[n][0] + dp[n - 2][2]

N = int(input())

print(dp[N][2])