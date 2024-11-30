from itertools import permutations

S = input()
count = 0

for perm in permutations(S):
    flag = True
    for i in range(0, len(perm) - 1):
        if perm[i] == perm[i + 1]:
            flag = False
            break

    count += flag


def fact(param):
    if param == 0:
        return 1

    return fact(param - 1) * param


for i in range(ord('a'), ord('z') + 1):
    count //= fact(S.count(chr(i)))

print(count)