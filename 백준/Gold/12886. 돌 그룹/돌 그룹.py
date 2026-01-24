from collections import deque

A, B, C = map(int, input().split())

# 3개중 각각 다른 값 두 그룹을 백 트래킹을 통해 찾음
S = A + B + C

if S % 3 != 0:
    print(0)
    exit()

visited = [[False] * S for _ in range(S)]
q = deque()
q.append((A, B))
visited[A][B] = True

while q:
    a, b = q.popleft()
    c = S - a - b

    for x, y in [(a, b), (b, c), (c, a)]:
        if x == y:
            continue
        if x > y:
            x, y = y, x
        if not visited[x+x][y-x]:
            visited[x+x][y-x] = True
            q.append((x+x, y-x))

if visited[S // 3][S // 3]:
    print(1)
else:
    print(0)