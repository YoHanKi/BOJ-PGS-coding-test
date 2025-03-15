def sumDigits(nums):
    number = str(nums)
    data = nums
    for num in number:
        data += int(num)

    return data

N = int(input())

answer = 0
for i in range(1, N + 1):
    numSum = sumDigits(i)
    if numSum == N:
        answer = i
        break

print(answer)