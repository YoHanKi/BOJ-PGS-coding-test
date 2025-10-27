N = int(input())
arr = [list(input().strip()) for _ in range(N)]

def dfs(x, y, color, visited, is_colorblind):
    stack = [(x, y)]
    visited[x][y] = True

    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    while stack:
        cur_x, cur_y = stack.pop()

        for dx, dy in directions:
            nx, ny = cur_x + dx, cur_y + dy

            if 0 <= nx < N and 0 <= ny < N:
                if not visited[nx][ny]:
                    if arr[nx][ny] == color:
                        visited[nx][ny] = True
                        stack.append((nx, ny))
                    elif is_colorblind and color in ('R', 'G') and arr[nx][ny] in ('R', 'G'):
                        visited[nx][ny] = True
                        stack.append((nx, ny))
    return True

visited_normal = [[False] * N for _ in range(N)]
visited_colorblind = [[False] * N for _ in range(N)]

count_normal = 0
count_colorblind = 0
for i in range(N):
    for j in range(N):
        if not visited_normal[i][j]:
            dfs(i, j, arr[i][j], visited_normal, False)
            count_normal += 1
        if not visited_colorblind[i][j]:
            dfs(i, j, arr[i][j], visited_colorblind, True)
            count_colorblind += 1
print(count_normal, count_colorblind)