N = int(input())

meetings = [list(map(int, input().split())) for _ in range(N)]
meetings = sorted(meetings, key=lambda x: (x[1], x[0]))

answer = 0
now = 0

for a, b in meetings:
    if a >= now:
        answer += 1
        now = b

print(answer)