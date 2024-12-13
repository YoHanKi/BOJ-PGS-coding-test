def is_exist(A, m):
    left = 0
    right = len(A) - 1

    while left <= right:
        mid = (left + right) // 2
        
        if A[mid] < m:
            left = mid + 1
            
        if A[mid] > m:
            right = mid - 1

        elif A[mid] == m:
            return 1

    return 0

N = int(input())

A = sorted(list(map(int, input().split())))

M = int(input())

for m in map(int, input().split()):
    print(is_exist(A, m))