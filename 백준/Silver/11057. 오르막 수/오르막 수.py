N = int(input())
MOD = 10007

dp = [1] * 10

for _ in range(2, N + 1):
    new = [0] * 10
    cum = 0
    for d in range(10):
        cum = (cum + dp[d]) % MOD
        new[d] = cum
    dp = new

print(sum(dp) % MOD)