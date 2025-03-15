import math

N = int(input())

sizeList = [i for i in map(int, input().split())]

T, P = map(int, input().split())

t_shirt = 0
for size in sizeList:
    t_shirt += math.ceil(size / T)

print(t_shirt)
print(math.floor(N / P), N % P)