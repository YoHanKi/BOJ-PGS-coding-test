def func1(n):
    global N, A, dp1

    if dp1[n] != -1:
        return dp1[n]

    dp1[n] = 1
    for i in range(1, n):
        if A[i] < A[n]:
            dp1[n] = max(dp1[n], func1(i) + 1)

    return dp1[n]

def func2(n):
    global N, A, dp2

    if dp2[n] != -1:
        return dp2[n]

    dp2[n] = 1
    for i in range(N, n, -1):
        if A[i] < A[n]:
            dp2[n] = max(dp2[n], func2(i) + 1)

    return dp2[n]

N = int(input())
A = [0] + list(map(int, input().split()))

dp1 = [-1] * (N + 1)
dp2 = [-1] * (N + 1)
dp1[1] = dp2[N] = 1

answer = 0

for n in range(1, N + 1):
    answer = max(answer, func1(n) + func2(n) - 1)

print(answer)