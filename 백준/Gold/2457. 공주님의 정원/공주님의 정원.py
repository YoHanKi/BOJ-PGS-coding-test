import sys

N = int(sys.stdin.readline())
flowers = [[0, 0] for _ in range(N)]

for i in range(N):
    sm, sd, em, ed = map(int, sys.stdin.readline().split())
    start = sm * 100 + sd
    end = em * 100 + ed
    flowers[i][0] = start
    flowers[i][1] = end

flowers.sort(key=lambda x: (x[0], x[1]))
start_date = 301
end_date = 1201
count = 0
idx = 0
current_end = start_date

while current_end < end_date:
    max_end = current_end
    while idx < N and flowers[idx][0] <= current_end:
        if flowers[idx][1] > max_end:
            max_end = flowers[idx][1]
        idx += 1
    if max_end == current_end:
        print(0)
        sys.exit(0)
    current_end = max_end
    count += 1

print(count)