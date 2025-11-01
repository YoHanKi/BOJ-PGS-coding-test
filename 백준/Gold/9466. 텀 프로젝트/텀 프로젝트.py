import sys

sys.setrecursionlimit(10**7)
T = int(input())

def dfs(start):
    global count
    visited[start] = True
    next_node = arr[start]

    if not visited[next_node]:
        dfs(next_node)
    else:
        if not done[next_node]:
            cycle_node = next_node
            cycle_count = 1
            while cycle_node != start:
                cycle_node = arr[cycle_node]
                cycle_count += 1
            count += cycle_count

    done[start] = True

for _ in range(T):
    n = int(input())
    arr = [0] + list(map(int, input().split()))
    visited = [False] * (n + 1)
    done = [False] * (n + 1)
    count = 0

    for i in range(1, n + 1):
        if not visited[i]:
            dfs(i)
    print(n - count)