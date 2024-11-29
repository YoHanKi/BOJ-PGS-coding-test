from itertools import permutations

N = int(input())

arr = [input().split() for _ in range(N)]

answer = 0

for perm in permutations(range(1, 10), 3):
    flag = True

    for ex, s, b in arr:
        st = ba = 0

        for i in range(3):
            if str(perm[i]) == ex[i]:
                st += 1
            elif str(perm[i]) in ex:
                ba += 1

        if st != int(s) or ba != int(b):
            flag = False
            break

    if flag:
        answer += 1

print(answer)