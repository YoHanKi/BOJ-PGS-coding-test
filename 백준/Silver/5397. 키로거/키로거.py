from collections import deque

N = int(input())

for _ in range(N):
    L = list(input().strip())

    left = deque()
    right = deque()

    for char in L:
        if char == '<':
            if left:
                right.appendleft(left.pop())
        elif char == '>':
            if right:
                left.append(right.popleft())
        elif char == '-':
            if left:
                left.pop()
        else:
            left.append(char)

    left.extend(right)
    print(''.join(left))