N = int(input())

cost = [[0, 0, 0]]
cost += [list(map(int, input().split())) for _ in range(N)]

dp = [[-1, -1, -1] for _ in range(N + 1)]

dp[1][0] = cost[1][0]
dp[1][1] = cost[1][1]
dp[1][2] = cost[1][2]

for i in range(2, N + 1):
    dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0]
    dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1]
    dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2]

print(min(dp[N][0], dp[N][1], dp[N][2]))