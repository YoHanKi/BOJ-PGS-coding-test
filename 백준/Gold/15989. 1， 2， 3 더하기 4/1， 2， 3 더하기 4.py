T = int(input())

max_n = 10001
dp = [1] * max_n
for i in range(2, max_n):
    dp[i] += dp[i - 2]

for i in range(3, max_n):
    dp[i] += dp[i - 3]


for _ in range(T):
    n = int(input())
    print(dp[n])