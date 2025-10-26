from collections import deque

T = int(input())

def command_processor(p, arr):
    dp = deque(arr)
    rev = False
    for cmd in p:
        if cmd == 'R':
            rev = not rev
        elif cmd == 'D':
            if not dp:
                return "error"
            if rev:
                dp.pop()
            else:
                dp.popleft()
    if rev:
        dp.reverse()
    return "[" + ",".join(map(str, dp)) + "]"

for _ in range(T):
    p = input().strip()
    n = int(input().strip())
    arr_line = input().strip()
    if n > 0:
        inner = arr_line[1:-1]
        arr = [x.strip() for x in inner.split(',') if x.strip()]
    else:
        arr = []
    print(command_processor(p, arr))