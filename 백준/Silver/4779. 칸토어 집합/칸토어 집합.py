ans = ['' for _ in range(13)]
ans[0] = '-'

for i in range(1, 13):
    ans[i] = ans[i - 1] + (' ' * (3 ** (i - 1))) + ans[i - 1]

while True:
    try:
        n = int(input())
        print(ans[n])
    except:
        break