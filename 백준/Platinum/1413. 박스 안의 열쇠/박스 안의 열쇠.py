# 박스 안의 열쇠
# N(<=20)개의 박스에 키가 무작위로 들어있음(모든 순열 동일 확률).
# 다못이는 M개의 폭탄을 사용하여 박스를 파괴하여 얻은 키로 연쇄적으로 박스를 열어간다.
# 한 사이클(순열의 사이클)에 한 번도 폭파하지 않으면 그 사이클의 키들을 얻을 수 없음.
# 따라서 성공 확률은 순열의 사이클 수 <= M 인 확률.
# 사이클 수가 k인 순열의 개수는 unsigned Stirling numbers of the first kind: s(N,k).
# 확률 = sum_{k=1..M} s(N,k) / N!

import sys
from math import gcd

data = sys.stdin.read().strip().split()
N = int(data[0]); M = int(data[1])
s = [[0] * (N + 1) for _ in range(N + 1)]
s[0][0] = 1
for n in range(1, N + 1):
    for k in range(1, n + 1):
        s[n][k] = s[n-1][k-1] + (n-1) * s[n-1][k]
numerator = sum(s[N][1: min(M, N) + 1])
fact = 1
for i in range(2, N + 1):
    fact *= i
denom = fact
g = gcd(numerator, denom)
numerator //= g
denom //= g
print(f"{numerator}/{denom}")