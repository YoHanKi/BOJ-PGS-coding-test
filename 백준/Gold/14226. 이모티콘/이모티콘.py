S = int(input())

from collections import deque
MAX = 2000
dist = [[-1] * (MAX + 1) for _ in range(MAX + 1)]
visited = [[False] * (MAX + 1) for _ in range(MAX + 1)]
dist[1][0] = 0
visited[1][0] = True
q = deque()
q.append((1, 0))

while q:
    screen, clipboard = q.popleft()
    if screen == S:
        print(dist[screen][clipboard])
        break
    # 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장
    if not visited[screen][screen]:
        visited[screen][screen] = True
        dist[screen][screen] = dist[screen][clipboard] + 1
        q.append((screen, screen))
    # 2. 클립보드에 있는 이모티콘을 화면에 붙여넣기
    if clipboard > 0 and screen + clipboard <= MAX:
        if not visited[screen + clipboard][clipboard]:
            visited[screen + clipboard][clipboard] = True
            dist[screen + clipboard][clipboard] = dist[screen][clipboard] + 1
            q.append((screen + clipboard, clipboard))
    # 3. 화면에 있는 이모티콘 중 하나를 삭제
    if screen - 1 >= 0:
        if not visited[screen - 1][clipboard]:
            visited[screen - 1][clipboard] = True
            dist[screen - 1][clipboard] = dist[screen][clipboard] + 1
            q.append((screen - 1, clipboard))