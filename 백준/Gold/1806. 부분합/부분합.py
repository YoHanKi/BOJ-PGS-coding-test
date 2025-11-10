import sys
input = sys.stdin.readline
N, S = map(int, input().split())
arr = list(map(int, input().split()))

left, right = 0, 0
current_sum = 0
min_length = float('inf')

while True:
    if current_sum >= S:
        min_length = min(min_length, right - left)
        current_sum -= arr[left]
        left += 1
    elif right == N:
        break
    else:
        current_sum += arr[right]
        right += 1

print(min_length if min_length != float('inf') else 0)