N = int(input())
cnt = 1
passBox = 1

while passBox < N:
    passBox += cnt * 6
    cnt += 1

print(cnt)