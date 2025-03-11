answer = 0
for i in map(int, input().split()):
    answer += i ** 2

print(answer % 10)