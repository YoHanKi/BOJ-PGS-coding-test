def search(lev):
    global N, S, arr, choose, ans

    # base case
    if lev == N:
        if choose and sum(choose) == S:
            ans += 1
        return

    # 인덱스가 lev인 원소 선택 O
    choose.append(arr[lev])
    search(lev + 1)
    choose.pop()

    # 인덱스가 lev인 원소 선택 X
    search(lev + 1)


N, S = map(int, input().split())
arr = list(map(int, input().split()))
choose = []
ans = 0

search(0)

print(ans)