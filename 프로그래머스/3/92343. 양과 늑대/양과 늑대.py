from collections import deque

def solution(info, edges):
    N = len(info)

    graph = [[] for _ in range(N)]
    for a, b in edges:
        graph[a].append(b)
        graph[b].append(a)


    sheep = 1
    wolf = 0
    answer = 0
    q = deque()
    q.append(({0}, sheep, wolf))

    while q:
        cur_set, cur_sheep, cur_wolf = q.popleft()
        answer = max(answer, cur_sheep)

        nxt_node = set()
        for cur_node in cur_set:
            for node in graph[cur_node]:
                if node not in cur_set:
                    nxt_node.add(node)

        for node in nxt_node:
            if info[node] == 0:
                q.append((cur_set | {node}, cur_sheep + 1, cur_wolf))
            elif info[node] == 1 and cur_sheep > cur_wolf + 1:
                q.append((cur_set | {node}, cur_sheep, cur_wolf + 1))

    return answer