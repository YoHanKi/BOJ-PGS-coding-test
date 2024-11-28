from itertools import combinations

vows = ['a', 'e', 'i', 'o', 'u']

L, C = map(int, input().split())
arr = input().split()

arr.sort()

for i in combinations(arr, L):
    count = 0
    for j in i:
        count += (j in vows)

    other = L - count

    if count >= 1 and other >= 2:
        print(''.join(i))