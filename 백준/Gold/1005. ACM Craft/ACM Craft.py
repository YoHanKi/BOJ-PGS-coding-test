import sys
from collections import deque

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N, K = map(int, input().split())
    build_time = [0] + list(map(int, input().split()))
    indegree = [0] * (N + 1)
    graph = [[] for _ in range(N + 1)]
    dp = [0] * (N + 1)

    for _ in range(K):
        u, v = map(int, input().split())
        graph[u].append(v)
        indegree[v] += 1

    target = int(input())
    
    dq = deque()
    # 진입차수가 0인 건물들부터 시작
    for i in range(1, N + 1):
        if indegree[i] == 0:
            dq.append(i)
            dp[i] = build_time[i]
    
    while dq:
        current = dq.popleft()
        for next_node in graph[current]:
            dp[next_node] = max(dp[next_node], dp[current] + build_time[next_node])
            indegree[next_node] -= 1
            if indegree[next_node] == 0:
                dq.append(next_node)
    
    print(dp[target])