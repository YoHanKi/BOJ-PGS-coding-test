import sys
input = sys.stdin.readline

N = int(input().strip())
matrix = [list(map(int, input().split())) for _ in range(N)]
visited = [False] * N
half = N // 2
ans = float('inf')

def dfs(start, cnt):
    global ans
    if cnt == half:
        team1, team2 = [], []
        for i in range(N):
            (team1 if visited[i] else team2).append(i)
        sum1 = sum(matrix[a][b] + matrix[b][a] for i, a in enumerate(team1) for b in team1[i+1:])
        sum2 = sum(matrix[a][b] + matrix[b][a] for i, a in enumerate(team2) for b in team2[i+1:])
        ans = min(ans, abs(sum1 - sum2))
        return
    for i in range(start, N):
        visited[i] = True
        dfs(i + 1, cnt + 1)
        visited[i] = False

visited[0] = True
dfs(1, 1)
print(ans)