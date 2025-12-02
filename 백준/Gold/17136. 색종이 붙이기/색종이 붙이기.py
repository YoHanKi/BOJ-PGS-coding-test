paper = [list(map(int, input().split())) for _ in range(10)]
used = [[False] * 10 for _ in range(10)]
paper_count = [0] * 6
for i in range(10):
    for j in range(10):
        if paper[i][j] == 1:
            paper_count[0] += 1

min_papers = float('inf')

def can_place(x, y, size):
    if x + size > 10 or y + size > 10:
        return False
    for i in range(x, x + size):
        for j in range(y, y + size):
            if paper[i][j] == 0 or used[i][j]:
                return False
    return True

def place(x, y, size, state):
    for i in range(x, x + size):
        for j in range(y, y + size):
            used[i][j] = state

def backtrack(pos, used_count, papers_used):
    global min_papers
    if used_count == paper_count[0]:
        if papers_used < min_papers:
            min_papers = papers_used
        return
    if papers_used >= min_papers:
        return
    for idx in range(pos, 100):
        x = idx // 10
        y = idx % 10
        if paper[x][y] == 1 and not used[x][y]:
            for size in range(5, 0, -1):
                if paper_count[size] < 5 and can_place(x, y, size):
                    place(x, y, size, True)
                    paper_count[size] += 1
                    backtrack(idx, used_count + size * size, papers_used + 1)
                    place(x, y, size, False)
                    paper_count[size] -= 1
            return

backtrack(0, 0, 0)
print(min_papers if min_papers != float('inf') else -1)