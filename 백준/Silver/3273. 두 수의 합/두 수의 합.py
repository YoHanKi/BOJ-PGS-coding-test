n = input()
arr = list(map(int, input().split()))
x = int(input())

arr.sort()

left = 0
right = len(arr) - 1
count = 0

while left < right:
    current_sum = arr[left] + arr[right]
    if current_sum == x:
        count += 1
        left += 1
        right -= 1
    elif current_sum < x:
        left += 1
    else:
        right -= 1

print(count)