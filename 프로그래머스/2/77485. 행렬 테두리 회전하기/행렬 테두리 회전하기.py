def rotate(y1, x1, y2, x2):
    global matrix

    arr = []
    for x in range(x1, x2 + 1):
        arr.append([y1, x])
    for y in range(y1 + 1, y2 + 1):
        arr.append([y, x2])
    for x in range(x2 - 1, x1 - 1, -1):
        arr.append([y2, x])
    for y in range(y2 - 1, y1, -1):
        arr.append([y, x1])
    N = len(arr)

    for i in range(N - 1, 0, -1):
        a, b = arr[i][0], arr[i][1]
        c, d = arr[i - 1][0], arr[i - 1][1]
        matrix[a][b], matrix[c][d] = matrix[c][d], matrix[a][b]

    return min(matrix[y][x] for y, x in arr)

def solution(rows, columns, queries):
    global matrix

    matrix = [[0] * columns for _ in range(rows)]

    count = 1
    for y in range(rows):
        for x in range(columns):
            matrix[y][x] = count
            count += 1

    answer = []
    for y1, x1, y2, x2 in queries:
        answer.append(rotate(y1 -1, x1 - 1, y2 - 1, x2 - 1))

    return answer