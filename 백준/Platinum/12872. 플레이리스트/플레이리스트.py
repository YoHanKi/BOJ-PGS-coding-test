N, M, P = map(int, input().split())
MOD = 10**9 + 7
# dp[i][j]: 길이 i인 플레이리스트를 만들었고, 서로 다른 노래를 j개 사용한 경우의 수
# 최종 목표는 dp[P][N]
# i 범위: 0..P, j 범위: 0..N

dp = [[0] * (N + 1) for _ in range(P + 1)]
dp[0][0] = 1

for i in range(P):
    for j in range(N + 1):
        if dp[i][j] == 0:
            continue
        # 새로운 노래를 추가하는 경우: 아직 사용하지 않은 노래 중에서 고른다
        if j < N:
            dp[i + 1][j + 1] = (dp[i + 1][j + 1] + dp[i][j] * (N - j)) % MOD
        # 이미 플레이리스트에 있는 노래를 추가하는 경우: 동일 노래가 다시 나오려면
        # 앞에 적어도 M개의 다른 노래가 있어야 하므로, 현재 사용된 j개의 노래 중
        # 마지막 M개에 속하지 않는 (즉 선택 가능한) 노래 수는 max(j - M, 0)
        if j > M:
            dp[i + 1][j] = (dp[i + 1][j] + dp[i][j] * (j - M)) % MOD

print(dp[P][N] % MOD)
