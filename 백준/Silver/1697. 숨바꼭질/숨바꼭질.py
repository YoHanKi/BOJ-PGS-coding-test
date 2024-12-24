from collections import deque

def bfs():
    global visited, N, K

    q = deque()

    q.append((0, N))
    visited[N] = True

    while q:
        step, pos = q.popleft()

        if pos == K:
            return step

        for next_pos in [pos - 1, pos + 1, pos * 2]:
            if 0 <= next_pos <= MAX and not visited[next_pos]:
                visited[next_pos] = True
                q.append((step + 1, next_pos))

MAX = int(1e5)

N, K = map(int, input().split())

visited = [False] * (MAX + 1)

print(bfs())