# BOJ 11058 크리보드 문제
# 입력: 버튼을 총 N번 눌렀을 때 화면에 출력되는 'A'의 최댓값
# 점화식: dp[i] = max(dp[i-1]+1, max_{1<=j<=i-3} dp[j] * (i-j-1))
N = int(input())

dp = [0] * (N + 1)
for i in range(1, N + 1):
    # 누르기 한 번으로 A 하나 추가
    dp[i] = dp[i-1] + 1
    # j까지 누르고, Ctrl-A, Ctrl-C (2번), 이후 Ctrl-V를 반복
    # j는 1 .. i-3 까지 고려
    for j in range(1, i-2):
        # (i - j - 1) = 붙여넣기로 총 반복되는 블록 수
        candidate = dp[j] * (i - j - 1)
        if candidate > dp[i]:
            dp[i] = candidate

print(dp[N])

