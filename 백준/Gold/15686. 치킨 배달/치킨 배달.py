import sys
sys.setrecursionlimit(10**8)

N, M = map(int, input().split())

city = [[0] * (N + 1) for _ in range(N + 1)]
houses = []
chickens = []

for i in range(1, N + 1):
    data = list(map(int, input().split()))
    for j in range(1, N + 1):
        city[i][j] = data[j - 1]
        if city[i][j] == 1:
            houses.append((i, j))
        elif city[i][j] == 2:
            chickens.append((i, j))

check_num = int(1e9)
idx_arr = []
def back_tracking(start, depth):
    global houses, chickens, M, check_num, idx_arr

    if start > len(chickens):
        return

    if depth == M:
        total = 0
        for house in houses:
            min_check = int(1e9)
            for idx in idx_arr:
                chicken = chickens[idx]
                min_check = min(min_check, abs(house[0] - chicken[0]) + abs(house[1] - chicken[1]))

            total += min_check

        check_num = min(check_num, total)
        return

    idx_arr.append(start)
    back_tracking(start + 1, depth + 1)
    idx_arr.pop()
    back_tracking(start + 1, depth)
    return check_num

print(back_tracking(0, 0))