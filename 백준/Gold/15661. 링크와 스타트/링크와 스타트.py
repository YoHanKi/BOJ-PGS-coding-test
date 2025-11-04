N = int(input())
matrix = [list(map(int, input().split())) for _ in range(N)]
sym = [[matrix[i][j] + matrix[j][i] for j in range(N)] for i in range(N)]
sel = [False] * N
min_diff = float('inf')

def dfs(idx, cnt):
    global min_diff
    if idx == N:
        return

    sel[idx] = True
    if 1 <= cnt + 1 <= N // 2:
        team1 = [i for i in range(N) if sel[i]]
        team2 = [i for i in range(N) if not sel[i]]
        sum1 = 0
        for a in range(len(team1)):
            for b in range(a + 1, len(team1)):
                sum1 += sym[team1[a]][team1[b]]
        sum2 = 0
        for a in range(len(team2)):
            for b in range(a + 1, len(team2)):
                sum2 += sym[team2[a]][team2[b]]
        diff = abs(sum1 - sum2)
        if diff < min_diff:
            min_diff = diff
    dfs(idx + 1, cnt + 1)

    sel[idx] = False
    dfs(idx + 1, cnt)

dfs(0, 0)
print(min_diff if min_diff != float('inf') else 0)