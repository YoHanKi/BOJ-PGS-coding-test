S = input()

A = [-1] * 26
for i in range(len(S)):
    now = ord(S[i]) - ord('a')
    A[now] = i if A[now] == -1 else A[now]

for i in range(len(A)):
    print(A[i], end=' ')