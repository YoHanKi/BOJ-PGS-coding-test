N = int(input())
arr = [tuple(map(int, input().split())) for _ in range(N)]

def comp(x):
    return x[1] * x[2] * x[3], x[1] + x[2] + x[3], x[0]

arr = sorted(arr, key = comp)

for a, b, c ,d in arr[:3]:
    print(a, end=' ')