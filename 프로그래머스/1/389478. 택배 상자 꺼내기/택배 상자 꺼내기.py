def solution(n, w, num):
    answer = 0
    h = n // w + 1
    x = 1
    cur = 0
    target = (0, 0)
    boxes = [[0] * w for _ in range(h)]
    for i in range(h):
        while True:
            if x == n + 1:
                break
            if 0 <= cur < w:
                if num == x:
                    target = (i, cur)
                boxes[i][cur] = x
                x += 1
                cur = cur + 1 if i % 2 == 0 else cur - 1
            else:
                cur = 0 if (i + 1) % 2 == 0 else w - 1
                break
    
    print(boxes)
    tx, ty = target
    for x in range(tx, h):
        if boxes[x][ty] != 0:
            answer += 1
        else:
            break
    return answer