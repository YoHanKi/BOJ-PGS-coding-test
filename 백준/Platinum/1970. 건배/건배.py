# 건배 다국어 - BOJ
# 원형 테이블에서 같은 브랜드끼리만 짝지을 수 있고, 동시에 하는 짝들이 팔이 엇갈리지 않아야 함.
# 최대 비교적 비슷한 문제: 비교 가능한 호환성으로 비교하지 않고 동일한 값끼리만 매칭.
# 접근: 원형을 선형으로 만들기 위해 배열을 두 번 이어붙이고, 길이 <= N인 구간에 대해
# 비교적 표준 구간 DP를 수행한다.
# dp[l][r] = 구간 [l..r]에서 만들 수 있는 최대 쌍 수 (끼리 교차 없음)
# 전이: dp[l][r] = max(dp[l][r-1], max_{k in [l..r-1], A[k]==A[r]} dp[l][k-1] + 1 + dp[k+1][r-1])
# 최종 답은 모든 시작점 s: dp[s][s+N-1]의 최댓값

import sys
from array import array

input = sys.stdin.readline
data = input().split()
N = int(data[0])
brands = []
while len(brands) < N:
    parts = input().split()
    if not parts:
        break
    brands.extend(map(int, parts))
if len(brands) < N and len(data) > 1:
    brands = list(map(int, data[1:])) + brands
brands = brands[:N]

if N <= 1:
    print(0)
    exit(0)

if all(b == brands[0] for b in brands):
    print(N // 2)
    exit(0)

B = brands + brands
L = 2 * N

pos = {}
for i, v in enumerate(B):
    pos.setdefault(v, []).append(i)

dp = [array('H', [0]) * L for _ in range(L)]

for length in range(1, N + 1):
    for l in range(0, L - length + 1):
        r = l + length - 1
        val = dp[l][r - 1] if r - 1 >= l else 0
        v = B[r]
        for k in pos[v]:
            if k < l:
                continue
            if k >= r:
                break
            left = dp[l][k - 1] if k - 1 >= l else 0
            right = dp[k + 1][r - 1] if k + 1 <= r - 1 else 0
            cand = left + 1 + right
            if cand > val:
                val = cand
        dp[l][r] = val

ans = 0
for s in range(0, N):
    cur = dp[s][s + N - 1]
    if cur > ans:
        ans = cur
print(ans)


