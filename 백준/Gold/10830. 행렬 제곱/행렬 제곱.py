N, B = map(int, input().split())

def matrix_mult(A, B):
    n = len(A)
    m = len(B[0])
    p = len(B)
    result = [[0] * m for _ in range(n)]

    for i in range(n):
        for j in range(m):
            for k in range(p):
                result[i][j] += A[i][k] * B[k][j]
                result[i][j] %= 1000
    return result

def matrix_pow(matrix, exp):
    n = len(matrix)
    result = [[1 if i == j else 0 for j in range(n)] for i in range(n)]

    while exp:
        if exp % 2 == 1:
            result = matrix_mult(result, matrix)
        matrix = matrix_mult(matrix, matrix)
        exp //= 2

    return result

matrix = []
for _ in range(N):
    matrix.append(list(map(int, input().split())))

result = matrix_pow(matrix, B)

for row in result:
    print(*row)