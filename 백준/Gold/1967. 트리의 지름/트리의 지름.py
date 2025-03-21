import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

N = int(input())

graph = [[] for _ in range(N + 1)]

for _ in range(N - 1):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

def dfs(node, parent, cost):
    global maxCost
    if maxCost[0] < cost:
        maxCost = (cost, node)
    if visited[node]:
        return

    visited[node] = True
    for nextNode, nextCost in graph[node]:
        if nextNode == parent:
            continue
        dfs(nextNode, node, cost + nextCost)

maxCost = (0, 0)
visited = [False] * (N + 1)
dfs(1, -1, 0)

startNode = maxCost[1]
maxCost = (0, 0)
visited = [False] * (N + 1)
dfs(startNode, -1, 0)

print(maxCost[0])