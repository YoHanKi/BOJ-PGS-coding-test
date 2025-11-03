N, M, K = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(N)]

directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
max_sum = -10**9

def backtrack(count, current_sum, visited, start):
    global max_sum

    if count == K:
        max_sum = max(max_sum, current_sum)
        return

    for idx in range(start, N * M):
        i = idx // M
        j = idx % M
        if visited[i][j]:
            continue

        can_place = True
        for di, dj in directions:
            ni, nj = i + di, j + dj
            if 0 <= ni < N and 0 <= nj < M and visited[ni][nj]:
                can_place = False
                break

        if can_place:
            visited[i][j] = True
            backtrack(count + 1, current_sum + grid[i][j], visited, idx + 1)
            visited[i][j] = False

visited = [[False] * M for _ in range(N)]
backtrack(0, 0, visited, 0)
print(max_sum)