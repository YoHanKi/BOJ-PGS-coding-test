import sys
input = lambda: sys.stdin.readline().rstrip()

N, C = map(int, input().split())

houses = sorted([int(input()) for _ in range(N)])

def is_possible(dist):
    global N, C, houses

    cnt = 1
    cur = 0

    for i in range(1, N):
        if houses[i] - houses[cur] >= dist:
            cnt += 1
            cur = i

    return cnt >= C

cur = -1
step = int(1e9) + 1

while step != 0:
    while cur + step <= int(1e9) and is_possible(cur + step):
        cur += step
    step //= 2

print(cur)