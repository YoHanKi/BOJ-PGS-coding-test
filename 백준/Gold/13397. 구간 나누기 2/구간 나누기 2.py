import sys
input = lambda: sys.stdin.readline().rstrip()

def is_possible(num):
    global N, M, nums

    mn = nums[0]
    mx = nums[0]
    cnt = 0

    for i in range(1, N):
        mn = min(mn, nums[i])
        mx = max(mx, nums[i])

        if mx - mn > num:
            mn = nums[i]
            mx = nums[i]
            cnt += 1
    cnt += 1

    return cnt <= M

N, M = map(int, input().split())
nums = list(map(int, input().split()))

cur = -1
step = 10001

while step != 0:
    while cur + step <= 10000 and not is_possible(cur + step):
        cur += step
    step //= 2

print(cur + 1)