N = int(input())

if N == 1:
    print(3)
    exit()

dp = [0] * (N + 1)
dp[1] = 3
dp[2] = 7
for i in range(3, N + 1):
    # 점화식: dp[i] = dp[i-1]*2 + dp[i-2]
    # 중간값이 커질 수 있으므로 9901로 나눈 나머지를 저장
    dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % 9901

print(dp[N] % 9901)