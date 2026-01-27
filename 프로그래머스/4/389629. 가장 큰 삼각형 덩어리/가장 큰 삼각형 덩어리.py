def solution(grid):
    n = len(grid)
    m = len(grid[0])
    nm = n * m
    V = 2 * nm

    neigh1 = [-1] * V
    neigh2 = [-1] * V
    deg = [0] * V

    def add_edge(u, v):
        du = deg[u]
        if du == 0:
            neigh1[u] = v
        else:
            neigh2[u] = v
        deg[u] = du + 1

        dv = deg[v]
        if dv == 0:
            neigh1[v] = u
        else:
            neigh2[v] = u
        deg[v] = dv + 1

    # helper: which option touches Left/Right
    # opt0 = "top triangle", opt1 = "bottom triangle"
    # For '/'(1):  opt0 touches L, opt1 touches R
    # For '\ '(-1): opt1 touches L, opt0 touches R
    def opt_touch_R(val):  # triangle option index that touches Right side
        return 1 if val == 1 else 0

    def opt_touch_L(val):  # triangle option index that touches Left side
        return 0 if val == 1 else 1
    
    for i in range(n):
        row = grid[i]
        for j in range(m):
            idx = i * m + j

            if j + 1 < m:
                idx2 = idx + 1
                u = 2 * idx + opt_touch_R(row[j])
                v = 2 * idx2 + opt_touch_L(row[j + 1])
                add_edge(u, v)

            if i + 1 < n:
                idx2 = idx + m
                u = 2 * idx + 1
                v = 2 * idx2 + 0 
                add_edge(u, v)

    visited = [False] * V
    ans = 1

    def longest_unique_segment_path(order):
        last = {}
        l = 0
        best = 0
        for r, node in enumerate(order):
            cid = node // 2
            p = last.get(cid, -1)
            if p >= l:
                l = p + 1
            last[cid] = r
            cur = r - l + 1
            if cur > best:
                best = cur
        return best

    def longest_unique_segment_cycle(order):
        L = len(order)
        if L == 1:
            return 1
        arr = order + order
        last = {}
        l = 0
        best = 0
        for r, node in enumerate(arr):
            cid = node // 2
            p = last.get(cid, -1)
            if p >= l:
                l = p + 1
            last[cid] = r

            if r - l + 1 > L:
                l = r - L + 1

            cur = r - l + 1
            if cur > best:
                best = cur
        return best

    for s in range(V):
        if visited[s]:
            continue

        start = s
        prev = -1
        cur = s
        while deg[cur] == 2:
            a = neigh1[cur]
            b = neigh2[cur]
            nxt = a if a != prev else b
            prev, cur = cur, nxt
            if cur == start:
                break

        is_cycle = (cur == start and deg[start] == 2)
        if not is_cycle:
            start = cur

        order = []
        prev = -1
        cur = start
        while True:
            order.append(cur)
            visited[cur] = True

            if deg[cur] == 0:
                break

            if deg[cur] == 1:
                nxt = neigh1[cur]
                if nxt == prev:
                    break
            else:
                a = neigh1[cur]
                b = neigh2[cur]
                nxt = a if a != prev else b

            prev, cur = cur, nxt
            if cur == -1 or visited[cur]:
                break

        if is_cycle:
            best = longest_unique_segment_cycle(order)
        else:
            best = longest_unique_segment_path(order)

        if best > ans:
            ans = best

    return ans