S = int(input())

for _ in range(S):
    A, B = input().split()
    for i in B:
        print(i * int(A), end='')
    print()