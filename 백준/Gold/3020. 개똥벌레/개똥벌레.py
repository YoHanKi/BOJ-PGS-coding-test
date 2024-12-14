import sys
input = lambda: sys.stdin.readline().rstrip()

N, H = map(int, input().split())

tops = []
bots = []

for i in range(N):
    num = int(input())
    if i % 2 == 0:
        bots.append(num)
    else:
        tops.append(H - num + 1)

tops = sorted(tops)
bots = sorted(bots)

mn = int(1e12)
mn_num = 0

def get_idx(arr, h):
    cur = -1
    step = len(arr)

    while step != 0:
        while cur + step < len(arr) and arr[cur + step] < h:
            cur += step
        step //= 2

    return cur

for h in range(1, H + 1):
    cnt_bot = (N // 2) - (get_idx(bots, h - 1) + 1)
    cnt_top = get_idx(tops, h) + 1

    if mn == cnt_bot + cnt_top:
        mn_num += 1

    if mn > cnt_bot + cnt_top:
        mn = cnt_bot + cnt_top
        mn_num = 1

print(mn, mn_num)