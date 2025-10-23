import sys
from collections import deque

N = int(sys.stdin.readline())
tree = [[-1, -1, -1] for _ in range(N + 1)]

for i in range(N):
    node, left, right = map(int, sys.stdin.readline().split())
    tree[node][1] = left
    tree[node][2] = right
    tree[left][0] = N
    tree[right][0] = N

root = -1
for i in range(1, N + 1):
    if tree[i][0] == -1:
        root = i

visit = [[-1, -1] for _ in range(N + 1)] # r: level, c: dist

def bfs():
    global root
    depth = 0
    queue = deque([root])
    visit[root][0] = 0
    while queue:
        cur_node = queue.popleft()
        cur_left = tree[cur_node][1]
        cur_right = tree[cur_node][2]
        for direct in [cur_left, cur_right]:
            if direct != -1 and visit[direct][0] == -1:
                visit[direct][0] = visit[cur_node][0] + 1
                depth = max(visit[direct][0], depth)
                queue.append(direct)
    return depth

def node_search(cur_node):
    global dist
    if tree[cur_node][1] != -1:
        node_search(tree[cur_node][1])
        
    dist += 1
    visit[cur_node][1] = dist

    if tree[cur_node][2] != -1:
        node_search(tree[cur_node][2])

dist = 0
max_depth = bfs()
node_search(root)
max_dist = 0
min_level = 1e10

if N == 1:
    print(1, 1)

else:
    for d in range(max_depth + 1):
        min_val = 1e10
        max_val = 0
        for i in range(1, N + 1):
            if d == visit[i][0]:
                min_val = min(visit[i][1], min_val)
                max_val = max(visit[i][1], max_val)
        if max_dist < max_val-min_val+1:
            min_level = d + 1
            max_dist = max_val - min_val + 1

    print(min_level, max_dist)
