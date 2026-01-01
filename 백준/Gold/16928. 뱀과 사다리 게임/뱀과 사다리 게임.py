from collections import deque

board = [[0, 0] for _ in range(101)] # 0: 빈칸, 1: 사다리, 2: 뱀, 2-index : 이동 위치
N, M = map(int, input().split())

for _ in range(N):
    fr, to = map(int, input().split())
    board[fr] = [1, to]

for _ in range(M):
    fr, to = map(int, input().split())
    board[fr] = [2, to]

q = deque([(1, 0)])  # 1번 칸에서 시작
board[1][0] = -1

while q:
    pos, cnt = q.popleft()
    if pos == 100:
        print(cnt)
        break
    for d in range(1, 7):
        nxt = pos + d
        if nxt > 100 or board[nxt][0] == -1:
            continue
        if board[nxt][0] in (1, 2):  # 사다리 또는 뱀
            nxt = board[nxt][1]
        if board[nxt][0] == 0:
            board[nxt][0] = -1  # 중복 방문 방지
            q.append((nxt, cnt + 1))