import sys

input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())
    phone_numbers = [input().strip() for _ in range(n)]
    phone_numbers.sort()

    is_consistent = True
    for i in range(n - 1):
        if phone_numbers[i + 1].startswith(phone_numbers[i]):
            is_consistent = False
            break

    print("YES" if is_consistent else "NO")