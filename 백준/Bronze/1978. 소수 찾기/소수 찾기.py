import math

primeList = [True] * 1001
primeList[0], primeList[1] = False, False

for i in range(2, int(math.sqrt(1000)) + 1):
    if not primeList[i]:
        continue
    for j in range(i * 2, 1001, i):
        primeList[j] = False

N = int(input())
numList = list(map(int, input().split()))

answer = 0
for i in numList:
    answer += primeList[i]

print(answer)