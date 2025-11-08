N = int(input())
numbers = list(map(int, input().split()))

numbers.sort()
if len(numbers) == 1 and numbers[0] == 0:
    print(1)
    exit()

max_sum = sum(numbers)
possible = [False] * (max_sum + 2)
for i in range(1 << N):
    subset_sum = 0
    for j in range(N):
        if (i >> j) & 1:
            subset_sum += numbers[j]
    if subset_sum <= max_sum + 1:
        possible[subset_sum] = True

for i in range(1, max_sum + 2):
    if not possible[i]:
        print(i)
        break